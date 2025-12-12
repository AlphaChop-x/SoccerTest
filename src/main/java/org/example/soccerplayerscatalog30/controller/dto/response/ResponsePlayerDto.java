package org.example.soccerplayerscatalog30.controller.dto.response;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.soccerplayerscatalog30.controller.validation.ValueOfEnum;
import org.example.soccerplayerscatalog30.entity.entityEnums.Gender;
import org.example.soccerplayerscatalog30.entity.entityEnums.State;

import java.time.LocalDate;

/**
 * Дто, содержащее информацию о игроке
 */
public class ResponsePlayerDto {

    /**
     * Идентификатор игрока
     */
    private Long id;
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
    private String dateOfBirth;

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

    public ResponsePlayerDto(
            Long id,
            String firstName,
            String sureName,
            String gender,
            LocalDate dateOfBirth,
            String teamName,
            String state
    ) {
        this.id = id;
        this.firstName = firstName;
        this.sureName = sureName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth.toString();
        this.teamName = teamName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
