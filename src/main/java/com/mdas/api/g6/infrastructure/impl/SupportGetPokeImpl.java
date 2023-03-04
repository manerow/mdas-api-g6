package com.mdas.api.g6.infrastructure.impl;


import com.mdas.api.g6.infrastructure.dto.PokeResponseDto;
import com.mdas.api.g6.domain.repository.SupportGetPoke;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class SupportGetPokeImpl implements SupportGetPoke {

  @Value("${api.support.url}")
  private String url;

  @Override
  public PokeResponseDto getPokemonType(String name){

    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForEntity(url + name, PokeResponseDto.class).getBody();

  }
}
