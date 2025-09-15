package game.text_adventure.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Situation")
public class Situation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "isEnding")
    private Boolean isEnding;
}
