package com.mdas.api.g6.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Pokemon {
    private String name;
    private List<String> types;
}
