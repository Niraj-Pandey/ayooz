package org.ayooz.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class NetworkService implements Runnable {
	
   private ServerSocket serverSocket;
   private ExecutorService pool;

   public NetworkService(int port, int poolSize){
     try {
    	 serverSocket = new ServerSocket(port);
	     pool = Executors.newFixedThreadPool(poolSize);
	} catch (IOException e) {
		e.printStackTrace();
	}
   }

   public void run() { // run the service
     try {
       for (int i=0;;i++) {
         pool.execute(new Handler(serverSocket.accept(),i));
       }
     } catch (IOException ex) {
       pool.shutdown();
     }
   }
   void shutdownAndAwaitTermination(ExecutorService pool) {
	   pool.shutdown(); // Disable new tasks from being submitted
	   try {
	     // Wait a while for existing tasks to terminate
	     if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
	       pool.shutdownNow(); // Cancel currently executing tasks
	       // Wait a while for tasks to respond to being cancelled
	       if (!pool.awaitTermination(60, TimeUnit.SECONDS))
	           System.err.println("Pool did not terminate");
	     }
	   } catch (InterruptedException ie) {
	     // (Re-)Cancel if current thread also interrupted
	     pool.shutdownNow();
	     // Preserve interrupt status
	     Thread.currentThread().interrupt();
	   }
	 }
 }
