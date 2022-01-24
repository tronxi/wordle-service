package com.example.wordleservice.domain.services;

import com.example.wordleservice.domain.model.Word;
import com.example.wordleservice.domain.repositories.WordRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TodayWordRetriever {
    private final WordRepository wordRepository;

    public TodayWordRetriever(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word retrieve() {
        LocalDate today = LocalDate.now();
        return wordRepository.findByDate(today);
    }
}
