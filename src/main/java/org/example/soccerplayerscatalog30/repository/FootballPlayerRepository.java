package org.example.soccerplayerscatalog30.repository;

import org.example.soccerplayerscatalog30.entity.FootballPlayer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Репозиторий для работы с игроками
 */
public interface FootballPlayerRepository extends CrudRepository<FootballPlayer, Long> {
    /**
     * Находит игрока в футбол по его id
     *
     * @param id уникальный идентификатор игрока
     */
    Optional<FootballPlayer> getFootballPlayerById(Long id);

    /**
     * Проверяет существование игрока по следующим полям:
     *
     * @param firstName   имя игрока
     * @param sureName    фамилия игрока
     * @param dateOfBirth дата рождения игрока
     * @return <ul>
     * <li>{@code true} если игрок существует</li>
     * <li>{@code false} если игрок не существует</li>
     * </ul>
     */
    boolean existsByFirstNameAndSureNameAndDateOfBirth(String firstName, String sureName, LocalDate dateOfBirth);

    /**
     * Находит всех игроков в футбол
     */
    Page<FootballPlayer> findAll(Pageable pageable);

}
