package net.lax1dude.eaglercraft.beta.server.commands;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import net.lax1dude.eaglercraft.beta.server.EaglercraftServer;
import net.lax1dude.eaglercraft.beta.server.PasswordManager;

public class CommandSetPassword extends EaglerCommand {

	public CommandSetPassword() {
		super("set-password");
		setAliases(Arrays.asList("set-pass"));
		setTooltip("Sets a password on a username for Eaglercraft connections");
		setUsage("/set-password <username> <password> [expires][s|m|h|d|w]");
	}

	@Override
	protected void execute(CommandSender sender, String[] args) {
		if(!EaglercraftServer.hasPasswordDB()) {
			sender.sendMessage(ChatColor.RED + "Error: the password database is not initialized, it probably won't save your changes");
		}
		if(args.length != 2 && args.length != 3) {
			throw new IncorrectUsageException("this command takes 2 or 3 arguments!");
		}
		if(args[0].length() > 16) {
			throw new IncorrectUsageException("the maximum length for a username is 16 characters!");
		}
		int expires = -1;
		if(args.length == 3) {
			int mul = 60 * 60 * 24;
			String exp = args[2].toLowerCase();
			if(exp.endsWith("s")) {
				mul = 1;
				exp = exp.substring(0, exp.length() - 1);
			}else if(exp.endsWith("m")) {
				mul = 60;
				exp = exp.substring(0, exp.length() - 1);
			}else if(exp.endsWith("h")) {
				mul = 60 * 60;
				exp = exp.substring(0, exp.length() - 1);
			}else if(exp.endsWith("d")) {
				exp = exp.substring(0, exp.length() - 1);
			}else if(exp.endsWith("w")) {
				mul = 60 * 60 * 24 * 7;
				exp = exp.substring(0, exp.length() - 1);
			}
			try {
				expires = Integer.parseInt(exp) * mul;
			}catch(NumberFormatException ex) {
				throw new IncorrectUsageException("The number '" + exp + "' is invalid!");
			}
			if(expires < 1) {
				throw new IncorrectUsageException("Expires time must be positive!");
			}
		}
		PasswordManager.create(args[0], args[1], expires);
		sender.sendMessage("Password for '" + args[0] + "' was changed");
	}

}
