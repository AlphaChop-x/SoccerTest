package org.example.soccerplayerscatalog30.service;

import org.example.soccerplayerscatalog30.entity.FootballTeam;
import org.example.soccerplayerscatalog30.repository.FootballTeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final FootballTeamRepository teamRepository;

    public TeamService(FootballTeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

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

    public List<FootballTeam> getAll() {
        return (List<FootballTeam>) teamRepository.findAll();
    }
}
