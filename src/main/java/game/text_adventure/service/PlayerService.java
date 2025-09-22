package game.text_adventure.service;

import game.text_adventure.dto.Player;
import game.text_adventure.exception.PlayerSaveException;
import game.text_adventure.repository.PlayerRepository;

public class PlayerService {
    private final PlayerRepository playerRepository = new PlayerRepository();

    public Player createNewPlayerRun(String playerName, String playerClass, String playerBackground, String startingSituation) {
        Player player = new Player();
        player.setName(playerName);
        player.setBackground(playerBackground);
        player.setPlayerClass(playerClass);
        player.setStorySave(startingSituation);
        player.setIsActive(true);
        player.setSituationsCounter(0);
        if (playerRepository.save(player).isPresent()) {
            return player;
        }
        throw new PlayerSaveException("Unable to create new player " + playerName);
    }

    public Player setPlayerActiveStatus(Player player, boolean active) {
        player.setIsActive(active);
        if (playerRepository.save(player).isPresent()) {
            return player;
        }
        throw new PlayerSaveException("Unable to set player active status to " + active + "for player " + player.getName());
    }
}
