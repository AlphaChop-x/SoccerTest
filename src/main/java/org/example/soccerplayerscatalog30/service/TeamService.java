package org.example.soccerplayerscatalog30.service;

import org.example.soccerplayerscatalog30.entity.FootballTeam;
import org.example.soccerplayerscatalog30.repository.FootballTeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для управления командами
 */
@Service
public class TeamService {

    private final FootballTeamRepository teamRepository;

    public TeamService(FootballTeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    /**
     * Метод для поиска команды по её имени
     *
     * @param teamName имя команды
     */
    public Optional<FootballTeam> findTeamByName(String teamName) {
        return teamRepository.getFootballTeamByTeamName(teamName);
    }

    /**
     * Метод для добавления новой команды
     *
     * @param teamName имя команды
     * @return {@link FootballTeam} новая команда
     */
    public FootballTeam createTeam(String teamName) {
        FootballTeam team = new FootballTeam(teamName);
        return teamRepository.save(team);
    }

    /**
     * Метод для получения списка всех команд
     *
     * @return возвращает список всех существующих в системе команд
     */
    public List<FootballTeam> getAll() {
        return (List<FootballTeam>) teamRepository.findAll();
    }
}
