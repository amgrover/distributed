package com.uiuc.utils;

import java.io.IOException;

import com.uiuc.tcp.TCPClient;
import com.uiuc.tcp.TCPServer;

/**
 * 
 * @author Aman's Alien
 * 
 */
public class Driver {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		TCPServer server = new TCPServer();
		server.startServer(Constants.TCP_PORT);
		TCPClient client = new TCPClient();
		client.send("Aman", Constants.TCP_IP, Constants.TCP_PORT);
//		Integer i = new Integer(1);
//		new Driver().recurse(i);
//		System.out.println(i);

	}

	public void recurse(Integer i) {
		++i;
	}

}
