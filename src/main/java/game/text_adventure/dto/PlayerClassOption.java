package game.text_adventure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerClassOption {
    private UUID id;
    private String name;
    private String description;
}