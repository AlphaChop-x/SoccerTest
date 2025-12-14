package org.example.soccerplayerscatalog30.service;

import org.example.soccerplayerscatalog30.entity.FootballPlayer;
import org.example.soccerplayerscatalog30.exception.custom.CustomEntityExistException;
import org.example.soccerplayerscatalog30.repository.FootballPlayerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Сервис для работы с футбольными игроками
 */
@Service
public class PlayerService {

    private final FootballPlayerRepository playerRepository;

    public PlayerService(FootballPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Метод для получения игрока по его id
     *
     * @param playerId уникальный идентификатор игрока
     */
    public Optional<FootballPlayer> getPlayerById(Long playerId) {
        return playerRepository.getFootballPlayerById(playerId);
    }

    /**
     * Метод для получения части списка всех игроков
     *
     * @param page номер страницы
     * @param size размер страницы
     * @return страница с игроками
     */
    public Page<FootballPlayer> getPlayers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return playerRepository.findAll(pageable);
    }

    /**
     * Метод для регистрации нового игрока
     *
     * @param player сущность игрока для сохранения
     * @return {@link FootballPlayer} возвращает созданного игрока
     * @throws CustomEntityExistException ошибка возникает в случае, если такой игрок уже существует
     */
    public FootballPlayer add(FootballPlayer player) {

        if (playerRepository.existsByFirstNameAndSureNameAndDateOfBirth(
                player.getFirstName(),
                player.getSureName(),
                player.getDateOfBirth()
        )) {
            throw new CustomEntityExistException("Такой игрок уже зарегистрирован!");
        }

        return playerRepository.save(player);
    }

    /**
     * Метод для обновления полей игрока
     *
     * @param updatedPlayer игрок с обновлёнными полями
     * @return возвращает сущность обновлённого игрока
     */
    public FootballPlayer update(FootballPlayer updatedPlayer) {
        return playerRepository.save(updatedPlayer);
    }

    /**
     * Метод для удаления игрока
     *
     * @param player игрок, которого нужно удалить
     */
    public void deletePlayer(FootballPlayer player) {
        playerRepository.delete(player);
    }
}
