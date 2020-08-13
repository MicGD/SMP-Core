package com.smp.core;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gmc").setExecutor(new Commands());
        getCommand("gm").setExecutor(new Commands());
        getCommand("fly").setExecutor(new Commands());
        getCommand("heal").setExecutor(new Commands());
        getCommand("feed").setExecutor(new Commands());
        getCommand("clearchat").setExecutor(new Commands());
        getCommand("getpos").setExecutor(new Commands());
        getCommand("nick").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new Hunger(), this);
    }
    @Override
    public void onDisable() {
    }
}