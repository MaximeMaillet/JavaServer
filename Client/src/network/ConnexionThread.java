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
			this.isConnect = true;
			this.fluxEntree = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.fluxSortie = new PrintWriter(socket.getOutputStream());
			Scanner sc = new Scanner(System.in);
			String message = null;
		
			while(this.isConnect)
			{
				// Le serveur demande de se connecter
				//System.out.println(this.fluxEntree.readLine());
			
				// L'user rentre son login
				message = sc.nextLine();
				this.fluxSortie.println(message);
				this.fluxSortie.flush();
				System.out.println("Message send");
				
				System.out.println(this.fluxEntree.readLine());
				
				if(message== null || message.equals("END"))
					this.isConnect = false;
			}
		}
		catch(IOException e) {
			System.out.println("[Erreur TC] : "+e.getMessage());
		}
		finally
		{
			try {
				this.fluxEntree.close();
				this.fluxEntree.close();
				this.socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
