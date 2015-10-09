package metier;

import ihm.graphic.MainView;
import network.Connexion;
import network.Message;

public class Engine {

	private static Engine instance;
	private MainView mainframe;
	private Engine()
	{
		
	}
	
	public static Engine getInstance() {
		if(instance == null)
			instance = new Engine();
		return instance;
	}
	
	public void start(MainView m) {
		this.mainframe = m;
		launchChat();
	}
	
	public void launchChat()
	{
		Connexion myConnexion = new Connexion();
		Message _m = myConnexion.receiveMessage();
		this.mainframe.addMessage(_m);
		
	}
}
