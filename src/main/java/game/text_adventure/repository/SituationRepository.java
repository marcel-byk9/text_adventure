package game.text_adventure.repository;

import game.text_adventure.dto.Option;
import game.text_adventure.dto.Situation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituationRepository extends JpaRepository<Situation, Integer> {
}
