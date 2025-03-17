package com.team.data.model;

public class TeamData {

	String teamName;

	String playerName;

	int   rank;


	public TeamData() {
	}

	public TeamData(String teamName, String playerName, int rank) {
		this.teamName = teamName;
		this.playerName = playerName;
		this.rank = rank;
	}



	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	

}
