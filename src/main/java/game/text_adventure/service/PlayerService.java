package game.text_adventure.service;

import game.text_adventure.dto.Player;
import game.text_adventure.exception.PlayerSaveException;
import game.text_adventure.repository.PlayerRepository;

import java.util.List;
import java.util.UUID;

public class PlayerService {
    private final PlayerRepository playerRepository = new PlayerRepository();

    public Player createNewPlayerRun(String playerName, UUID playerClass, UUID playerBackground, UUID startingSituation) {
        Player player = new Player();
        player.setId(UUID.randomUUID());
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

    public List<Player> getAllActivePlayers() {
        return playerRepository.findAllByIsActiveTrue();
    }

    public Player setPlayerActiveStatus(Player player, boolean active) {
        player.setIsActive(active);
        if (playerRepository.save(player).isPresent()) {
            return player;
        }
        throw new PlayerSaveException("Unable to set player active status to " + active + "for player " + player.getName());
    }

    public List<Player> getActivePlayers() {
        return playerRepository.findAllByIsActiveTrue();
    }

    // TODO add logic
    public void deletePlayer(Player player) {
        return;
    }

    public void savePlayer(Player player) {
        playerRepository.save(player);
    }
}
