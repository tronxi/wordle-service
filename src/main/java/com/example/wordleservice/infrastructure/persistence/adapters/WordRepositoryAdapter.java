package com.example.wordleservice.infrastructure.persistence.adapters;

import com.example.wordleservice.domain.model.Word;
import com.example.wordleservice.domain.repositories.WordRepository;
import com.example.wordleservice.infrastructure.persistence.entity.WordEntity;
import com.example.wordleservice.infrastructure.persistence.jpa.WordJPA;
import com.example.wordleservice.infrastructure.persistence.mappers.WordEntityMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class WordRepositoryAdapter implements WordRepository {

    private final WordJPA wordJPA;
    private final WordEntityMapper wordEntityMapper;

    public WordRepositoryAdapter(WordJPA wordJPA, WordEntityMapper wordEntityMapper) {
        this.wordJPA = wordJPA;
        this.wordEntityMapper = wordEntityMapper;
    }

    @Override
    public Word findByDate(LocalDate date) {
        WordEntity wordEntity = wordJPA.findByDay(date)
                .orElse(defaultWord());
        return wordEntityMapper.toDomain(wordEntity);
    }

    private WordEntity defaultWord() {
        WordEntity wordEntity = new WordEntity();
        wordEntity.setWord("fallo");
        return wordEntity;
    }
}
