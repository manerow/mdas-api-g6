package com.mdas.api.g6.infrastructure.console;

import com.mdas.api.g6.application.GetPokemonTypesByNameUseCase;
import com.mdas.api.g6.domain.valueobject.PokemonType;
import com.mdas.api.g6.infrastructure.http.pokeapi.adapter.PokeApiRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Controller
public class ConsoleController implements CommandLineRunner {

    private final GetPokemonTypesByNameUseCase getPokemonTypesByNameUseCase;

    @Autowired
    public ConsoleController(PokeApiRepositoryAdapter pokeApiRepositoryAdapter) {
        this.getPokemonTypesByNameUseCase = new GetPokemonTypesByNameUseCase(pokeApiRepositoryAdapter);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            if (!input.startsWith("type")) {
                System.out.println("Invalid command.");
                System.out.println("For obtaining a pokemon type introduce \"type <pokemon_name>\".");
                System.out.println("For exiting the application introduce \"exit\"");
            }

            String pokemonName = input.split(" ")[1];
            List<PokemonType> pokemonTypes;
            try {
                pokemonTypes = getPokemonTypesByNameUseCase.execute(pokemonName);
            } catch (Exception e) {
                System.out.println("Error occurred trying to fetch pokemon types. Error: ");
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("Types of " + pokemonName + " are:");
            System.out.println(pokemonTypes.stream().map(PokemonType::getName).collect(Collectors.toList()));

        }
        System.out.println("Closing applicaiton...");
        System.exit(0);
    }
}
