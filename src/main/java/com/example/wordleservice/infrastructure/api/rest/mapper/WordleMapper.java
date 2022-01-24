package com.example.wordleservice.infrastructure.api.rest.mapper;

import com.example.wordleservice.domain.model.Wordle;
import com.example.wordleservice.domain.model.WordleResult;
import com.example.wordleservice.infrastructure.api.rest.model.WordleRequest;
import com.example.wordleservice.infrastructure.api.rest.model.WordleResponse;
import org.springframework.stereotype.Component;

@Component
public class WordleMapper {
    public Wordle toDomain(WordleRequest wordleRequest) {
        return new Wordle(wordleRequest.getLetters());
    }

    public WordleResponse toResponse(WordleResult wordleResult) {
        return new WordleResponse(wordleResult.getWordStatusList(), wordleResult.getWordleStatus());
    }
}
