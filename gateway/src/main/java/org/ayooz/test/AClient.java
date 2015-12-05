package org.ayooz.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class AClient {
	private Socket socket;
	private BufferedReader response;
	private PrintWriter request;
	
	public AClient() {
		super();
		try {
			socket=new Socket(InetAddress.getLocalHost(),2001);
			request=new PrintWriter(socket.getOutputStream());
			response=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void sendMessage(final String message){
		request.println(message);
		request.flush();
	}
	public void readMessage(){
		try {
			response.close();
			System.out.println("Message reçu : "+response.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public BufferedReader getResponse() {
		return response;
	}
	public void setResponse(BufferedReader response) {
		this.response = response;
	}
	public PrintWriter getRequest() {
		return request;
	}
	public void setRequest(PrintWriter request) {
		this.request = request;
	}
}
