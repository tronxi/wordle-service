package com.example.wordleservice.infrastructure.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "dictionaryWord", indexes = @Index(columnList = "word"))
public class DictionaryWordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String word;

    public DictionaryWordEntity() {
    }

    public DictionaryWordEntity(Long id, String word) {
        this.id = id;
        this.word = word;
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
}
