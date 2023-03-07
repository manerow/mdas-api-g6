package com.mdas.api.g6.application.impl;

import com.mdas.api.g6.application.GetApiPokemonTypesByName;
import com.mdas.api.g6.domain.repository.PokemonRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetApiPokemonTypesByNameImpl implements GetApiPokemonTypesByName {

    private final PokemonRepositoryPort pokemonRepository;

    @Override
    public ResponseEntity<?> getPokemonType(String name) throws Exception {
        return ResponseEntity.ok(pokemonRepository.getPokemonByName(name));
    }
}
