package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConnexionThread implements Runnable {
	
	private boolean isConnect = false;
	private Socket socket;
	private BufferedReader fluxEntree;
	private PrintWriter fluxSortie;
	
	public ConnexionThread(Socket sock)
	{
		this.socket = sock;
	}
	
	@Override
	public void run() {
		
		try
		{
			this.fluxEntree = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.fluxSortie = new PrintWriter(socket.getOutputStream());
			Scanner sc = new Scanner(System.in);
		
			while(!isConnect)
			{
				// Le serveur demande de se connecter
				System.out.println(this.fluxEntree.readLine());
				// L'user rentre son login
				this.fluxSortie.println(sc.nextLine());
				this.fluxSortie.flush();
				// Le serveur r�pond son message sous forme d'un boolean
				boolean reponseConnect = Boolean.parseBoolean(this.fluxEntree.readLine());
				// S'il est correctement connect�
					if(reponseConnect) {
						isConnect = true;
						System.out.println("Tu es connect�");
					}
					else {
						System.out.println("Le login est incorrect");
					}
			}
		}
		catch(IOException e) {
			System.out.println("[Erreur TC] : "+e.getMessage());
		}
	}
}
