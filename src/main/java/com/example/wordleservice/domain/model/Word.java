package com.example.wordleservice.domain.model;

import java.util.List;
import java.util.stream.Collectors;

public class Word {
    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public Boolean containLetterInPosition(Character letter, int position) {
        return letters().get(position).equals(letter);
    }

    public Boolean contain(Character letter) {
        return letters().contains(letter);
    }

    private List<Character> letters() {
        return word.chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());
    }
}
