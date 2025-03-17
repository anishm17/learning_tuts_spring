package com.player.info.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.player.info.model.PlayerInfoData;

@RestController
@RequestMapping("/player")
public class PlayerInfoServiceController {
	
	@Value("$(api.key)")
	private  String apiKey;
	
	@Autowired
	private RestTemplate  restTemplate;
	
	@RequestMapping("/{playerId}")
	public  PlayerInfoData  getTeamData( @PathVariable("playerId")  int  playerId){
		String  playerName="";
		if(playerId == 100) {
			playerName ="Sachin";
		}else if (playerId == 102) {
			playerName ="MS Dhoni";
		}else if(playerId == 103) {
			playerName ="Yuvi";
		}
		
		/** api call **/
		//PlayerInfoData  playerInfoData =  restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + 550 + "?api_key=" +  apiKey, PlayerInfoData.class);
		return  new PlayerInfoData (playerId, playerName ,"CSK");
	}

}
