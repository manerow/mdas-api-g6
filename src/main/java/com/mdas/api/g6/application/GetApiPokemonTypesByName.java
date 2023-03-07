package com.mdas.api.g6.application;

import org.springframework.http.ResponseEntity;

public interface GetApiPokemonTypesByName {

    ResponseEntity<?> getPokemonType(String name) throws Exception;
}
