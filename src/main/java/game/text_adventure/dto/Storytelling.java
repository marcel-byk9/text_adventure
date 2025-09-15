package game.text_adventure.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Storytelling")
public class Storytelling {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private int id;
    @Column(name = "Situation")
    private int situation;
    @Column(name = "Option")
    private int option;
    @Column(name = "next_Situation")
    private int nextSituation;
}
