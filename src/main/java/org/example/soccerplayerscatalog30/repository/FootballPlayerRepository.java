package org.example.soccerplayerscatalog30.repository;

import org.example.soccerplayerscatalog30.entity.FootballPlayer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FootballPlayerRepository extends CrudRepository<FootballPlayer, Long> {
    Optional<FootballPlayer> getFootballPlayerById(Long id);

    List<FootballPlayer> findAll();

}
