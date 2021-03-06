package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import metier.Engine;
import network.Message.TypeMessage;

/**
* Classe permettant d'accueilir dans un thread une nouvelle connexion au serveur
*/
public class ServerThread extends Thread implements Observer {

	private Socket mySocket;
	private TypeMessage typemessage;
	private ArrayList<String> messages;
	
	public ServerThread(Socket _s) {
		this.mySocket = _s;
		messages = new ArrayList<String>();
	}
	
	@Override
	public void run() {
		super.run();
		
		ObjectInputStream buffIN = null;
		ObjectOutputStream buffOUT = null;
		try {
			buffIN = new ObjectInputStream(this.mySocket.getInputStream());
			buffOUT = new ObjectOutputStream(this.mySocket.getOutputStream());
			Message mess = (Message)buffIN.readObject();
			this.typemessage = mess.getType();
			
			System.out.println("Client accepted ("+this.typemessage.toString()+") " + this.mySocket.getInetAddress().getHostAddress());
			
			if (mess != null) {
				
				if(mess.getType().equals(TypeMessage.LISTEN)) {
					Engine.getInstance().addObserver(this);
					this.listen(buffOUT);
				}
				else if(mess.getType().equals(TypeMessage.MESSAGE)) {
					Engine.getInstance().writeMessage(mess.getContent());
				}
				
			}
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				System.out.println("Connection closed ("+this.typemessage.toString()+") "+this.mySocket.getInetAddress().getHostAddress());
				buffIN.close();
				buffOUT.close();
				this.mySocket.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
	
	public void listen(ObjectOutputStream buffOUT) throws SocketException
	{
		int i = 0;
		String ip = this.mySocket.getInetAddress().getHostAddress();
		
		try {
			while(!this.mySocket.isClosed())
			{
				if(this.messages.size() > 0)
				{
					Message m = new Message(this.messages.get(0), TypeMessage.MESSAGE);
					buffOUT.writeObject(m);
					this.messages.remove(0);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.out.println("Connection closed ("+this.typemessage.toString()+") "+ip);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String s = (String)arg1;
		this.messages.add(s);
	}
}