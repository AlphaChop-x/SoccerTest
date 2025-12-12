package org.example.soccerplayerscatalog30.controller.dto.request;

import org.example.soccerplayerscatalog30.controller.validation.ValueOfEnum;
import org.example.soccerplayerscatalog30.entity.entityEnums.Gender;
import org.example.soccerplayerscatalog30.entity.entityEnums.State;

import java.time.LocalDate;

/**
 * Дто для обновления полей игрока
 */
public class RequestPlayerUpdateDto {
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
    @ValueOfEnum(enumClass = Gender.class)
    private String gender;

    /**
     * День рождения игрока
     */
    private LocalDate dateOfBirth;

    /**
     * Название команды
     */
    private String teamName;

    /**
     * Родная страна игрока
     */
    @ValueOfEnum(enumClass = State.class)
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
