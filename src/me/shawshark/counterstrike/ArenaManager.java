package me.shawshark.counterstrike;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ArenaManager {
	
	public main m;
	public List<JoinArena> playersInArenas = new ArrayList<JoinArena>();
	
	public ArenaManager(main m) {
		this.m = m;
	}
	
	public int getPlayerArena(String pname) {
		int arena = 0;
		for ( JoinArena i : playersInArenas )
		{
			if(i.pname == pname)
			{
				arena = i.id;
			}
		}
		
		return arena;
	}
	
	public void sendMessage(String message, int arenaid) {
		for ( Player p : m.getServer().getOnlinePlayers() )
		{
			if ( getPlayerArena(p.getName()) == arenaid)
			{
				p.sendMessage(message);
			}
		}
	}
	
	public void leaveArena(String pname) {
		
		for ( JoinArena i : playersInArenas) 
		{
			if(playersInArenas.contains(new JoinArena(i.id, pname))) 
			{
				Player p = Bukkit.getPlayer(pname);
				{
					if(p != null)
					{
						playersInArenas.remove(new JoinArena(i.id, pname));
					}
				}
				
			}
			
		}
		
	}
	
	public void joinArena(String pname, int id) {
		
		if(!playersInArenas.contains(new JoinArena(id, pname)))
		{
			Player p = Bukkit.getPlayer(pname);
			
			if(p != null)
			{
				for ( Arena a : m.arenas)
				{
					if(a.arenaid == id)
					{
						int total_allowed = a.total_limit;
						int counter = 0;
						
						for ( JoinArena i : playersInArenas )
						{
							if(i.id == id)
							{
								counter++;
							}

						}
						
						
						if(!playersInArenas.contains(new JoinArena(id, pname)))
						{
							
							if(counter > total_allowed || counter == total_allowed)
							{
								// can't join arena
							} else {
								// can join arena.
							}
							
						} else {
							// already in arena...
						}
						
						
					}
				}
			}
		}
	}
}
