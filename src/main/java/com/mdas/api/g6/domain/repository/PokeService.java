package com.mdas.api.g6.domain.repository;

import org.springframework.http.ResponseEntity;

public interface PokeService {

    ResponseEntity<?> getPokemonType(String name);
}
