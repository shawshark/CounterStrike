package me.shawshark.counterstrike;

import org.bukkit.event.Listener;

public class Arena implements Listener {
	public String gametype;
	public int arenaid;
	public String name;
	public int total_limit;
	public Arena(String igametype, int iarenaid, String iname, int itotal_limit) { gametype = igametype; arenaid = iarenaid; name = iname; total_limit = itotal_limit; }
}
