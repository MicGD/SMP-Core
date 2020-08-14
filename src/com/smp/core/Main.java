package com.smp.core;

import com.smp.core.commands.Commands;
import com.smp.core.events.CreatureSpawn;
import com.smp.core.events.PlayerJoin;
import com.smp.core.events.PlayerLeave;
import com.smp.core.events.PlayerMove;
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
        getCommand("teleport").setExecutor(new Commands());
        getCommand("broadcast").setExecutor(new Commands());
        getCommand("msg").setExecutor(new Commands());
        getServer().getPluginManager().registerEvents(new CreatureSpawn(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
    }
    @Override
    public void onDisable() {
    }
}