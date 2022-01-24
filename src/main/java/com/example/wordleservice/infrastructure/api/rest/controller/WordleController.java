package com.example.wordleservice.infrastructure.api.rest.controller;

import com.example.wordleservice.domain.model.Wordle;
import com.example.wordleservice.domain.model.WordleResult;
import com.example.wordleservice.domain.usecases.WordleUseCase;
import com.example.wordleservice.infrastructure.api.rest.mapper.WordleMapper;
import com.example.wordleservice.infrastructure.api.rest.model.WordleRequest;
import com.example.wordleservice.infrastructure.api.rest.model.WordleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wordle")
public class WordleController {

    private final WordleMapper wordleMapper;
    private final WordleUseCase wordleUseCase;

    public WordleController(WordleMapper wordleMapper, WordleUseCase wordleUseCase) {
        this.wordleMapper = wordleMapper;
        this.wordleUseCase = wordleUseCase;
    }

    @PostMapping
    public ResponseEntity<WordleResponse> wordle(@RequestBody WordleRequest wordleRequest) {
        Wordle wordle = wordleMapper.toDomain(wordleRequest);
        WordleResult wordleResult = wordleUseCase.perform(wordle);
        return ResponseEntity.ok(wordleMapper.toResponse(wordleResult));
    }
}
