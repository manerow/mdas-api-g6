package com.mdas.api.g6.infrastructure.http.pokeapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class PokemonTypeApiEntity {
    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;
}
