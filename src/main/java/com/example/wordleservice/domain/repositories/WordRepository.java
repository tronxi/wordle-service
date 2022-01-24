package com.example.wordleservice.domain.repositories;

import com.example.wordleservice.domain.model.Word;

import java.time.LocalDate;

public interface WordRepository {
    Word findByDate(LocalDate date);
}
