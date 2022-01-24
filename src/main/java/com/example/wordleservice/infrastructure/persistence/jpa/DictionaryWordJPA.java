package com.example.wordleservice.infrastructure.persistence.jpa;

import com.example.wordleservice.infrastructure.persistence.entity.DictionaryWordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DictionaryWordJPA extends JpaRepository<DictionaryWordEntity, Long> {
    Optional<DictionaryWordEntity> findDictionaryWordEntityByWord(String word);
}
