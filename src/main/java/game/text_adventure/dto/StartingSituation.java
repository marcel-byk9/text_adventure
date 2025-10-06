package game.text_adventure.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class StartingSituation {
    private UUID id;
    private UUID classOptionId;
    private UUID backgroundOptionId;
    private UUID situationId;
}
