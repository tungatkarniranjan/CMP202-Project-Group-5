package edu.sjsu.akatsuki;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.sjsu.gamestate.GameStateAssigner;

public class EndGameResource extends ServerResource {
	
	GameStateAssigner gameStateAssigner;
	
	@Get
	public void endCurrentGame() {

		gameStateAssigner = GameEnvironment.getGameStateAssigner();
		gameStateAssigner.endGame();
	}

}
