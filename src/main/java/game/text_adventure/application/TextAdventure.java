package game.text_adventure.application;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * Class for handling the main game logic
 */
@Slf4j
public class TextAdventure {

    private final Scanner scanner = new Scanner(System.in);
    /**
     * Main game loop
     */
    public void run() {
        log.debug("Starting game...");

        Scanner scanner = new Scanner(System.in);

        showWelcomeScreen();

        boolean running = true;

        while (running) {
            printMainMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> startNewGame();
                case "2" -> showSavedGames();
                case "3" -> {
                    System.out.println("Bis zum nächsten Abenteuer. Feurio!");
                    running = false;
                }
                default -> System.out.println("Ungültige Eingabe. Bitte wähle 1, 2 oder 3");
            }
        }

        scanner.close();

        // TODO Main menu (General layout and info)
        System.out.println("WIP: Projekttitel\n\n");
        System.out.println("Ein text-basiertes Rollenspielabenteuer inspiriert vom Universum der Animationsserie 'Avatar: Der Herr der Elemente'");

        pressEnterToContinue();
        System.out.println("1. Starte ein neues Abenteuer.\n2. Zeige gespeicherte Spielstände.");
        System.out.println("Bittw wähle eine Option (1/2)");

        // TODO Select between new game or saved game

        // TODO Select between loading saved game or deleting saved game

    }

    private void showWelcomeScreen() {
        System.out.println("WIP: Projekttitel\n\n");
        System.out.println("Ein text-basiertes Rollenspielabenteuer inspiriert vom Universum der Animationsserie 'Avatar: Der Herr der Elemente'\n");
        pressEnterToContinue();
    }

    private void printMainMenu() {
        System.out.println("\n--- Hauptmenü ---");
        System.out.println("1. Starte ein neues Abenteuer");
        System.out.println("2. Zeige gespeicherte Spielstände");
        System.out.println("3. Beenden");
        System.out.print("Bitte wähle eine Option (1-3): ");
    }

    private void startNewGame() {
        System.out.println("\nEin neues Abenteuer beginnt...");
    }

    private void showSavedGames() {
        System.out.println("\nGespeicherte Spielstände werden geladen...");
        System.out.println("Funktion noch nicht implementiert.");
    }

    private void pressEnterToContinue() {
        System.out.println("Drücke Enter um fortzufahren...");
        try {
            System.in.read();
            scanner.nextLine();
        } catch (Exception ex) {
            log.error("Fehler beim Warten auf Eingabe:", ex);
        }
    }
}
