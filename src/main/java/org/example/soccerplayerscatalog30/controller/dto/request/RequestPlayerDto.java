package org.example.soccerplayerscatalog30.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.soccerplayerscatalog30.controller.validation.ValueOfEnum;
import org.example.soccerplayerscatalog30.entity.entityEnums.Gender;
import org.example.soccerplayerscatalog30.entity.entityEnums.State;

import java.time.LocalDate;

public class RequestPlayerDto {
    /**
     * Имя игрока
     */
    @NotEmpty
    private String firstName;

    /**
     * Фамилия игрока
     */
    @NotEmpty
    private String sureName;

    /**
     * Пол игрока
     */
    @ValueOfEnum(enumClass = Gender.class)
    @NotEmpty
    private String gender;

    /**
     * День рождения игрока
     */
    @NotNull
    private LocalDate dateOfBirth;

    /**
     * Название команды
     */
    @NotEmpty
    private String teamName;

    /**
     * Родная страна игрока
     */
    @ValueOfEnum(enumClass = State.class)
    @NotEmpty
    private String state;

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
