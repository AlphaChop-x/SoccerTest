package org.example.soccerplayerscatalog30.repository;

import org.example.soccerplayerscatalog30.entity.FootballTeam;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FootballTeamRepository extends CrudRepository<FootballTeam, Long> {
    boolean existsByTeamName(String teamName);

    Optional<FootballTeam> getFootballTeamByTeamName(String teamName);
}
