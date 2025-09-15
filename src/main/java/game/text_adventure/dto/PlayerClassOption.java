package game.text_adventure.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PlayerClassOption")
public class PlayerClassOption {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String Description;
}