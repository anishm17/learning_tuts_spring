package com.team.data.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.team.data.model.PlayerRank;
import com.team.data.model.PlayerRankList;

@Service
public class PlayerRankService {
	
	@Autowired
	public RestTemplate  restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallbackPlayerRankList")
	public PlayerRankList getPlayerRankList(String teamName) {
		return restTemplate.getForObject("http://PLAYER-RANK-SERVICE/playerRank/teams/"+teamName, PlayerRankList.class);
	}
    public  PlayerRankList  fallbackPlayerRankList( @PathVariable("teamName")  String  teamName){
    	PlayerRankList playerRankList =  new PlayerRankList();
    	playerRankList.setPlayerRankList(Arrays.asList(new PlayerRank(0, -1)));
    	return  playerRankList;
    	
	}

}
