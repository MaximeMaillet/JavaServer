package main;

import java.io.IOException;
import java.net.Socket;

import network.Server;
import network.ServerThread;

public class Main {
	public static void main(String[] args) {
		try {
			
			// Init server
			Server myServer = new Server();
			Socket mySocket;
			
			while(true)
			{
				// Wait connexion
				mySocket = myServer.getServer().accept();
				new ServerThread(mySocket).start();
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
