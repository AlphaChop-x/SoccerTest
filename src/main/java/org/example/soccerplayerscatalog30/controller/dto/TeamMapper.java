package org.example.soccerplayerscatalog30.controller.dto;

import org.example.soccerplayerscatalog30.controller.dto.response.ResponseTeamDto;
import org.example.soccerplayerscatalog30.entity.FootballTeam;
import org.springframework.stereotype.Component;

/**
 * Маппер, конвертирующий сущность команды в дто ответ
 */
@Component
public class TeamMapper {
    /**
     * Метод, конвертирующий сущность в дто
     *
     * @param team сущность команды
     * @return дто команды
     */
    public ResponseTeamDto entityToResponseDto(FootballTeam team) {
        return new ResponseTeamDto(team.getTeamName());
    }

}
