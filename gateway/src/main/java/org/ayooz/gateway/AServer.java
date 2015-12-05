package org.ayooz.gateway;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AServer {
	
private int PORT;
private boolean running	= false;
private final int MAX_HOST_LENGTH =100;

private ServerSocket server;

public AServer() {
	try {
		server=new ServerSocket(PORT);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public void init(){
	
}
public void start() throws IOException{
	
	Socket connexion;
	while(true){
		System.out.println(".....................");
		connexion=server.accept();
		System.out.println("Nouvelle connexion");
		//Thread t = new Thread(new MyThread(connexion));
		//t.start();
		showParameters(connexion);
	}
}
public void showParameters(Socket connexion) {
	System.out.println("Les parametres de connexion : PORT:"+connexion.getLocalPort()+" Adresse :"+connexion.getInetAddress().getHostAddress());
}
public void showAllClient() {
	System.out.println("Le nombre des clients ");
}
}
