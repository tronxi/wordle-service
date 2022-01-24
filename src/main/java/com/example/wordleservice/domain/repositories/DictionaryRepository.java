package com.example.wordleservice.domain.repositories;

import com.example.wordleservice.domain.model.Word;
import com.example.wordleservice.domain.model.Wordle;

import java.util.Optional;

public interface DictionaryRepository {
    Optional<Word> findWord(Wordle wordle);
}
