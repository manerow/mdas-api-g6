package com.mdas.api.g6.infrastructure.http.pokeapi.adapter;

import com.mdas.api.g6.domain.Pokemon;
import com.mdas.api.g6.domain.repository.PokemonRepositoryPort;
import com.mdas.api.g6.infrastructure.http.pokeapi.repository.PokemonHttpRepository;
import com.mdas.api.g6.infrastructure.http.pokeapi.entity.PokemonApiEntity;
import com.mdas.api.g6.infrastructure.http.pokeapi.mapper.PokemonApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PokeApiRepositoryAdapter implements PokemonRepositoryPort {

    private final PokemonHttpRepository pokeApiHttpRepository;
    private final PokemonApiMapper pokemonApiMapper;

    @Override
    public Pokemon getPokemonByName(String name) {
        PokemonApiEntity pokeApiPokemonEntity = pokeApiHttpRepository.getPokemonByName(name);
        return pokemonApiMapper.toDomain(pokeApiPokemonEntity);
    }
}
