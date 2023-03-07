package com.mdas.api.g6.application;

import com.mdas.api.g6.domain.valueobject.PokemonType;
import java.util.List;

public interface GetConsolePokemonTypesByName {

    List<PokemonType> execute(String pokemonName) throws Exception;
}
