package com.mdas.api.g6.pokemon.infrastructure.http.pokeapi.mapper;

import com.mdas.api.g6.pokemon.domain.Pokemon;
import com.mdas.api.g6.pokemon.infrastructure.http.pokeapi.entity.PokemonApiEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonApiMapper {
    Pokemon toDomain(PokemonApiEntity pokeApiPokemonEntity);
}

