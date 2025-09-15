package game.text_adventure.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class Player {
    private UUID id;
    private String name;
    private String background;
    private String playerClass;
    private String storySave;
    private Boolean isActive;
    private Integer situationsCounter;
}
