package com.example.wordleservice.domain.usecases;

import com.example.wordleservice.domain.model.*;
import com.example.wordleservice.domain.services.TodayWordRetriever;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordleUseCase {
    private final TodayWordRetriever todayWordRetriever;

    public WordleUseCase(TodayWordRetriever todayWordRetriever) {
        this.todayWordRetriever = todayWordRetriever;
    }

    public WordleResult perform(Wordle wordle) {
        Word word = todayWordRetriever.retrieve();
        return compare(wordle, word);
    }

    private WordleResult compare(Wordle wordle, Word word) {
        List<Character> wordleLetters = wordle.getLetters();
        List<LetterStatus> letterStatusList = new ArrayList<>();

        for (int i = 0; i < wordleLetters.size(); i++) {
            Character letter = wordleLetters.get(i);
            if(word.containLetterInPosition(letter, i)) {
                letterStatusList.add(LetterStatus.Ordered);
            } else if(word.contain(letter)) {
                letterStatusList.add(LetterStatus.Unordered);
            } else {
                letterStatusList.add(LetterStatus.Fail);
            }
        }
        return new WordleResult(letterStatusList, generateStatus(letterStatusList));
    }

    private WordleStatus generateStatus(List<LetterStatus> letterStatusList) {
        if(letterStatusList.contains(LetterStatus.Fail) || letterStatusList.contains(LetterStatus.Unordered))
            return WordleStatus.Pending;
        return WordleStatus.Completed;
    }
}
