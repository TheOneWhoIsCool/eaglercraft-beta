package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 


public class NetworkManager {

	public NetworkManager(String s, NetHandler nethandler) {

	}

	public void addToSendQueue(Packet packet) {

	}

	private void sendPacket() {

	}

	private void readPacket() {

	}

	public void networkShutdown(String s, Object aobj[]) {

	}

	public void processReadPackets() {

	}

	static boolean isRunning(NetworkManager networkmanager) {
		return false;
	}

	static boolean isServerTerminating(NetworkManager networkmanager) {
		return false;
	}

	static void readNetworkPacket(NetworkManager networkmanager) {
		networkmanager.readPacket();
	}

	static void sendNetworkPacket(NetworkManager networkmanager) {
		networkmanager.sendPacket();
	}

}
