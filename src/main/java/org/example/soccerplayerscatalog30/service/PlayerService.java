package org.example.soccerplayerscatalog30.service;

import org.example.soccerplayerscatalog30.entity.FootballPlayer;
import org.example.soccerplayerscatalog30.repository.FootballPlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final FootballPlayerRepository playerRepository;

    public PlayerService(FootballPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Optional<FootballPlayer> getPlayerById(Long playerId) {
        return playerRepository.getFootballPlayerById(playerId);
    }

    public List<FootballPlayer> findAll() {
        return playerRepository.findAll();
    }

    public FootballPlayer add(FootballPlayer player) {
        return playerRepository.save(player);
    }

    public FootballPlayer update(FootballPlayer updatedPlayer) {
        return playerRepository.save(updatedPlayer);
    }
}
