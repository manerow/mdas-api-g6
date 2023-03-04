package com.mdas.api.g6.domain.repository;

import com.mdas.api.g6.domain.Pokemon;

public interface PokemonRepositoryPort {
    Pokemon getPokemonByName(String name) throws Exception;
}
