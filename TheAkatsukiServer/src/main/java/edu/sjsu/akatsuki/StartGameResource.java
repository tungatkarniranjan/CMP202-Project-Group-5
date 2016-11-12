package edu.sjsu.akatsuki;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.sjsu.gamestate.GameStateAssigner;
import edu.sjsu.manager.GameStart;

public class StartGameResource extends ServerResource {

	GameStateAssigner gameStateAssigner;
	
	@Get
	public Representation startTheGame() {
		
		gameStateAssigner = GameEnvironment.getGameStateAssigner();
		gameStateAssigner.startGame();
		
		JSONObject jsonresponse = new JSONObject();
		jsonresponse.put("started", gameStateAssigner.verifyGameStarted());
		
		return new JsonRepresentation(jsonresponse);
		//GameStart.startTheGame();
	}
}
