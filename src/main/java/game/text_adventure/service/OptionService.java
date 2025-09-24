package game.text_adventure.service;

import game.text_adventure.dto.Situation;
import game.text_adventure.repository.OptionRepository;
import game.text_adventure.repository.SituationRepository;

import java.util.Optional;
import java.util.UUID;

// TODO improve rough implementation
public class OptionService {
    private final OptionRepository optionRepository = new OptionRepository();
    private final SituationRepository situationRepository = new SituationRepository();

    public Optional<Situation> getNextSituationForOption(UUID optionId) {
        Optional<UUID> maybeNextId = optionRepository.findNextSituationIdByOptionId(optionId);

        return maybeNextId.flatMap(situationRepository::findById);
    }
}
