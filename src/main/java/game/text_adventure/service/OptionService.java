package game.text_adventure.service;

import game.text_adventure.dto.Option;
import game.text_adventure.dto.Situation;
import game.text_adventure.repository.OptionRepository;
import game.text_adventure.repository.SituationRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OptionService {
    private final OptionRepository optionRepository = new OptionRepository();
    private final SituationRepository situationRepository = new SituationRepository();

    public Optional<Situation> getNextSituationForOption(UUID situationId, UUID optionId) {
        return situationRepository.findNextSituationByOptionId(situationId, optionId);
    }

    public List<Option> getSituationOptionsById(UUID situationId) {
        return optionRepository.findOptionsBySituationId(situationId);
    }
}
