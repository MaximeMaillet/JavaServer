package metier;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import network.Message;

public class ListMessage extends Observable {

	private ArrayList<String> messages;
	
	public ListMessage() {
		
	}
	
	public ListMessage(Observer _obs) {
		this.addObserver(_obs);
	}
	
	public void add(String m) {
		this.messages.add(m);
	}
}
