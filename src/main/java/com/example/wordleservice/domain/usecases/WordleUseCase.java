package com.example.wordleservice.domain.usecases;

import com.example.wordleservice.domain.model.*;
import com.example.wordleservice.domain.repositories.DictionaryRepository;
import com.example.wordleservice.domain.services.TodayWordRetriever;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordleUseCase {
    private final TodayWordRetriever todayWordRetriever;
    private final DictionaryRepository dictionaryRepository;

    public WordleUseCase(TodayWordRetriever todayWordRetriever, DictionaryRepository dictionaryRepository) {
        this.todayWordRetriever = todayWordRetriever;
        this.dictionaryRepository = dictionaryRepository;
    }

    public WordleResult perform(Wordle wordle) {
        Optional<Word> maybeWord = dictionaryRepository.findWord(wordle);
        if(maybeWord.isEmpty()) return new WordleResult(Collections.emptyList(), WordleStatus.Invalid);
        Word word = todayWordRetriever.retrieve();
        return compare(wordle, word);
    }

    private WordleResult compare(Wordle wordle, Word word) {
        List<Character> wordleLetters = wordle.getLetters();
        List<LetterStatus> letterStatusList = new ArrayList<>();
        Map<Character, Integer> numMarked = new HashMap<>();
        for (int i = 0; i < wordleLetters.size(); i++) {
            Character letter = wordleLetters.get(i);
            if(word.containLetterInPosition(letter, i)) {
                letterStatusList.add(LetterStatus.Ordered);
                numMarked.put(letter, numMarked.getOrDefault(letter, 0) + 1 );
            } else if(word.contain(letter) && sameOccurrencesFromLetter(wordle, word, letter)) {
                numMarked.put(letter, numMarked.getOrDefault(letter, 0) + 1 );
                letterStatusList.add(LetterStatus.Unordered);
            } else if(word.contain(letter)
                    && numMarked.getOrDefault(letter, 0) < word.numOccurrences(letter)
                    && !containLetterWithOrden(wordle, word, letter)) {
                numMarked.put(letter, numMarked.getOrDefault(letter, 0) + 1 );
                letterStatusList.add(LetterStatus.Unordered);
            } else {
                letterStatusList.add(LetterStatus.Fail);
            }
        }
        return new WordleResult(letterStatusList, generateStatus(letterStatusList));
    }

    private boolean containLetterWithOrden(Wordle wordle, Word word, Character letter) {
        List<Character> wordleLetters = wordle.getLetters();
        for (int i = 0; i < wordleLetters.size(); i++) {
            Character actualLetter = wordleLetters.get(i);
            if(letter.equals(actualLetter) && word.containLetterInPosition(actualLetter, i)){
                return true;
            }
        }
        return false;
    }

    private Boolean sameOccurrencesFromLetter(Wordle wordle, Word word, Character letter) {
        return Objects.equals(wordle.numOccurrences(letter), word.numOccurrences(letter));
    }

    private WordleStatus generateStatus(List<LetterStatus> letterStatusList) {
        if(letterStatusList.contains(LetterStatus.Fail) || letterStatusList.contains(LetterStatus.Unordered))
            return WordleStatus.Pending;
        return WordleStatus.Completed;
    }
}
