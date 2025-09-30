package game.text_adventure.service;

import game.text_adventure.dto.Player;
import game.text_adventure.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;
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
        this.savePlayer(player);
        return player;
    }

    public Player setPlayerActiveStatus(Player player, boolean active) {
        player.setIsActive(active);
        this.savePlayer(player);
        return player;
    }

    public List<Player> getAllActivePlayers() {
        return playerRepository.findAllByIsActiveTrue();
    }

    public void deletePlayer(Player player) {
        playerRepository.delete(player);
    }

    public void savePlayer(Player player) {
        Optional<Player> optPlayer = playerRepository.findById(player.getId());
        if (optPlayer.isEmpty()) {
            playerRepository.insert(player);
        } else {
            playerRepository.update(player);
        }
    }

    public Optional<Player> loadPlayer(UUID playerId) {
        return playerRepository.findById(playerId);
    }
}
