package org.example.soccerplayerscatalog30.controller.dto.response;

public class ResponseTeamDto {
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
