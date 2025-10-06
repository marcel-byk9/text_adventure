package game.text_adventure.service;

import game.text_adventure.dto.Situation;
import game.text_adventure.repository.SituationRepository;
import game.text_adventure.repository.StartingSituationRepository;

import java.util.Optional;
import java.util.UUID;

public class SituationService {
    private final SituationRepository situationRepository = new SituationRepository();
    private final StartingSituationRepository startingSituationRepository = new StartingSituationRepository();

    public Optional<Situation> getSituationById(UUID id) {
        return situationRepository.findById(id);
    }

    public Optional<Situation> getStartingSituationByClassAndBackground(UUID classOptionId, UUID backgroundOptionId) {
        return startingSituationRepository
                .findByClassAndBackground(classOptionId, backgroundOptionId)
                .flatMap(startingSituation -> getSituationById(startingSituation.getSituationId()));
    }
}
