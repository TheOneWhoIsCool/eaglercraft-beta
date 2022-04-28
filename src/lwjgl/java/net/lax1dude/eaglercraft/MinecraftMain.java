package net.lax1dude.eaglercraft;

import java.io.File;

import javax.swing.JOptionPane;

import net.lax1dude.eaglercraft.anvil.SaveConverterMcRegion;
import net.minecraft.client.Minecraft;

public class MinecraftMain {

	public static void main(String[] par0ArrayOfStr) {

		JOptionPane.showMessageDialog(null, "launch renderdoc (optionally) and press ok to continue", "eaglercraft",
				JOptionPane.PLAIN_MESSAGE);
		EaglerAdapter.initializeContext();

		for(int i = 0; i < par0ArrayOfStr.length; ++i) {
			String arg = par0ArrayOfStr[i];
			if("--anvilSaveFormat".equalsIgnoreCase(arg)) {
				EaglerAdapter.configureSaveFormat(new SaveConverterMcRegion(new File("lwjgl_saves")));
			}
		}
		
		/*
		 * LocalStorageManager.loadStorage(); byte[] b =
		 * EaglerAdapter.loadLocalStorage("forced"); if(b != null) {
		 * ServerList.loadDefaultServers(Base64.encodeBase64String(b)); }
		 * if(par0ArrayOfStr.length > 0) {
		 * EaglerAdapter.setServerToJoinOnLaunch(par0ArrayOfStr[0]); }
		 */

		// Minecraft.startMainThread(null, null, null);

		Minecraft mc = new Minecraft();
		mc.run();

	}
}
