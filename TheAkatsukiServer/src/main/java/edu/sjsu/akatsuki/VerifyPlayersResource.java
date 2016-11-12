package edu.sjsu.akatsuki;
import edu.sjsu.gamestate.*;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.sjsu.manager.Players;

public class VerifyPlayersResource extends ServerResource {

	GameStateAssigner gameStateAssigner;
	
	
	@Get
	public Representation verifyPlayersConnection() {

		gameStateAssigner = GameEnvironment.getGameStateAssigner();
		
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("connected", gameStateAssigner.verifyPlayers());
		/*if (Players.getNoPlayers() == 2) {
			jsonResponse.put("connected", true);
		} else {
			jsonResponse.put("connected", false);
		}*/
		
		return new JsonRepresentation(jsonResponse);
	}

}
