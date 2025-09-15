package game.text_adventure;

import game.text_adventure.service.SituationService;

public class Main {
    public static void main(String[] args) {
        SituationService service = new SituationService();
        System.out.println(service.getSituations());
    }
}
