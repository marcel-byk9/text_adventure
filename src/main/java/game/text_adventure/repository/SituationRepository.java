package game.text_adventure.repository;

import game.text_adventure.dto.Option;
import game.text_adventure.dto.Situation;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SituationRepository extends JpaRepository<Situation, Integer> {
}
