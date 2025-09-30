package game.text_adventure.application;
import game.text_adventure.dto.*;
import game.text_adventure.repository.PlayerBackgroundOptionRepository;
import game.text_adventure.repository.PlayerClassOptionRepository;
import game.text_adventure.repository.SituationRepository;
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
        System.out.println("Text Adventure\n\n"); //TODO WIP: Set Titel
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

        PlayerClassOption playerClass = getPlayerClassInput();

        PlayerBackgroundOption playerBackground = getBackgroundInput();

        Situation startingSituation = getStartingSituationId(playerClass, playerBackground);
        Player player = playerService.createNewPlayer(name, playerClass.getId(), playerBackground.getId(), startingSituation.getId());

        player.setStorySave(startingSituation.getId());
        startStoryLoop(player);
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

            Optional<Situation> maybeNextSituation = optionService.getNextSituationForOption(currentId, UUID.fromString(String.valueOf(selectedOption.getId())));
            if (maybeNextSituation.isEmpty()) {
                System.out.println("Fehler: Nächste Situation konnte nicht geladen werden.");
                break;
            }

            Situation nextSituation = maybeNextSituation.get();


            player.setStorySave(nextSituation.getId());
            playerService.savePlayer(player);

            if (Boolean.TRUE.equals(nextSituation.getIsEnding())) {
                System.out.println("\n" + nextSituation.getDescription());
                playerService.setPlayerActiveStatus(player, false);
                System.out.println("Abenteuer ist zu Ende.");
                break;
            }
        }
    }

    private void pressEnterToContinue() {
        System.out.println("Drücke Enter um fortzufahren...");
        try {
            scanner.nextLine();
        } catch (Exception ex) {
            log.error("Fehler beim Warten auf Eingabe:", ex);
        }
    }

    private PlayerClassOption getPlayerClassInput() {
        List<PlayerClassOption>  playerClassOptions = (new PlayerClassOptionRepository()).findAll();

        int i = 0;
        for(PlayerClassOption playerClassOption: playerClassOptions){
            i++;
            System.out.println(i + ") " + playerClassOption.getName());
        }

        while (true) {
            System.out.print("Deine Wahl: ");
            String input = scanner.nextLine();
            try {
                return playerClassOptions.get(Integer.parseInt(input) -1);
            } catch (Exception e){
                System.out.println("ERROR: Invalid Input");
            }
        }
    }

    private PlayerBackgroundOption getBackgroundInput() {
        List<PlayerBackgroundOption>  playerBackgroundOptions = (new PlayerBackgroundOptionRepository()).findAll();

        int i = 0;
        for(PlayerBackgroundOption playerBackgroundOption: playerBackgroundOptions){
            i++;
            System.out.println(i + ") " + playerBackgroundOption.getName());
        }

        while (true) {
            System.out.print("Deine Wahl: ");
            String input = scanner.nextLine();
            try {
               return playerBackgroundOptions.get(Integer.parseInt(input) -1);
            } catch (Exception e){
                System.out.println("ERROR: Invalid Input");
            }
        }
    }

    private Situation getStartingSituationId(PlayerClassOption playerClassOption, PlayerBackgroundOption playerBackgroundOption) {
        /*
        Optional<PlayerClassOption> playerClassOption = (new PlayerClassOptionRepository()).findById(player.getPlayerClass());
        Optional<PlayerBackgroundOption> playerBackgroundOption = (new PlayerBackgroundOptionRepository()).findById(player.getBackground());

        if(playerClassOption.isPresent()){
            String className = playerClassOption.get().getName();
        }

        if(playerBackgroundOption.isPresent()){
            String backgroundName = playerBackgroundOption.get().getName();
        }
         */
            //TODO: Am besten Link tabel erstellen und auserten
            //TODO: Alternativ einfach hard coded swich
        Optional<Situation> situation = (new SituationRepository()).findById(UUID.fromString("8a9b0c1d-2e3f-4d5a-9b6c-7d8e9f0a1b2c"));
        return situation.orElseGet(Situation::new);
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
