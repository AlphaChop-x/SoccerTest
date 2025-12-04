package org.example.soccerplayerscatalog30.controller.dto;

import org.example.soccerplayerscatalog30.controller.dto.response.ResponsePlayerDto;
import org.example.soccerplayerscatalog30.entity.FootballPlayer;
import org.springframework.stereotype.Component;

@Component
public class EntityToResponseMapper {

    public ResponsePlayerDto convertToResponseFromEntity(
            FootballPlayer entity
    ) {
        return new ResponsePlayerDto(
                entity.getId(),
                entity.getFirstName(),
                entity.getSureName(),
                entity.getGender().toString(),
                entity.getDateOfBirth(),
                entity.getTeam().getTeamName(),
                entity.getState().toString()
        );
    }
}
