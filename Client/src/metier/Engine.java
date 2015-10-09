package metier;

import java.util.Observable;
import java.util.Observer;

import ihm.graphic.MainView;
import network.Connexion;
import network.Message;

public class Engine extends Observable {

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
		this.launchChat();
	}
	
	public void launchChat()
	{
		Connexion myConnexion = new Connexion();
		//On écoute les messages entrants puis on les ajoutes
		myConnexion.listen();
	}
	
	public void addMessage(Message m) {
		setChanged();
		notifyObservers(m.getContent());
	}
}
