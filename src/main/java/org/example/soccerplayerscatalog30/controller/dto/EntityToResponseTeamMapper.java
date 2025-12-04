package org.example.soccerplayerscatalog30.controller.dto;

import org.example.soccerplayerscatalog30.controller.dto.response.ResponseTeamDto;
import org.example.soccerplayerscatalog30.entity.FootballTeam;
import org.springframework.stereotype.Component;

@Component
public class EntityToResponseTeamMapper {
    public ResponseTeamDto entityToResponseDto(FootballTeam team) {
        return new ResponseTeamDto(team.getTeamName());
    };

}
