package com.encrox.social;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class SocialPlayer {
	
	public boolean partyInviteAllowedFriends, partyInviteAllowedAll;
	
	private Player player;
	private ArrayList<SocialPlayer> onlineFriends;
	private ArrayList<Player> friends;
	
	public SocialPlayer(Player player) {
		this.player = player;
		try {
			Iterator<String> iter = Database.getFriends(player.getUniqueId().toString()).iterator();
			while(iter.hasNext()) {
				friends.add(Bukkit.getPlayer(UUID.fromString(iter.next())));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void friendOnline(SocialPlayer player) {
		onlineFriends.add(player);
	}
	
	public void friendOffline(SocialPlayer player) {
		onlineFriends.remove(player);
	}
	
	public ArrayList<Player> getFriends() {
		return friends;
	}
	
	public Player getPlayer() {
		return player;
	}

}
