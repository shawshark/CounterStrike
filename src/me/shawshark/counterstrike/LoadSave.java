package me.shawshark.counterstrike;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

public class LoadSave {
	
	public main m;
	
	public LoadSave(main m) {
		this.m = m;
	}
	
	public void saveArenas() {
		FileConfiguration c = m.getConfig();
		
		List<String> ArenaToString = new ArrayList<String>();
		
		int count = 0;
		
		for ( Arena a : m.arenas)
		{
			count++;
			String gametype = a.gametype;
			String name = a.name;
			int arenaid = a.arenaid;
			int total_limit = a.total_limit;
			
			String s = gametype + "," + name + "," + arenaid + "," + total_limit;
			ArenaToString.add(s);
		}
		
		c.set("server.arenas", ArenaToString);
		m.saveConfig();
		
		System.out.println("<CSS> Saved " + count + " arenas!");
		
		ArenaToString.clear();
	}
	
	public void loadArenas() {
		FileConfiguration c = m.getConfig();
		
		@SuppressWarnings("unused")
		int count = 0;
		
		for ( String i : c.getStringList("server.arenas")) 
		{
			count++;
			
			String[] s = i.split(",");
			
			String gametype = s[0];
			String name = s[1];
			int arenaid = Integer.parseInt(s[2]);
			int total_allowed = Integer.parseInt(s[3]);
			
			m.arenas.add(new Arena(gametype, arenaid, name, total_allowed));
		}
		System.out.println("<CSS> Loaded " + count + " arenas!");
	}
}
