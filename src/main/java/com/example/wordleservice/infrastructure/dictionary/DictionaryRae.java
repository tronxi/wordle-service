package com.example.wordleservice.infrastructure.dictionary;

import com.example.wordleservice.domain.model.Word;
import com.example.wordleservice.domain.model.Wordle;
import com.example.wordleservice.domain.repositories.DictionaryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class DictionaryRae implements DictionaryRepository {
    private static final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Optional<Word> findWord(Wordle wordle) {
        try {
            String url = "https://www.diccionarios.com/diccionario/espanol/";
            ResponseEntity<String> response = restTemplate.getForEntity(url + wordle.getValue(), String.class);
            if(response.getBody() == null) return Optional.empty();
            if(response.getBody().contains("No se ha encontrado la palabra exacta")) return Optional.empty();
            if(response.getBody().contains("no se encuentra en este diccionario")) return Optional.empty();
            return Optional.of(new Word(wordle.getValue()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
