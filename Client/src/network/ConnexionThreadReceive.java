package network;

import java.io.IOException;
import java.net.Socket;

public class ConnexionThreadReceive extends ConnexionThread {

	public ConnexionThreadReceive(Socket sock, Message _message) {
		super(sock, _message);
	}
	
	@Override
	public void run() {
		super.run();
		try
		{
			try {
				this.message.setContent(this.fluxEntree.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		finally
		{
			super.close();
		}
	}
}
