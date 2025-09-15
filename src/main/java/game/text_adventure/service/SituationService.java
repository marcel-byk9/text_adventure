package game.text_adventure.service;

import game.text_adventure.dto.Situation;
import game.text_adventure.repository.SituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SituationService {
    private SituationRepository situationRepository;

    @Autowired
    public void setSituationRepository(SituationRepository situationRepository) {
        this.situationRepository = situationRepository;
    }

    public List<Situation> getSituations() {
        return situationRepository.findAll();
    }
}
