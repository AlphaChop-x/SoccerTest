package org.example.soccerplayerscatalog30.entity;

import jakarta.persistence.*;
import org.example.soccerplayerscatalog30.entity.entityEnums.Gender;
import org.example.soccerplayerscatalog30.entity.entityEnums.State;

import java.time.LocalDate;

/**
 * Сущность футболиста
 */
@Entity
public class FootballPlayer {
    /**
     * Уникальный идентификатор футболиста
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя игрока
     */
    private String firstName;

    /**
     * Фамилия игрока
     */
    private String sureName;

    /**
     * Пол игрока
     */
    @Enumerated(EnumType.STRING)
    private Gender gender;

    /**
     * День рождения игрока
     */
    private LocalDate dateOfBirth;

    /**
     * Название команды
     */
    @ManyToOne
    private FootballTeam team;

    /**
     * Родная страна игрока
     */
    @Enumerated(EnumType.STRING)
    private State state;

    public FootballPlayer() {
    }

    public FootballPlayer(String firstName, String sureName, Gender gender, LocalDate dateOfBirth, FootballTeam command, State state) {
        this.firstName = firstName;
        this.sureName = sureName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.team = command;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public FootballTeam getTeam() {
        return team;
    }

    public void setTeam(FootballTeam nameOfCommand) {
        this.team = nameOfCommand;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
