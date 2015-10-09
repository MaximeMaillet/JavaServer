package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnexionThread implements Runnable {

	private Socket socket;
	protected ObjectInputStream fluxEntree;
	protected ObjectOutputStream fluxSortie;
	protected Message message;
	
	public ConnexionThread(Socket sock, Message _message)
	{
		this.socket = sock;
		this.message = _message;
		
		try {
			
			this.fluxSortie = new ObjectOutputStream(this.socket.getOutputStream());
			this.fluxEntree = new ObjectInputStream(this.socket.getInputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void close()
	{
		try {
			
			this.fluxEntree.close();
			this.fluxSortie.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
