package game.text_adventure;

import game.text_adventure.application.TextAdventure;
import game.text_adventure.repository.OptionRepository;
import game.text_adventure.repository.PlayerRepository;
import game.text_adventure.repository.SituationRepository;
import game.text_adventure.service.PlayerService;
import game.text_adventure.service.SituationService;

public class Main {
    public static void main(String[] args) {
        PlayerRepository playerRepository = new PlayerRepository();
        SituationRepository situationRepository = new SituationRepository();
        OptionRepository optionRepository = new OptionRepository();

        PlayerService playerService = new PlayerService(playerRepository);
        SituationService situationService = new SituationService(situationRepository, optionRepository);

        TextAdventure game = new TextAdventure(playerService, situationService);
        game.run();
    }
}