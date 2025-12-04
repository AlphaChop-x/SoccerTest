package org.example.soccerplayerscatalog30.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Сущность команды
 */
@Entity
@Table(name = "football_team")
public class FootballTeam {

    /**
     * Уникальный идентификатор команды
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название команды
     */
    private String teamName;

    /**
     * Список игроков в команде
     */
    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private Set<FootballPlayer> players = new HashSet<>();

    public FootballTeam() {
    }

    public FootballTeam(String teamName) {
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Set<FootballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(Set<FootballPlayer> players) {
        this.players = players;
    }
}
