package net.lax1dude.eaglercraft.beta.server.commands;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.lax1dude.eaglercraft.beta.server.EaglercraftServer;
import net.lax1dude.eaglercraft.beta.server.PasswordManager;
import net.minecraft.server.EaglercraftWebsocketNetworkManager;

public class CommandRenewPassword extends EaglerCommand {

	public CommandRenewPassword() {
		super("renew-password");
		setAliases(Arrays.asList("renew-pass", "password-renew", "pass-renew"));
		setNeedsOp(false);
		setTooltip("Renews a password for a username, or your own username, for Eaglercraft connections");
		setUsage("\"/renew-password\" or \"/renew-password [time]\" or, for ops, \"/renew-password [username]\" or \"/renew-password [username] [time]\"");
	}

	@Override
	protected void execute(CommandSender sender, String[] args) {
		
		// Tomorrow: program this command
		
		
		if(!EaglercraftServer.hasPasswordDB()) {
			sender.sendMessage(ChatColor.RED + "Error: the password database is not initialized, it probably won't save your changes");
		}
		if(sender instanceof CraftPlayer && ((CraftPlayer)sender).getHandle().a.b instanceof EaglercraftWebsocketNetworkManager && (args.length == 0 || (args.length == 1 && args[0].equalsIgnoreCase(((Player)sender).getName())))) {
			if(PasswordManager.delete(((Player)sender).getName())) {
				sender.sendMessage("Your password was removed.");
			}else {
				sender.sendMessage(ChatColor.RED + "You do not have a password on this account!");
			}
		}else if(args.length != 1) {
			throw new IncorrectUsageException("this command only takes 1 argument!");
		}
		if(sender.isOp())  {
			if(PasswordManager.delete(args[0])) {
				sender.sendMessage("Password for '" + args[0] + "' was removed");
			}else {
				sender.sendMessage(ChatColor.RED + "The user '" + args[0] + "' does not have a password!");
			}
		}else {
			sender.sendMessage(ChatColor.RED + "Error: you need /op to use this command!");
		}
	}

}
