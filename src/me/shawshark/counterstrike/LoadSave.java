package me.shawshark.counterstrike;

import java.util.ArrayList;
import java.util.List;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class LoadSave {
	
	public main m;
	int count;
	
	public LoadSave(main m) {
		this.m = m;
	}
	
	public void saveArenas() {
		count = 0;
		
		FileConfiguration c = m.getConfig();
		
		List<String> ArenaToString = new ArrayList<String>();
		
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
		count = 0;
		
		FileConfiguration c = m.getConfig();
		
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
	
	public void loadSpawnLocations() {
		count = 0;
		
		FileConfiguration c = m.getConfig();
		
		for ( String i : c.getStringList("server.spawnlocations"))
		{
			count++;
			
			String[] s = i.split(",");
			
			String world = s[0];
			int id = Integer.parseInt(s[1]);
			int x = Integer.parseInt(s[2]);
			int y = Integer.parseInt(s[3]);
			int z = Integer.parseInt(s[4]);
			
			int arenaid = Integer.parseInt(s[5]);
			
			Location loc = new Location(Bukkit.getServer().getWorld(world), x, y, z);
			
			m.spawns.add(new SpawnLocation(loc, id, arenaid));
		}
		System.out.println("<CSS> Loaded " + count + " spawn locations!");
	}
	
	public void SaveSpawnLocations() {
		count = 0;
		
		List<String> SpawnLocationsToString = new ArrayList<String>();
		FileConfiguration c = m.getConfig();
		
		for( SpawnLocation s : m.spawns)
		{
			count++;
			String world = s.loc.getWorld().getName();
			int id = s.id;
			int x = s.loc.getBlockX();
			int y = s.loc.getBlockY();
			int z = s.loc.getBlockZ();
			
			int arenaid = s.arenaid;
			
			String i = world + "," + id + "," + x + "," + y + "," + z + "," + arenaid;
			SpawnLocationsToString.add(i);
		}
		
		c.set("server.spawnlocations", SpawnLocationsToString);
		m.saveConfig();
		
		System.out.println("<CSS> Saved " + count + " spawn locations!");
		
		SpawnLocationsToString.clear();
		
	}
	
	public void savesigns() {
		int count = 0;
		FileConfiguration c = m.getConfig();
		
		List<String> savesigns = new ArrayList<String>();
		
		for ( Sign i : m.signs) 
		{
			count++;
			String arenaid = i.arenaid;
			String world = i.loc.getWorld().getName();
			int x = i.loc.getBlockX();
			int y = i.loc.getBlockY();
			int z = i.loc.getBlockZ();
			String s = arenaid + "," + world + "," + x + "," + y + "," + z;
			savesigns.add(s);
		}
		
		c.set("server.signs", savesigns);
		m.saveConfig();
		
		System.out.println("<CSS> Saved " + count + " signs!");
		
		savesigns.clear();
		m.signs.clear();
	}
	
	public void loadsigns() {
		
		int count = 0;
		
		FileConfiguration c = m.getConfig();
		
		for ( String i : c.getStringList("server.signs")) 
		{
			
			String[] s = i.split(",");
			count++;
				
			String arenaid = s[0];
			String world = s[1];
				
			int x = Integer.parseInt(s[2]);
			int y = Integer.parseInt(s[3]);
			int z = Integer.parseInt(s[4]);
				
			World w = Bukkit.getServer().getWorld(world);				
			Location loc = new Location(w, x, y, z);
			
			m.signs.add(new Sign(arenaid, loc));
		}
		System.out.println("<CSS> Loaded " + count + " signs!");
	}
}
