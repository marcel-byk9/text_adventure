package game.text_adventure.dto;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Background")
    private String background;
    @Column(name = "Class")
    private String playerClass;
    @Column(name = "StorySave")
    private String storySave;
    @Column(name = "isActive")
    private Boolean isActive;
    @Column(name = "SituationsCounter")
    private Boolean situationsCounter;





}
