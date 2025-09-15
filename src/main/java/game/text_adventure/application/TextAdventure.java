package game.text_adventure.application;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * Class for handling the main game logic
 */
@Slf4j
public class TextAdventure {

    /**
     * Main game loop
     */
    public void run() {
        log.debug("Starting game...");

        Scanner scanner = new Scanner(System.in);



        // TODO Main menu (General layout and info)
        System.out.println("WIP: Projekttitel\n\n");
        System.out.println("Ein text-basiertes Rollenspielabenteuer inspiriert vom Universum der Animationsserie 'Avatar: Der Herr der Elemente'");

        pressEnterToContinue(scanner);
        System.out.println("1. Starte ein neues Abenteuer.\n2. Zeige gespeicherte Spielstände.");
        System.out.println("Bittw wähle eine Option (1/2)");

        // TODO Select between new game or saved game

        // TODO Select between loading saved game or deleting saved game

    }

    private void pressEnterToContinue(Scanner scanner)
    {
        System.out.println("Drücke Enter um fortzufahren...");
        try
        {
            System.in.read();
            scanner.nextLine();
        }
        catch(Exception ex)
        {log.error("Unexpected exception:", ex);}
    }
}
