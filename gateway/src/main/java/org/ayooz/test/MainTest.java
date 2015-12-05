package org.ayooz.test;

public class MainTest {

	public static void main(String[] args) {
		
		NetworkService nNetworkService=new NetworkService(2001,3);
		nNetworkService.run();

	}

}
