package com.example.wordleservice.domain.model;

import java.util.List;

public class WordleResult {
    private final List<LetterStatus> letterStatusList;
    private final WordleStatus wordleStatus;

    public WordleResult(List<LetterStatus> letterStatusList, WordleStatus wordleStatus) {
        this.letterStatusList = letterStatusList;
        this.wordleStatus = wordleStatus;
    }

    public List<LetterStatus> getWordStatusList() {
        return letterStatusList;
    }

    public WordleStatus getWordleStatus() {
        return wordleStatus;
    }
}
