package org.example.soccerplayerscatalog30.repository;

import org.example.soccerplayerscatalog30.entity.FootballTeam;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Репозиторий для работы с футбольными командами
 */
public interface FootballTeamRepository extends CrudRepository<FootballTeam, Long> {
    /**
     * Находит футбольную команду по её имени
     *
     * @param teamName имя команды
     */
    Optional<FootballTeam> getFootballTeamByTeamName(String teamName);
}
