package com.encrox.social;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Party {
	
	private ArrayList<Player> players, ops;
	private int limit;
	
	public Party(int limit) {
		players = new ArrayList<Player>();
		ops = new ArrayList<Player>();
		this.limit = limit;
	}
	
	public byte addPlayer(Player player) {
		if(players.size() == limit) {
			return Results.Party.Add.LIMIT;
		} else {
			players.add(player);
			return Results.Party.Add.OK;
		}
	}
	
	public byte opPlayer(Player player) {
		if(players.contains(player)) {
			if(ops.contains(player)) {
				return Results.Party.Op.ALREADY_OP;
			} else {
				ops.add(player);
				return Results.Party.Op.OK;
			}
		} else {
			return Results.Party.Op.NOT_IN_PARTY;
		}
	}
	
	public byte deopPlayer(Player player) {
		if(players.contains(player)) {
			if(ops.contains(player)) {
				ops.remove(player);
				return Results.Party.Deop.OK;
			} else {
				return Results.Party.Deop.NOT_OP;
			}
		} else {
			return Results.Party.Op.NOT_IN_PARTY;
		}
	}
	
	public byte removePlayer(Player player) {
		if(players.contains(player)) {
			players.remove(player);
			if(ops.contains(player))
				ops.remove(player);
			return Results.Party.Remove.OK;
		} else {
			return Results.Party.Remove.NOT_EXIST;
		}
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public boolean isOp(Player player) {
		if(ops.contains(player))
			return true;
		else
			return false;
	}

}
