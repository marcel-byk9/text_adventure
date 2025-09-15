package game.text_adventure.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class PlayerClassOption {
    private UUID id;
    private String name;
    private String Description;
}