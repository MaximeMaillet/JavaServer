package network;

import java.io.IOException;
import java.net.Socket;

import metier.Engine;
import network.Message.TypeMessage;

public class ConnexionThreadListen extends ConnexionThread {

	public ConnexionThreadListen(Socket sock, Message _message) {
		super(sock, _message);
	}
	
	@Override
	public void run() {
		super.run();
		System.out.print("k");
		try
		{
			this.fluxSortie.writeObject(new Message(null, TypeMessage.LISTEN));
			
			while(true)
			{
				Message m = (Message) this.fluxEntree.readObject();
				this.message.setContent(m.getContent());
				Engine.getInstance().addMessage(this.message);
			}
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			super.close();
		}
	}
}
