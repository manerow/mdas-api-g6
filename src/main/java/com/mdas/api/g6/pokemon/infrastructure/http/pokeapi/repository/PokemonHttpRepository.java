package com.mdas.api.g6.pokemon.infrastructure.http.pokeapi.repository;

import com.mdas.api.g6.pokemon.domain.exception.PokeApiConnectionErrorException;
import com.mdas.api.g6.pokemon.domain.exception.PokemonNotFoundException;
import com.mdas.api.g6.pokemon.domain.valueobject.PokemonName;
import com.mdas.api.g6.pokemon.infrastructure.http.pokeapi.entity.PokemonApiEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.*;

@Component
@RequiredArgsConstructor
public class PokemonHttpRepository {

    private RestTemplate restTemplate = new RestTemplate();
    @Value("${pokeapi.url}")
    private String baseUrl;

    public PokemonApiEntity getPokemonByName(PokemonName pokemonName) throws PokemonNotFoundException, PokeApiConnectionErrorException {
        String url = baseUrl + "/pokemon/" + pokemonName.getName();
        try {
            ResponseEntity<PokemonApiEntity> response = restTemplate.getForEntity(url, PokemonApiEntity.class);
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new PokemonNotFoundException();
        } catch (RestClientException e) {
            throw new PokeApiConnectionErrorException();
        }
    }
}
