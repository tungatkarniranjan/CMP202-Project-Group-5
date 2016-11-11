package edu.sjsu.akatsuki;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.RepresentationInfo;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.sjsu.manager.Players;

public class VerifyPlayersResource extends ServerResource {
	
	@Get
	public Representation verifyPlayersConnection(){
		
		JSONObject jsonResponse = new JSONObject();
		if(Players.getNoPlayers() == 2){
			jsonResponse.put("connected", true);
		}else{
			jsonResponse.put("connected", false);
		}
	return new JsonRepresentation(jsonResponse);
	}

}
