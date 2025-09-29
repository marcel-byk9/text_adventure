package game.text_adventure.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class Storytelling {
    private UUID id;
    private UUID situation;
    private UUID option;
    private UUID nextSituation;
}
