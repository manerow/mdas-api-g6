package com.mdas.api.g6.pokemon.infrastructure.http.pokeapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonDeserialize(using = PokemonTypeApiEntityDeserializer.class)
public class PokemonTypeApiEntity {
    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;
}

class PokemonTypeApiEntityDeserializer extends JsonDeserializer<PokemonTypeApiEntity> {
    @Override
    public PokemonTypeApiEntity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);
        String name = node.get("type").get("name").asText();
        String url = node.get("type").get("url").asText();
        return new PokemonTypeApiEntity(name, url);
    }
}