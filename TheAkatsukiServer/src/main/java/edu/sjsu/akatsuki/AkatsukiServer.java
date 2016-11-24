package edu.sjsu.akatsuki;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class AkatsukiServer extends Application {

	public static void main(String[] args) throws Exception {

		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8080);
		component.getDefaultHost().attach(new AkatsukiServer());
		component.start();

	}

	@Override
	public Restlet createInboundRoot() {

		Router router = new Router(getContext());
		router.attach("/newgame", NewGameResource.class);
		router.attach("/verifyplayers", VerifyPlayersResource.class);
		router.attach("/startgame", StartGameResource.class);
		router.attach("/verifygamestarted", VerifyStartGameResource.class);
		router.attach("/verifygameover", VerifyGameOverResource.class);
		router.attach("/verifycitysaved", CheckResultResource.class);
		router.attach("/endgame", EndGameResource.class);
		router.attach("/resetgame", ResetGameResource.class);
		return router;
	}

}
