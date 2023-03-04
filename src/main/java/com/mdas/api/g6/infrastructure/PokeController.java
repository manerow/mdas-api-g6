package com.mdas.api.g6.infrastructure;

import com.mdas.api.g6.application.PokeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/pokemon")
@Slf4j
@RequiredArgsConstructor
public class PokeController {

    private final PokeService pokeService;

    @GetMapping(value = "/getType")
    public ResponseEntity<?> getPokemon(@RequestParam(value = "pokemonName") String pokemonName) {
        try {
            return ResponseEntity.ok(pokeService.getPokemonType(pokemonName).getBody());
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon no encontrado!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al recuperar pokemon!");
        }
    }

}
