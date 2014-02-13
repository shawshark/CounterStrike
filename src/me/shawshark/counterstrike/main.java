package me.shawshark.counterstrike;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	public List<Arena> arenas = new ArrayList<Arena>();
	public List<SpawnLocation> spawns = new ArrayList<SpawnLocation>();
	
	public LoadSave ls;
	
	public void onEnable() {
		ls = new LoadSave(this);
		
		ls.loadArenas();
		ls.loadSpawnLocations();
	}
	
	public void onDisable() {
		ls.saveArenas();
		ls.SaveSpawnLocations();
	}
}
