package com.mdas.api.g6.domain.repository;

import com.mdas.api.g6.infrastructure.dto.PokeResponseDto;

public interface SupportGetPoke {

    PokeResponseDto getPokemonType(String name);
}
