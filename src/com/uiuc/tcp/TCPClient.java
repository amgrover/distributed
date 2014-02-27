package com.uiuc.tcp;

import java.io.*;
import java.net.*;

public class TCPClient {

	public String send(String dataToSend, String ip, Integer port) {
		Socket socket = null;
		String ouString = null;
		try {
			socket = new Socket(ip, port);
			DataOutputStream outToServer = new DataOutputStream(
					socket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			outToServer.writeBytes(dataToSend+"/n");
			ouString = inFromServer.readLine();

		} catch (UnknownHostException e) {
			System.out
					.println("Unknown Host Exception Retrying to connect.....");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				System.out.println("Unable to close socket");
			}
		}
		return ouString;
	}

}
