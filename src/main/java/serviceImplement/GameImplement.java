package serviceImplement;

import entities.Game;
import repository.GameRepository;
import servicesInterface.GameInterface;

public class GameImplement implements GameInterface{
	

	private GameRepository GameRepository;
	
	public GameImplement() {
		GameRepository = new GameRepository();
	}

	@Override
	public Game registerGame(String username,  String game, String Address) {
			Game theGame = new Game();
			theGame.setGameName(game);
			theGame.setGameOwner(username);
			theGame.setAddress(Address);
			return GameRepository.addGame(theGame);
	
	}

	
	
	
	
}
