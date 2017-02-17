package com.encrox.social;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;

public class Database {
	
	private static Connection con;
	
	public static void init() throws Exception {
		JSONObject sqlConfig = Social.config.getJSONObject("sql");
		con = (Connection) DriverManager.getConnection(sqlConfig.getString("dsn"), sqlConfig.getString("username"), sqlConfig.getString("password"));
	}
	
	public static ArrayList<String> getFriends(String playerUUID) throws SQLException {
		ArrayList<String> out = new ArrayList<String>();
		ResultSet r = con.createStatement().executeQuery("SELECT * FROM friends WHERE a = " + playerUUID.toString());
		while(r.next()) {
			out.add(r.getString("b"));
		}
		return out;
	}
	
	public static void addFriendship(String firstUUID, String secondUUID) throws SQLException {
		con.createStatement().executeQuery("INSERT INTO friends (a, b) VALUES ('" + firstUUID + "', '" + secondUUID + "')");
	}

}
