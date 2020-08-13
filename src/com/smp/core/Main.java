package com.smp.core;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gmc").setExecutor(new Commands());
        getCommand("gm").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new Hunger(), this);
    }
    @Override
    public void onDisable() {

    }
}