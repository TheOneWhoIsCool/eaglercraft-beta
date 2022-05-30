package net.lax1dude.eaglercraft.beta.server.commands;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.lax1dude.eaglercraft.beta.server.EaglercraftServer;
import net.lax1dude.eaglercraft.beta.server.PasswordManager;
import net.lax1dude.eaglercraft.beta.server.PasswordManager.PasswordEntry;
import net.minecraft.server.EaglercraftWebsocketNetworkManager;

public class CommandChangePassword extends EaglerCommand {

	public CommandChangePassword() {
		super("change-password");
		setNeedsOp(false);
		setAliases(Arrays.asList("change-pass"));
		setTooltip("Change you current password");
		setUsage("/change-password <password>");
	}

	@Override
	protected void execute(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			if(!EaglercraftServer.hasPasswordDB()) {
				sender.sendMessage(ChatColor.RED + "Error: the password database is not initialized, it probably won't save your changes");
			}
			if(args.length != 1) {
				throw new IncorrectUsageException("this command only takes 1 argument!");
			}
			
			if(((CraftPlayer)sender).getHandle().a.b instanceof EaglercraftWebsocketNetworkManager) {
				PasswordEntry et = PasswordManager.load(((Player)sender).getName());
				if(et != null) {
					PasswordManager.create(et.username, args[0], et.expiresAfter);
					sender.sendMessage("Your password for '" + et.username + "' was changed.");
				}else {
					sender.sendMessage(ChatColor.RED + "You do not have a password!");
				}
			}else {
				sender.sendMessage(ChatColor.RED + "You are not connected via websocket, so this command is unavailable");
			}
		}else {
			sender.sendMessage(ChatColor.RED + "Error: only players can run this command");
		}
	}

}
