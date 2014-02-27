package com.uiuc.utils;

/**
 * 
 * @author Aman's Alien
 * 
 */
public class Message {
	public int id;
	public Integer lamportTime;
	public int[] vectorTime = new int[4];

	public Message(int id, int lamport, int[] ve) {
		this.id = id;
		this.lamportTime = lamport;
		this.vectorTime = ve;
	}

}
