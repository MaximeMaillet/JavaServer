package network;

import java.net.Socket;

public class ServerThreadListen extends Thread {

	private Socket mySocket;
	
	public ServerThreadListen(Socket _s) {
		this.mySocket = _s;
	}
	
	@Override
	public void run() {
		super.run();
		
		while(true)
		{
		
		}
	}
}
