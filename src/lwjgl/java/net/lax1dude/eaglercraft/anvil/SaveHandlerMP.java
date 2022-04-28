package net.lax1dude.eaglercraft.anvil;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import java.util.List;

import net.minecraft.src.IChunkLoader;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldProvider;

public class SaveHandlerMP implements ISaveHandler {

	public SaveHandlerMP() {
	}

	public WorldInfo getWorldInfo() {
		return null;
	}

	public void checkSessionLock() {
	}

	public IChunkLoader getChunkLoader(WorldProvider worldprovider) {
		return null;
	}

	public void saveWorldAndPlayer(WorldInfo worldinfo, List list) {
	}

	public void saveWorldInfo(WorldInfo worldinfo) {
	}
}
