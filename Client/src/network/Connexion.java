package network;

import java.io.IOException;
import java.net.Socket;

import network.Message.TypeMessage;

public class Connexion {

	private String ipServer = "192.168.1.13";
	private int portServer = 7013;
	private Socket mySocket = null;
	
	public Connexion()
	{
		try {
			
			this.mySocket = new Socket(this.ipServer, this.portServer);
			System.out.println("Demande de connexion");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(Message message)
	{
		new Thread(new ConnexionThreadSend(this.mySocket, message)).start();
	}
	
	public Message receiveMessage()
	{
		Message messReturn = new Message();
		new Thread(new ConnexionThreadReceive(this.mySocket, messReturn)).start();
		return messReturn;
	}
	
	public void listen()
	{
		new Thread(new ConnexionThreadListen(this.mySocket, new Message("", TypeMessage.MESSAGE))).start();
	}
	
	public void disconnect()
	{
		try {
			this.mySocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
