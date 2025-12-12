package org.example.soccerplayerscatalog30.controller;

import jakarta.validation.Valid;
import org.example.soccerplayerscatalog30.controller.dto.PlayerMapper;
import org.example.soccerplayerscatalog30.controller.dto.PlayerFieldsActualizer;
import org.example.soccerplayerscatalog30.controller.dto.request.RequestPlayerDto;
import org.example.soccerplayerscatalog30.controller.dto.request.RequestPlayerUpdateDto;
import org.example.soccerplayerscatalog30.controller.dto.response.ResponsePlayerDto;
import org.example.soccerplayerscatalog30.entity.FootballPlayer;
import org.example.soccerplayerscatalog30.entity.FootballTeam;
import org.example.soccerplayerscatalog30.entity.entityEnums.Gender;
import org.example.soccerplayerscatalog30.entity.entityEnums.State;
import org.example.soccerplayerscatalog30.exception.custom.CustomNotExistException;
import org.example.soccerplayerscatalog30.service.PlayerService;
import org.example.soccerplayerscatalog30.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для работы с игроками
 */
@RestController
@RequestMapping("api/players")
public class PlayerController {

    private final PlayerService playerService;
    private final TeamService teamService;
    private final PlayerFieldsActualizer fieldsActualizer;
    private final PlayerMapper playerMapper;

    public PlayerController(
            PlayerService playerService,
            TeamService teamService,
            PlayerFieldsActualizer fieldsActualizer,
            PlayerMapper playerMapper
    ) {
        this.playerService = playerService;
        this.teamService = teamService;
        this.fieldsActualizer = fieldsActualizer;
        this.playerMapper = playerMapper;
    }

    /**
     * Метод для получения списка всех игроков
     *
     * @return {@code List<ResponsePlayerDto>} список всех игроков
     */
    @GetMapping
    public List<ResponsePlayerDto> getAllPlayers() {
        return playerService.findAll()
                .stream().map(playerMapper::convertToResponseFromEntity).toList();
    }

    /**
     * Метод для получения игрока по id
     *
     * @param playerId уникальный идентификатор игрока
     * @return возвращается {@link ResponsePlayerDto} дто с данными о игроке
     */
    @GetMapping("/{playerId}")
    public ResponsePlayerDto getPlayer(
            @PathVariable Long playerId
    ) {
        return playerMapper.convertToResponseFromEntity(
                playerService.getPlayerById(playerId)
                        .orElseThrow(
                                () -> new CustomNotExistException(
                                        "Игрока по переданному id: %d не существует".formatted(playerId))
                        )
        );
    }


    /**
     * Метод для регистрации нового игрока
     *
     * @param newPlayer дто для регистрации нового пользователя
     * @return возвращает id созданного пользователя
     */
    @PostMapping
    public String addPlayer(
            @Valid @RequestBody RequestPlayerDto newPlayer
    ) {

        FootballTeam team = teamService.findTeamByName(newPlayer.getTeamName())
                .orElseGet(() -> teamService.createTeam(newPlayer.getTeamName()));

        FootballPlayer player = new FootballPlayer(
                newPlayer.getFirstName(),
                newPlayer.getSureName(),
                Gender.valueOf(newPlayer.getGender()),
                newPlayer.getDateOfBirth(),
                team,
                State.valueOf(newPlayer.getState()));

        return playerService.add(player).getId().toString();
    }

    /**
     * Метод для обновления полей игрока
     *
     * @param playerId  уникальный идентификатор игрока
     * @param updateDto дто с обновлёнными полями пользователя
     * @return возвращает обновлённого игрока
     */
    @PatchMapping("/{playerId}")
    public ResponsePlayerDto patchPlayer(
            @PathVariable Long playerId,
            @Valid @RequestBody RequestPlayerUpdateDto updateDto
    ) {

        FootballTeam team = teamService.findTeamByName(updateDto.getTeamName())
                .orElseGet(() -> teamService.createTeam(updateDto.getTeamName()));

        if (team == null) {
            team = teamService.createTeam(updateDto.getTeamName());
        }

        FootballPlayer player = playerService.getPlayerById(playerId)
                .orElseThrow(() -> new CustomNotExistException(
                        "Игрока с таким id: %d не существует".formatted(playerId)));

        fieldsActualizer.actualizeFields(player, updateDto, team);

        return playerMapper.convertToResponseFromEntity(playerService.update(player));
    }
}
