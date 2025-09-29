package game.text_adventure;

import game.text_adventure.application.TextAdventure;

public class Main {
    public static void main(String[] args) {

        System.out.println("Working directory: " + System.getProperty("user.dir"));
        TextAdventure game = new TextAdventure();
        game.run();
    }
}