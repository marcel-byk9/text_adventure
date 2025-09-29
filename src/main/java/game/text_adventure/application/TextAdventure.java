package game.text_adventure.application;
import game.text_adventure.dto.Option;
import game.text_adventure.dto.Player;
import game.text_adventure.dto.Situation;
import game.text_adventure.service.OptionService;
import game.text_adventure.service.PlayerService;
import game.text_adventure.service.SituationService;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Class for handling the main game logic
 */
@Slf4j
public class TextAdventure {

    private final Scanner scanner = new Scanner(System.in);
    private final PlayerService playerService = new PlayerService();
    private final SituationService situationService = new SituationService();
    private final OptionService optionService = new OptionService();

    public TextAdventure() {
    }

    /**
     * Main game loop
     */
    public void run() {
        log.debug("Starting game...");
        showWelcomeScreen();

        boolean running = true;

        while (running) {
            printMainMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> startNewGame();
                case "2" -> showSaveGameMenu();
                case "3" -> {
                    System.out.println("Bis zum nächsten Abenteuer. Feurio!");
                    running = false;
                }
                default -> System.out.println("Ungültige Eingabe. Bitte wähle 1, 2 oder 3");
            }
        }
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
        System.out.println("Wie wirst du genannt?");
        String name = scanner.nextLine();

        String playerClass = getPlayerClassInput();

        String background = getBackgroundInput();

        UUID startingSituation = getStartingSituationId();

        // TODO remove after debugging
        System.out.println("Name: " + name);
        System.out.println("PlayerClass: " + playerClass);
        System.out.println("Background: " + background);
        System.out.println("StartingSituation: " + startingSituation.toString());

        // TODO adapt to correct service implementation
        //Player player = playerService.createNewPlayerRun(name, playerClass, background, startingSituation.toString());
        //startStoryLoop(player);
    }

    private void showSaveGameMenu() {
        System.out.println("\nGespeicherte Spielstände werden geladen...");

        List<Player> activePlayers = playerService.getAllActivePlayers();
        if (activePlayers.isEmpty()) {
            System.out.println("Keine gespeicherten Spielstände vorhanden.");
            return;
        }

        for (int i = 0; i < activePlayers.size(); i++) {
            System.out.println((i + 1) + ". " + activePlayers.get(i).getName());
        }

        System.out.println("\nWas möchtest du tun?");
        System.out.println("\n1. Einen Spielstand laden");
        System.out.println("\n2. Einen Spielstand löschen");
        System.out.println("\n3. Zurück zum Hauptmenü");

        String input = scanner.nextLine();

        switch (input) {
            case "1" -> loadPlayer(activePlayers);
            case "2" -> deletePlayer(activePlayers);
            case "3" -> {
                return;
            }
            default -> System.out.println("Ungültige Eingabe. Bitte wähle 1, 2 oder 3");
        }
    }

    private void loadPlayer(List<Player> players) {
        System.out.println("\nWelchen Spielstand möchtest du laden?");        System.out.println("\nWelchen Spielstand möchtest du laden?");
        System.out.println("\nGib 'q' ein, um zum Hauptmenü zurückzukehren.");

        for (int i = 0; i < players.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, players.get(i).getName());
        }

        int choice = getValidChoiceInputOrQuit(players.size());
        if (choice == -1) {
            return;
        }

        Player playerChoice = players.get(choice - 1);
        startStoryLoop(playerChoice);
    }

    private void deletePlayer(List<Player> players) {
        System.out.println("\nWelchen Spielstand möchtest du löschen?");

        for (int i = 0; i < players.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, players.get(i).getName());
        }

        int choice = getValidChoiceInputOrQuit(players.size());
        if (choice == -1) {
            return;
        }

        Player playerChoice = players.get(choice - 1);
        playerService.deletePlayer(playerChoice);
        System.out.println("\nDer Spielstand '" + playerChoice.getName() + "' wurde gelöscht.");
    }

    private void startStoryLoop(Player player) {
        while (true) {
            UUID currentId = player.getStorySave();

            Optional<Situation> maybeSituation = situationService.getSituationById(currentId);
            if (maybeSituation.isEmpty()) {
                System.out.println("Fehler: Situation konnte nicht geladen werden.");
                break;
            }
            Situation currentSituation = maybeSituation.get();

            List<Option> maybeOptions = optionService.getSituationOptionsById(currentId);
            if (maybeOptions.isEmpty()) {
                System.out.println("\n" + currentSituation.getDescription());
                System.out.println("Keine Optionen verfügbar. Die Geschichte endet hier.");
                break;
            }

            System.out.println("\n" + currentSituation.getDescription());
            displayOptions(maybeOptions);

            int choice = getValidChoiceInput(maybeOptions.size());
            Option selectedOption = maybeOptions.get(choice - 1);

            Optional<Situation> maybeNextSituation = optionService.getNextSituationForOption(currentSituation.getId(), UUID.fromString(String.valueOf(selectedOption.getId())));
            if (maybeNextSituation.isEmpty()) {
                System.out.println("Fehler: Nächste Situation konnte nicht geladen werden.");
                break;
            }

            Situation nextSituation = maybeNextSituation.get();


            player.setStorySave(nextSituation.getId());
            playerService.savePlayer(player);

            if (Boolean.TRUE.equals(nextSituation.getIsEnding())) {
                System.out.println("\n" + nextSituation.getDescription());
                System.out.println("Abenteuer ist zu Ende.");
                break;
            }
        }
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

    private String getPlayerClassInput() {
        while (true) {
            System.out.print("Deine Wahl: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> { return "Wasserbändiger"; }
                case "2" -> { return "Feuerbändiger"; }
                case "3" -> { return "Erdbändiger"; }
                default -> System.out.println("Ungültige Eingabe. Bitte wähle 1-3.");
            }
        }
    }

    private String getBackgroundInput() {
        while (true) {
            System.out.print("Deine Wahl: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> { return "Nomade"; }
                case "2" -> { return "Soldat"; }
                case "3" -> { return "Gelehrter"; }
                default -> System.out.println("Ungültige Eingabe. Bitte wähle 1-3.");
            }
        }
    }

    private UUID getStartingSituationId() {
        // TODO replace with logic
        return UUID.fromString("00000000-0000-0000-0000-000000000001");
    }

    private void displayOptions(List<Option> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, options.get(i).getDescription());
        }
    }

    private int getValidChoiceInput(int maxOptions) {
        while (true) {
            System.out.print("Deine Wahl: ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= maxOptions) {
                    return choice;
                }
            } catch (NumberFormatException ignored) { }
            System.out.println("Ungültige Eingabe. Bitte gib eine Zahl zwischen 1 und " + maxOptions + " ein.");
        }
    }

    private int getValidChoiceInputOrQuit(int maxOptions) {
        while (true) {
            System.out.print("Deine Wahl (oder 'q' zum Zurückkehren): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("q")) {
                return -1;
            }

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= maxOptions) {
                    return choice;
                }
            } catch (NumberFormatException ignored) { }

            System.out.println("Ungültige Eingabe. Bitte gib eine Zahl zwischen 1 und " + maxOptions + " ein oder 'q' zum Zurückkehren.");
        }
    }
}
