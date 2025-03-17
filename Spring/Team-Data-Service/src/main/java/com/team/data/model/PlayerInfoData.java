package com.team.data.model;



public class PlayerInfoData {

	int playerId;
	
	String teamName;

	String  playerName;

	public PlayerInfoData() {
	}

	public PlayerInfoData(int playerId, String playerName,String teamName) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.teamName = teamName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}
