package repository;

import java.util.List;
import java.util.Map;

import dataBase.Connector;
import entities.Game;

public class GameRepository {
	
	private static final String INSERT_GAME = "INSERT INTO games (game_name, username, address)\n" + 
			"VALUES (?, ?, ?);";
	
	private static final String SELECT_GAME = "SELECT game_id, game_name, username, address \n" + 
			"FROM games WHERE game_name=?;";
	
	
	
	public Game addGame(Game game) {
		Connector.getInstance().executeQuery(INSERT_GAME, game.getGameName(), game.getGameOwner(), game.getAddress());
		return game;
	}
	
	public Game getGame(String game) {
		List<Map<String,Object>> gameData = Connector.getInstance().executeQueryWithResult(SELECT_GAME, game);
		if(gameData.isEmpty()) {
			return null;
		} else {
		return Game.parseMapToGame(gameData.get(0));
		  }
	}
	
}
