package game.text_adventure.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class Player {
    private UUID id;
    private String name;
    private UUID background;
    private UUID playerClass;
    private UUID storySave;
    private Boolean isActive;
    private Integer situationsCounter;

}
