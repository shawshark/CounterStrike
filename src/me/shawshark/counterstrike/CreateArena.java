package me.shawshark.counterstrike;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CreateArena {

	public main m;
	
	public void createArena(String gametype, int arenaid, String name, int total_allowed, Player p) {
		if(p != null) 
		{
			if(total_allowed > 0) 
			{
				if(arenaid > 0)
				{
					m.arenas.add(new Arena(gametype, arenaid, name, total_allowed));
				} else {
					p.sendMessage(ChatColor.GOLD + "Arena id must be higher than 0");
				}
			} else {
				p.sendMessage(ChatColor.GOLD + "Total allowed players must be higher than 0");
			}
		}
	}
}
