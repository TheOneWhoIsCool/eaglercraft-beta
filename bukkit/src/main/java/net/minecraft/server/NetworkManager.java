package net.minecraft.server;

import java.net.SocketAddress;

public interface NetworkManager {
	
	/**
	 * Set the NetHandler
	 */
	void a(NetHandler var1);
	
	/**
	 * addToSendQueue
	 */
	void a(Packet var1);
	
	/**
	 * disconnect
	 */
	void a(String var1, Object... var2);
	
	/**
	 * processReadPackets
	 */
	void a();
	
	/**
	 * gets the remote address
	 */
	SocketAddress b();
	
	/**
	 * shuts connection down
	 */
	void c();
	
	/**
	 * gets a number of delayed packets
	 */
	int d();
	
	/**
	 * gets if the connection is closed
	 */
	boolean isDead();
}
