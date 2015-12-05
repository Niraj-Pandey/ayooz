//package org.ayooz.gateway;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class AThread implements Runnable{
//	
//	private Socket socket;
//	private PrintWriter pw;
//	private BufferedReader br;
//	
//	public AThread(Socket s){
//		socket = s;
//		try {
//			pw=new PrintWriter(socket.getOutputStream());
//			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void run(){
//		String tempLangue;
//		String s;
//		try {
//			
//			//Reception de la langue de client
//			tempLangue=br.readLine();
//			System.out.println("Reception de la langue :"+tempLangue);
//			tempLangue=br.readLine();
//			System.out.println("Reception de la langue cible :"+tempLangue);
//			
//			//Création d'un traducteur
//			Traduction t=new Traduction("AN",tempLangue);
//			
//			//tant que je recoi un message
//			while((s=br.readLine())!=null){
//				//Envoie de message correspendant
//				pw.println(t.getMessageTraduit(s));
//				pw.flush();
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
