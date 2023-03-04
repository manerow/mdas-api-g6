package com.mdas.api.g6.infrastructure.http.pokeapi.mapper;

import com.mdas.api.g6.domain.Pokemon;
import com.mdas.api.g6.infrastructure.http.pokeapi.entity.PokemonApiEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonApiMapper {
    Pokemon toDomain(PokemonApiEntity pokeApiPokemonEntity);
}

