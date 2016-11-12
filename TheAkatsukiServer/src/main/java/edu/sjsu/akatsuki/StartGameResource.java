package edu.sjsu.akatsuki;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.sjsu.gamestate.GameStateAssigner;
import edu.sjsu.manager.GameStart;

public class StartGameResource extends ServerResource {

	GameStateAssigner gameStateAssigner;
	@Get
	public void startTheGame() {
		
		gameStateAssigner = GameEnvironment.getGameStateAssigner();
		gameStateAssigner.startGame();
		GameStart.startTheGame();
	}
}
