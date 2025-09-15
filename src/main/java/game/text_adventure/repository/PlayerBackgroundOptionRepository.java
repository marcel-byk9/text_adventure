package game.text_adventure.repository;

import game.text_adventure.dto.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerBackgroundOptionRepository extends JpaRepository<Option, Integer> {
}
