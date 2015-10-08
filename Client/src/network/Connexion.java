package network;

import java.io.IOException;
import java.net.Socket;

public class Connexion {

	public static void main(String[] args)
	{
		try
		{
			Socket socket;
			socket = new Socket("192.168.1.13",7008);
			System.out.println("Demande de connexion");
			new Thread(new ConnexionThread(socket)).start();
		}
		catch (IOException e)
		{
			System.out.println("Erreur TC : "+e.getMessage());
		}
	}
}
