package com.mdas.api.g6.infrastructure.http.pokeapi.repository;

import com.mdas.api.g6.infrastructure.http.pokeapi.entity.PokemonApiEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class PokemonHttpRepository {

    private final RestTemplate restTemplate;
    @Value("${pokeapi.base-url}")
    private String baseUrl;

    public PokemonApiEntity getPokemonByName(String name) {
        String url = baseUrl + "/pokemon/" + name;
        ResponseEntity<PokemonApiEntity> response = restTemplate.getForEntity(url, PokemonApiEntity.class);
        return response.getBody();
    }
}
