package com.encrox.social;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commander implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			SocialPlayer socialPlayer = Social.getSocialPlayer(player);
			switch(args[0]) {
			case "add":
				
			case "remove":
				
			}
			if(player.hasPermission("social.friends.limit."+(socialPlayer.getFriends().size()+1)) || player.hasPermission("social.friends.limit.*")) {
				
			}
		}
		return false;
	}

}
