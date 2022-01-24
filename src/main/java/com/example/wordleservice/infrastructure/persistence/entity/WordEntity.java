package com.example.wordleservice.infrastructure.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "word")
public class WordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String word;

    @Column
    private LocalDate day;

    public WordEntity(Long id, String word, LocalDate day) {
        this.id = id;
        this.word = word;
        this.day = day;
    }

    public WordEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
