package com.example.wordleservice.infrastructure.persistence.mappers;

import com.example.wordleservice.domain.model.Word;
import com.example.wordleservice.infrastructure.persistence.entity.DictionaryWordEntity;
import com.example.wordleservice.infrastructure.persistence.entity.WordEntity;
import org.springframework.stereotype.Component;

@Component
public class WordEntityMapper {
    public Word toDomain(WordEntity wordEntity) {
        return new Word(wordEntity.getWord());
    }
    public Word toDomain(DictionaryWordEntity wordEntity) {
        return new Word(wordEntity.getWord());
    }
}
