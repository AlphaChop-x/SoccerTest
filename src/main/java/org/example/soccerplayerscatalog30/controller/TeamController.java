package org.example.soccerplayerscatalog30.controller;

import jakarta.transaction.Transactional;
import org.example.soccerplayerscatalog30.controller.dto.TeamMapper;
import org.example.soccerplayerscatalog30.controller.dto.request.RequestTeamDto;
import org.example.soccerplayerscatalog30.controller.dto.response.ResponseTeamDto;
import org.example.soccerplayerscatalog30.entity.FootballTeam;
import org.example.soccerplayerscatalog30.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для работы с командами
 */
@RestController
@RequestMapping("api/teams")
public class TeamController {
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    /**
     * Метод для добавления новой команды
     *
     * @param requestTeamDto дто для регистрации команды (1 поле - имя)
     * @return {@link FootballTeam cсозданная команда}
     */
    @PostMapping()
    @Transactional
    public FootballTeam addTeam(
            @RequestBody RequestTeamDto requestTeamDto) {
        return teamService.createTeam(requestTeamDto.getTeamName());
    }

    /**
     * Метод, возвращающий все существующие команды
     *
     * @return {@code List<FootballTeam>} cписок команд
     */
    @GetMapping
    public List<ResponseTeamDto> getAllTeam() {
        return teamService.getAll().stream().map(teamMapper::entityToResponseDto).toList();
    }
}
