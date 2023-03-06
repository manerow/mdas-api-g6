package com.mdas.api.g6.infrastructure.http.pokeapi.mapper;

import com.mdas.api.g6.domain.valueobject.PokemonType;
import com.mdas.api.g6.infrastructure.http.pokeapi.entity.PokemonTypeApiEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonTypeApiMapper {
    PokemonType toDomain(PokemonTypeApiEntity pokemonTypeApiEntity);
}
