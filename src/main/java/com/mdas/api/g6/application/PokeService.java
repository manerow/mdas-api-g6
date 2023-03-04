package com.mdas.api.g6.application;

import org.springframework.http.ResponseEntity;

public interface PokeService {

    ResponseEntity<?> getPokemonType(String name);
}
