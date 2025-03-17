package com.team.data.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.team.data.model.PlayerInfoData;
import com.team.data.model.PlayerRank;
import com.team.data.model.PlayerRankList;
import com.team.data.model.TeamData;
import com.team.data.service.PlayerInfoService;
import com.team.data.service.PlayerRankService;

@RestController
@RequestMapping("/team")
public class TeamDataServiceController {

	public TeamDataServiceController() {}

	@Autowired
	RestTemplate  restTemplate;

	@Autowired
	WebClient.Builder  webClient;
	
	@Autowired
	PlayerInfoService  playerInfoService;
	
	@Autowired
	PlayerRankService  playerRankService;

	@RequestMapping("/{teamName}")
	public  List<TeamData>  getTeamData( @PathVariable("teamName")  String  teamName){
		PlayerRankList playerRank  = playerRankService.getPlayerRankList(teamName);
		return playerRank.getPlayerRankList().stream().
				map(rank -> playerInfoService.getPlayerInfoData(rank))
			   .collect(Collectors.toList());
	}
}

/** WebClient **/
//			PlayerInfoData  playerInfoData  =  webClient.build()
//					                            .get()
//					                            .uri("http://localhost:8082/player/" + rank.getPlayerId())
//					                            .retrieve()
//					                            .bodyToMono( PlayerInfoData.class)
//					                            .block();
//			return  new TeamData(playerInfoData.getTeamName(), playerInfoData.getPlayerName(), rank.getRank());
