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
            System.out.print("Enter a command (or 'q' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Closing applicaiton...");
                break;
            }

            if (!input.startsWith("type")) {
                System.out.print("\n" +
                        "Invalid command. Commands:\n" +
                        "* \'type <pokemon_name>\'   --> Obtains the desired pokemon types.\n" +
                        "* \'q\'                     --> Exit application.\n" +
                        "\n");
                continue;
            }

            String pokemonName = input.split(" ")[1];
            List<PokemonType> pokemonTypes;
            try {
                pokemonTypes = getPokemonTypesByNameUseCase.execute(pokemonName);
            } catch (Exception e) {
                System.out.print("\n" +
                        "Error occurred trying to fetch pokemon types.\n" +
                        "Error: " + e.getMessage() +
                        "\n");
                continue;
            }

            System.out.print("\n" +
                    "Types of " + pokemonName + " are: " +
                    pokemonTypes.stream().map(PokemonType::getName).collect(Collectors.toList()) +
                    "\n");

        }
        System.exit(0);
    }
}
