package network;

import java.io.IOException;
import java.net.Socket;

public class ConnexionThreadSend extends ConnexionThread {

	public ConnexionThreadSend(Socket sock, Message _message) {
		super(sock, _message);
	}

	@Override
	public void run() {
		super.run();
		try
		{
			this.fluxSortie.writeObject(this.message);
			this.fluxSortie.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			super.close();
		}
	}
}
