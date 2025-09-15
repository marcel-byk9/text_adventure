package game.text_adventure.repository;

import game.text_adventure.dto.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findAllByIsActiveTrue();
}
