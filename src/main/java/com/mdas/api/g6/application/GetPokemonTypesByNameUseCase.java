package com.mdas.api.g6.application;

import com.mdas.api.g6.domain.Pokemon;
import com.mdas.api.g6.domain.valueobject.PokemonType;
import com.mdas.api.g6.domain.repository.PokemonRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GetPokemonTypesByNameUseCase {

    private final PokemonRepositoryPort pokemonRepository;

    public List<PokemonType> execute(String pokemonName) throws Exception {
        Pokemon pokemon = pokemonRepository.getPokemonByName(pokemonName);
        return pokemon.getTypes();
    }
}
