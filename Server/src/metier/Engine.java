package metier;

import java.util.Observable;

public class Engine extends Observable {

	private static Engine instance;
	private Engine()
	{
		
	}
	
	public static Engine getInstance() {
		if(instance==null)
			instance = new Engine();
		return instance;
	}
	
	public void writeMessage(String mess) {
		setChanged();
		notifyObservers(mess);
	}
}
