package com.team.data.model;



public class PlayerRank {
	
	int playerId;
	
	int rank ;
	
	public PlayerRank() {
	}

	public PlayerRank(int playerId, int rank) {
		this.playerId = playerId;
		this.rank = rank;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
