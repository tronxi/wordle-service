package com.example.wordleservice.infrastructure.persistence.jpa;

import com.example.wordleservice.infrastructure.persistence.entity.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface WordJPA extends JpaRepository<WordEntity, Long> {
    Optional<WordEntity> findByDay(LocalDate day);
}
