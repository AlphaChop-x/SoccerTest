package org.example.soccerplayerscatalog30.controller.dto.response;

/**
 * Дто, содержащее информацию о команде
 */
public class ResponseTeamDto {
    /**
     * Имя команды
     */
    private String teamName;

    public ResponseTeamDto(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
