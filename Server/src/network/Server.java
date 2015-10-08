package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Main class
 * @author 2Max
 *
 */
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
			System.out.println("Serveur stoppé !");
		}
		catch(IOException e) {
			System.out.println("Erreur lors de l'arrêt du serveur : "+e.getMessage());
		}
	}
	
	public ServerSocket getServer() {
		return this.myServerSocket;
	}
	
	public static void main(String[] args) {
		try {
			
			// Init server
			Server myServer = new Server();
			Socket mySocket;
			
			while(true)
			{
				// Wait connexion
				mySocket = myServer.getServer().accept();
				System.out.println("Client accepté");
				new ServerThread(mySocket).start();
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
