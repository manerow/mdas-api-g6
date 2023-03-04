package com.mdas.api.g6.application.impl;

import com.mdas.api.g6.application.PokeService;
import com.mdas.api.g6.domain.repository.SupportGetPoke;
import com.mdas.api.g6.infrastructure.adapters.PokeAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PokeServiceImpl implements PokeService {

  private final SupportGetPoke supportGetPoke;

  @Override
  public ResponseEntity<?> getPokemonType(String name){
     return ResponseEntity.ok(PokeAdapter.pokeResponseDtoDtoToPokemon(supportGetPoke.getPokemonType(name)));
  }
}
