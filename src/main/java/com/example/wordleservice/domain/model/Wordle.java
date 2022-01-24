package com.example.wordleservice.domain.model;

import com.example.wordleservice.domain.exception.InvalidFormatException;

import java.util.List;

public class Wordle {
    private final int WORDLE_SIZE = 5;
    private final List<Character> letters;

    public Wordle(List<Character> letters) {
        if(letters.size() != WORDLE_SIZE) throw new InvalidFormatException();
        this.letters = letters;
    }

    public List<Character> getLetters() {
        return letters;
    }
}
