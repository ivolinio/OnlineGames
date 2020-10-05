package entities;

import java.util.Map;

public class Game {
	
	private int gameId;
	
	private String username;
	
	private String gameName;
	
	private String Address;
	
	public Game(){
		
	}
	
	public static Game parseMapToGame(Map<String, Object> gameMap) {
		Game game = new Game();
		game.setGameName((String)gameMap.get("game_name"));
		game.setGameOwner((String)gameMap.get("username"));
		game.setAddress((String)gameMap.get("address"));
		game.setGameId((Integer)gameMap.get("game_id"));
		return game;
	}

	/**
	 * @return the gameOwner
	 */
	public String getGameOwner() {
		return username;
	}

	/**
	 * @param gameOwner the gameOwner to set
	 */
	public void setGameOwner(String gameOwner) {
		this.username = gameOwner;
	}

	/**
	 * @return the gameId
	 */
	public int getGameId() {
		return gameId;
	}

	/**
	 * @param gameId the gameId to set
	 */
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param gameName the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}

	
	
}
