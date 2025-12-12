package org.example.soccerplayerscatalog30.controller.dto;

import org.example.soccerplayerscatalog30.controller.dto.response.ResponsePlayerDto;
import org.example.soccerplayerscatalog30.entity.FootballPlayer;
import org.springframework.stereotype.Component;

/**
 * Маппер, конвертирующий сущность пользователя в дто ответ
 */
@Component
public class PlayerMapper {

    /**
     * Метод, принимающий сущность игрока и возвращающий {@link ResponsePlayerDto}
     *
     * @param entity сущность игрока, полученая из бд
     * @return смапленная сущность в дто
     */
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
