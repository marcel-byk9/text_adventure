package game.text_adventure.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Situation")
public class Situation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private int id;
    @Column(name = "Description")
    private String description;
    @Column(name = "IsEnding")
    private Boolean isEnding;
    @OneToMany(mappedBy = "Option", orphanRemoval = true, targetEntity = Option.class)
    private List<Option> options;
}
