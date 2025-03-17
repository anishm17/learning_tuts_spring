package com.player.rank.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.player.rank.model.PlayerRank;
import com.player.rank.model.PlayerRankList;


@RestController
@RequestMapping("/playerRank")
public class PlayerRankServiceController {
	
	@RequestMapping("/{playerId}")
	public  PlayerRank  getTeamData( @PathVariable("playerId")  int  playerId){
		return  new PlayerRank (playerId, 6);
	}

	
	@RequestMapping("/teams/{teamName}")
	public  PlayerRankList  getPlayerRankList( @PathVariable("teamName")  String  teamName){
		
		List<PlayerRank>  playerRank =  Arrays.asList(new PlayerRank(100, 6),new PlayerRank(102, 7),new PlayerRank(103, 12));
		PlayerRankList   playerRankList  =  new PlayerRankList();
		playerRankList.setPlayerRankList(playerRank);
		return  playerRankList;
	}
	
}
