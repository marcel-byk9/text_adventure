package game.text_adventure.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class Situation {
    private UUID id;
    private String description;
    private Boolean isEnding;
}
