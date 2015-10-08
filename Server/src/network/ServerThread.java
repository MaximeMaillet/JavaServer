package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

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
		
		BufferedReader buffIN = null;
		PrintStream buffOUT = null;
		StringBuilder result = new StringBuilder();
		
		try {
			while(true)
			{
				// Init buffers in/out
				buffIN = new BufferedReader(new InputStreamReader(this.mySocket.getInputStream()));
				buffOUT = new PrintStream(this.mySocket.getOutputStream());
				
				System.out.println("Attente de valeurs");
				String request = buffIN.readLine();
				if(request == null || request.equals("END"))
					break;
				System.out.println(request);
				
				
				buffOUT.println("coucou");
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				buffIN.close();
				buffOUT.close();
				this.mySocket.close();
				System.out.println("Client déconnecté");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}