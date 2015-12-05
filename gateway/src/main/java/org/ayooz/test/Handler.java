package org.ayooz.test;

import java.net.Socket;

class Handler implements Runnable {
	
   private final Socket socket;
   private final int id;
   
   Handler(Socket socket,int id) { 
	   this.socket = socket;
	   this.id=id;
   }
   
   public void run() {
	   System.out.println("Thread id "+id);
   }
 }
