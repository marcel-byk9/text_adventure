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
    @Column(name = "Story_Save")
    private String storySave;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Column(name = "SituationsCounter")
    private Integer situationsCounter;
}
