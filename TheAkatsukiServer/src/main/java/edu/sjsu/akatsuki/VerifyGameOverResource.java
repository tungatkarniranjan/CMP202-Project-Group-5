package edu.sjsu.akatsuki;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.sjsu.gamestate.GameStateAssigner;

public class VerifyGameOverResource extends ServerResource {

	GameStateAssigner gameStateAssigner;
	
	@Get
	public Representation verifyGameStarted() {
		gameStateAssigner = GameEnvironment.getGameStateAssigner();
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("over", gameStateAssigner.verifyGameOver());
		return new JsonRepresentation(jsonResponse);
	}
}
