package com.uiuc.udp;

import java.io.IOException;
import java.net.*;

public class UDPServer {
	public void startServer(Integer port1) throws IOException {
		DatagramSocket serverSocket = new DatagramSocket(port1);
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String modifiedSentence = sentence.toUpperCase();
			sendData = modifiedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
		}
	}

}