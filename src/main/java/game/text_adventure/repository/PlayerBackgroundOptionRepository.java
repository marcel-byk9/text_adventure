package game.text_adventure.repository;

import game.text_adventure.dto.Option;
import game.text_adventure.dto.PlayerBackgroundOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerBackgroundOptionRepository extends JpaRepository<PlayerBackgroundOption, Integer> {
}
