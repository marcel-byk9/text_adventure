package game.text_adventure.service;

import game.text_adventure.dto.Player;
import game.text_adventure.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private PlayerRepository playerRepository;

    public Player createNewPlayerRun(String playerName, String playerClass, String playerBackground, String startingSituation) {
        Player player = new Player();
        player.setName(playerName);
        player.setBackground(playerBackground);
        player.setPlayerClass(playerClass);
        player.setStorySave(startingSituation);
        player.setIsActive(true);
        player.setSituationsCounter(0);
        return playerRepository.save(player);
    }

    public Player setPlayerActiveStatus(Player player, boolean active) {
        player.setIsActive(active);
        return playerRepository.save(player);
    }
}
