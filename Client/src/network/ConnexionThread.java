package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConnexionThread implements Runnable {

	private Socket socket;
	protected BufferedReader fluxEntree;
	protected PrintWriter fluxSortie;
	protected Message message;
	
	public ConnexionThread(Socket sock, Message _message)
	{
		this.socket = sock;
		this.message = _message;
		try {
			
			this.fluxEntree = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.fluxSortie = new PrintWriter(this.socket.getOutputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void close()
	{
		try {
			
			this.fluxEntree.close();
			this.fluxSortie.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
