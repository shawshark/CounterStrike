package me.shawshark.counterstrike;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	public List<Arena> arenas = new ArrayList<Arena>();
	public List<SpawnLocation> spawns = new ArrayList<SpawnLocation>();
	public List<Sign> signs = new ArrayList<Sign>();
	
	public LoadSave ls;
	public StartGame sg;
	public PlayerListener pl;
	public ArenaManager am;
	
	public void onEnable() {
		ls = new LoadSave(this);
		sg = new StartGame(this);
		pl = new PlayerListener(this);
		am = new ArenaManager(this);
		
		ls.loadArenas();
		ls.loadSpawnLocations();
		ls.loadsigns();
		
		Bukkit.getPluginManager().registerEvents(pl, this);
	}
	
	public void onDisable() {
		ls.saveArenas();
		ls.SaveSpawnLocations();
		ls.savesigns();
	}
}
