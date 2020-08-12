package com.dream.plugin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Hunger(), this);
	}
	@Override
	public void onDisable() {
		
	}
}