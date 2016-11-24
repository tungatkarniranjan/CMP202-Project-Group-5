package edu.sjsu.akatsuki;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.sjsu.gamestate.GameStateAssigner;

public class ResetGameResource extends ServerResource {

	GameStateAssigner gameStateAssigner;
	
	@Get
	public void resetGame() throws JSONException, IOException {
		
		gameStateAssigner = GameEnvironment.getGameStateAssigner();
		gameStateAssigner.resetGame();
		GameEnvironment.resetGameEnv();
	}
}

