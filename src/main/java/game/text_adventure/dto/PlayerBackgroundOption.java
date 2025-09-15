package game.text_adventure.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class PlayerBackgroundOption {
    private UUID id;
    private String name;
    private String description;
}
