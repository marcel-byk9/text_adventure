package game.text_adventure.service;

import game.text_adventure.dto.Situation;
import game.text_adventure.repository.SituationRepository;

import java.util.Optional;
import java.util.UUID;

public class SituationService {
    private final SituationRepository situationRepository = new SituationRepository();

    public Optional<Situation> getSituationById(UUID id) {
        return situationRepository.findById(id);
    }
}
