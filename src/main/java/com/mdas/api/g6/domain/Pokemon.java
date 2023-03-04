package com.mdas.api.g6.domain;

import com.mdas.api.g6.domain.valueobject.PokemonType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Pokemon {
    private Integer id;
    private String name;
    private List<PokemonType> types;
}
