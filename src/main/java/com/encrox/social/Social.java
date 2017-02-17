package com.encrox.social;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.JSONObject;

import com.encrox.instancedregions.Commander;

public class Social extends JavaPlugin {
	
	public static Logger logger;
	public static PluginDescriptionFile pdf;
	public static Properties locale;
	public static JSONObject config;
	public static ArrayList<SocialPlayer> onlinePlayers;
	public static ArrayList<FriendRequest> friendRequests;
	
	public void onEnable() {
		pdf = getDescription();
		logger = Logger.getLogger("Minecraft");
		if(setupMyself()) {
			getCommand("social").setExecutor(new Commander());
			logger.info(pdf.getName() + " " + pdf.getVersion() + " has been enabled.");
		} else {
			logger.info(pdf.getName() + " " + pdf.getVersion() + " has been disabled.");
		}
	}
	
	private boolean setupMyself() {
		if(!this.getDataFolder().exists())
			this.getDataFolder().mkdirs();
		File configFile = new File(this.getDataFolder(), "config.json");
		if(!configFile.exists()) {
			BufferedInputStream bis;
			FileOutputStream out;
			try {
				bis = new BufferedInputStream(getClass().getClassLoader().getResourceAsStream("config.json"));
				out = new FileOutputStream(configFile);
				int current;
				while((current = bis.read()) != -1) {
					out.write(current);
				}
				bis.close();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		BufferedReader br;
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			br = new BufferedReader(new FileReader(configFile));
			while((line = br.readLine()) != null)
				sb.append(line);
			br.close();
		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
		config = new JSONObject(sb.toString());
		return true;
	}
	
	public static SocialPlayer getSocialPlayer(Player player) {
		Iterator<SocialPlayer> iter = onlinePlayers.iterator();
		SocialPlayer next;
		while(iter.hasNext()) {
			if((next = iter.next()).getPlayer().equals(player)) {
				return next;
			}
		}
	}
	
	public static boolean requestFriendship(Player from, Player to)

}
