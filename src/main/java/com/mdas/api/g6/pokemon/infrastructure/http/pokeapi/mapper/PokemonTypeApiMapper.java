package com.mdas.api.g6.pokemon.infrastructure.http.pokeapi.mapper;

import com.mdas.api.g6.pokemon.domain.valueobject.PokemonType;
import com.mdas.api.g6.pokemon.infrastructure.http.pokeapi.entity.PokemonTypeApiEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonTypeApiMapper {
    PokemonType toDomain(PokemonTypeApiEntity pokemonTypeApiEntity);
}
