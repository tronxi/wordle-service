package com.example.wordleservice.infrastructure.api.rest.model;

import com.example.wordleservice.domain.model.LetterStatus;
import com.example.wordleservice.domain.model.WordleStatus;

import java.util.List;

public class WordleResponse {
    private List<LetterStatus> letterStatus;
    private WordleStatus wordleStatus;

    public WordleResponse(List<LetterStatus> letterStatus, WordleStatus wordleStatus) {
        this.letterStatus = letterStatus;
        this.wordleStatus = wordleStatus;
    }

    public WordleResponse() {
    }

    public List<LetterStatus> getLetterStatusList() {
        return letterStatus;
    }

    public void setLetterStatusList(List<LetterStatus> status) {
        this.letterStatus = status;
    }

    public WordleStatus getWordleStatus() {
        return wordleStatus;
    }

    public void setWordleStatus(WordleStatus wordleStatus) {
        this.wordleStatus = wordleStatus;
    }
}
