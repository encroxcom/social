package com.encrox.social;

import org.bukkit.entity.Player;

public class FriendRequest {
	
	private SocialPlayer from, to;
	
	public FriendRequest(SocialPlayer from, SocialPlayer to) {
		this.from = from;
		this.to = to;
	}
	
	public boolean contains(Player player) {
		return (from.getPlayer().equals(player) || to.getPlayer().equals(player));
	}

}
