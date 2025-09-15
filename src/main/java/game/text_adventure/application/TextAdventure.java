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
        log.info("Starting game...");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Lorem ipsum Titel");

        // TODO Main menu (General layout and info)

        // TODO Select between new game or saved game

        // TODO Select between loading saved game or deleting saved game

    }
}
