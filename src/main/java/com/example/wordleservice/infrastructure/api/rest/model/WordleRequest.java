package com.example.wordleservice.infrastructure.api.rest.model;

import java.util.List;

public class WordleRequest {
    private List<Character> letters;

    public List<Character> getLetters() {
        return letters;
    }

    public void setLetters(List<Character> letters) {
        this.letters = letters;
    }
}
