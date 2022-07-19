package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "episode")
public class EpisodeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long episode;
    private String episodeName;

    @ManyToMany()
    @JoinTable(
            name= "episode_character",
            joinColumns = @JoinColumn(name = "episode_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    Set<CharacterModel> characters;

}
