package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket myServerSocket;
	
	public Server()
	{
		try {
			
			this.myServerSocket = new ServerSocket(7013);
			System.out.println("Server start");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void StopServer() {
		try {
			this.myServerSocket.close();
			System.out.println("Serveur stopp� !");
		}
		catch(IOException e) {
			System.out.println("Erreur lors de l'arr�t du serveur : "+e.getMessage());
		}
	}
	
	public ServerSocket getServer() {
		return this.myServerSocket;
	}
}
