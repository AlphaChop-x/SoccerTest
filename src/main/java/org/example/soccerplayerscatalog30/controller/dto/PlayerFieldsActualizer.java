package org.example.soccerplayerscatalog30.controller.dto;

import org.example.soccerplayerscatalog30.controller.dto.request.RequestPlayerUpdateDto;
import org.example.soccerplayerscatalog30.entity.FootballPlayer;
import org.example.soccerplayerscatalog30.entity.FootballTeam;
import org.example.soccerplayerscatalog30.entity.entityEnums.Gender;
import org.example.soccerplayerscatalog30.entity.entityEnums.State;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.function.Consumer;

@Component
public class PlayerFieldsActualizer {

    public FootballPlayer actualizeFields(
            FootballPlayer player,
            RequestPlayerUpdateDto fieldsToUpdate,
            FootballTeam team) {
        setIfNotEmpty(fieldsToUpdate.getFirstName(), player::setFirstName);
        setIfNotEmpty(fieldsToUpdate.getSureName(), player::setSureName);
        setIfNotEmpty(Gender.valueOf(fieldsToUpdate.getGender()), player::setGender);
        setIfNotEmpty(fieldsToUpdate.getDateOfBirth(), player::setDateOfBirth);
        setIfNotEmpty(State.valueOf(fieldsToUpdate.getState()), player::setState);
        setIfNotEmpty(team, player::setTeam);

        return player;
    }

    private <T> void setIfNotEmpty(T value, Consumer<T> setter) {
        switch (value) {
            case null -> {
                return;
            }
            case String s when s.isEmpty() -> {
                return;
            }
            case Collection<?> c when c.isEmpty() -> {
                return;
            }
            default -> {
            }
        }

        setter.accept(value);
    }
}
