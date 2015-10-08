package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import network.Message.TypeMessage;

/**
* Classe permettant d'accueilir dans un thread une nouvelle connexion au serveur
*/
public class ServerThread extends Thread {

	private Socket mySocket;
	
	public ServerThread(Socket _s) {
		this.mySocket = _s;
	}
	
	@Override
	public void run() {
		super.run();
		
		ObjectInputStream buffIN = null;
		try {
			buffIN = new ObjectInputStream(this.mySocket.getInputStream());
			Message mess = (Message)buffIN.readObject();
			if (mess != null) {
				
				if(mess.getType().equals(TypeMessage.LISTEN))
					new ServerThreadListen(this.mySocket).start();
				
			}
			else {
				System.out.println("Message not received");
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				buffIN.close();
				this.mySocket.close();
				System.out.println("Client déconnecté");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}