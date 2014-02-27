package com.uiuc.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPClient {

	public String send(String data, String ip, Integer port) {
		DatagramSocket clientSocket = null;
		InetAddress IPAddress = null;
		String modifiedSentence = null;
		try {
			clientSocket = new DatagramSocket();
			IPAddress = InetAddress.getByName(ip);
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];

			sendData = data.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, 9876);
			clientSocket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			clientSocket.receive(receivePacket);
			modifiedSentence = new String(receivePacket.getData());
			System.out.println("From Server: " + modifiedSentence);
			clientSocket.close();

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modifiedSentence;

	}

}