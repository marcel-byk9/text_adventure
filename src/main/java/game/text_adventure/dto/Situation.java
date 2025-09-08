package game.text_adventure.dto;

import lombok.Data;

@Data
public class Situation {
    private int id;
    private String name;
    private String Description;
    private Boolean isEnding;
}
