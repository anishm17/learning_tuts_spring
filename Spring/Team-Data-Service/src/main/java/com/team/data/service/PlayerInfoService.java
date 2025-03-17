package com.team.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.team.data.model.PlayerInfoData;
import com.team.data.model.PlayerRank;
import com.team.data.model.TeamData;

@Service
public class PlayerInfoService {
	
	@Autowired
	public RestTemplate  restTemplate;
	
	
	@HystrixCommand(fallbackMethod = "fallbackPlayerInfoData")
	public TeamData getPlayerInfoData(PlayerRank rank) {
		PlayerInfoData  playerInfoData = restTemplate.getForObject("http://PLAYER-INFO-SERVICE/player/" + rank.getPlayerId(), PlayerInfoData.class);
		return  new TeamData(playerInfoData.getTeamName(), playerInfoData.getPlayerName(), rank.getRank());
	}

	public TeamData fallbackPlayerInfoData(PlayerRank rank) {
		return new TeamData("Team Not Found", "Player Not Found", rank.getRank());
	}



}
