package com.mdas.api.g6.infrastructure.adapters;

import com.mdas.api.g6.domain.model.Pokemon;
import com.mdas.api.g6.infrastructure.dto.PokeResponseDto;
import java.util.ArrayList;

public class PokeAdapter {

  public static Pokemon pokeResponseDtoDtoToPokemon(PokeResponseDto pokeResponseDto) {

    Pokemon result = new Pokemon();
    result.setName(pokeResponseDto.getSpecies().getName());
    result.setType(new ArrayList<>());
    pokeResponseDto.getTypes().forEach(x ->{
      result.getType().add(x.getType().getName());
    });

    return result;
  }
}
