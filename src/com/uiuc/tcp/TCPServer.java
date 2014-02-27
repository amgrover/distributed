package com.uiuc.tcp;

import java.io.*;
import java.net.*;

public class TCPServer {

	public void startServer(Integer port) throws IOException {
		String clientSentence;
		String modifiedSentence;
		ServerSocket welcomeSocket = new ServerSocket(port);
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(
					connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			modifiedSentence = clientSentence.toUpperCase() + "\n";
			outToClient.writeBytes(modifiedSentence);
		}
	}

}
