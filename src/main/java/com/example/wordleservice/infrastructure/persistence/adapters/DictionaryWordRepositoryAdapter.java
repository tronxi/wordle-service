package com.example.wordleservice.infrastructure.persistence.adapters;

import com.example.wordleservice.domain.model.Word;
import com.example.wordleservice.domain.model.Wordle;
import com.example.wordleservice.domain.repositories.DictionaryRepository;
import com.example.wordleservice.infrastructure.persistence.jpa.DictionaryWordJPA;
import com.example.wordleservice.infrastructure.persistence.mappers.WordEntityMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DictionaryWordRepositoryAdapter implements DictionaryRepository {

    private final DictionaryWordJPA dictionaryWordJPA;
    private final WordEntityMapper wordEntityMapper;

    public DictionaryWordRepositoryAdapter(DictionaryWordJPA dictionaryWordJPA, WordEntityMapper wordEntityMapper) {
        this.dictionaryWordJPA = dictionaryWordJPA;
        this.wordEntityMapper = wordEntityMapper;
    }

    @Override
    public Optional<Word> findWord(Wordle wordle) {
        return dictionaryWordJPA
                .findDictionaryWordEntityByWord(wordle.getValue())
                .map(wordEntityMapper::toDomain);
    }
}
