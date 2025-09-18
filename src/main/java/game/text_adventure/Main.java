package game.text_adventure;

import game.text_adventure.application.TextAdventure;

public class Main {
    public static void main(String[] args) {

        // TODO instantiate service classes

        TextAdventure game = new TextAdventure(playerService, situationService);
        game.run();
    }
}