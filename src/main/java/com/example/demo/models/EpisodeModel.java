package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "episode")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeModel {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    private Long episode;

    @ManyToMany()
    @JoinTable(
            name = "episode_person",
            joinColumns = @JoinColumn(name = "episode_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<PersonModel> personList = new ArrayList<PersonModel>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getEpisode() {
        return episode;
    }

    public void setEpisode(Long episode) {
        this.episode = episode;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public List<PersonModel> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonModel> personList) {
        this.personList = personList;
    }

    private String episodeName;
}