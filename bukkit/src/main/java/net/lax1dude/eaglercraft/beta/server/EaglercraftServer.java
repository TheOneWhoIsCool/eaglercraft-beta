package net.lax1dude.eaglercraft.beta.server;

import java.io.File;
import java.io.IOException;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.util.config.Configuration;

import net.lax1dude.eaglercraft.beta.server.commands.*;

public class EaglercraftServer {
	
	private static final File dataFolder = new File(".");
	private static CraftServer server = null;
	private static CommandMap commands = null;
	private static PluginManager pluginManager = null;
	private static boolean passwordDBWorking = false;
	
	private static final Plugin dummyPlugin = new Plugin() {
		@Override public File getDataFolder() { return dataFolder; }
		@Override public PluginDescriptionFile getDescription() { return new PluginDescriptionFile("EaglercraftServer", "0.0.0", ""); }
		@Override public Configuration getConfiguration() { return null; }
		@Override public PluginLoader getPluginLoader() { return null; }
		@Override public Server getServer() { return server; }
		@Override public boolean isEnabled() { return true; }
		@Override public void onDisable() { }
		@Override public void onEnable() { }
		@Override
		public boolean onCommand(CommandSender var1, Command var2, String var3, String[] var4) {
			return false;
		}
	};

	public static void installHooks(CraftServer craftServer, CommandMap commandMap) {
		server = craftServer;
		commands = commandMap;
		pluginManager = craftServer.getPluginManager();
		
		try {
			PasswordManager.loadPasswordDB();
			passwordDBWorking = true;
		} catch (IOException e) {
			PasswordManager.log.severe("ERROR: could not create or load password database!");
			PasswordManager.log.severe("Eaglercraft will not function correctly, unless you disable password login");
			e.printStackTrace();
			passwordDBWorking = false;
		}

		registerCommand(new CommandSetPassword());
		registerCommand(new CommandChangePassword());
		registerCommand(new CommandClearPassword());
		registerCommand(new CommandListPasswords());
		registerCommand(new CommandPasswordExpires());
		
	}
	
	public static boolean hasPasswordDB() {
		return passwordDBWorking;
	}

	private static void registerCommand(Command command) {
		commands.register(command.getName(), "eagler", command);
	}

}
