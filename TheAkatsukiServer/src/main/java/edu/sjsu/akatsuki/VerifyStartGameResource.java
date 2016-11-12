package edu.sjsu.akatsuki;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.sjsu.gamestate.GameStateAssigner;
import edu.sjsu.manager.GameStart;
import edu.sjsu.manager.Players;

public class VerifyStartGameResource extends ServerResource {

	GameStateAssigner gameStateAssigner;
	
	@Get
	public Representation verifyGameStarted() {

		gameStateAssigner = GameEnvironment.getGameStateAssigner();
		
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("started", gameStateAssigner.verifyGameStarted());
		
//		jsonResponse.put("started", false);
//		if(Players.getNoPlayers() == 2)
//			jsonResponse.put("started", GameStart.IsGameStarted());

		return new JsonRepresentation(jsonResponse);
	}
}
