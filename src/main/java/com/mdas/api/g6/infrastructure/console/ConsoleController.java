package com.mdas.api.g6.infrastructure.console;

import com.mdas.api.g6.application.GetConsolePokemonTypesByName;
import com.mdas.api.g6.domain.valueobject.PokemonType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class ConsoleController  {

    private final GetConsolePokemonTypesByName getConsolePokemonTypesByName;

    /*public ConsoleController(GetConsolePokemonTypesByName getConsolePokemonTypesByName, String d) {
        this.getConsolePokemonTypesByName = getConsolePokemonTypesByName;
    }*/

    public void run() {
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
                pokemonTypes = getConsolePokemonTypesByName.execute(pokemonName);
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
