package com.smp.core;

import com.smp.core.commands.Commands;
import com.smp.core.commands.Fly;
import com.smp.core.events.PlayerJoin;
import com.smp.core.events.PlayerLeave;
import com.smp.core.events.PlayerMove;
import com.smp.core.teleportbow.commands.TeleportBow;
import com.smp.core.teleportbow.events.TeleportBowEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gmc").setExecutor(new Commands());
        getCommand("gm").setExecutor(new Commands());
        getCommand("fly").setExecutor(new Fly());
        getCommand("heal").setExecutor(new Commands());
        getCommand("feed").setExecutor(new Commands());
        getCommand("clearchat").setExecutor(new Commands());
        getCommand("getpos").setExecutor(new Commands());
        getCommand("nick").setExecutor(new Commands());
        getCommand("teleport").setExecutor(new Commands());
        getCommand("msg").setExecutor(new Commands());
        getCommand("kill").setExecutor(new Commands());
        getCommand("tpbow").setExecutor(new TeleportBow(this));

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new TeleportBowEvent(this), this);


    }
    @Override
    public void onDisable() {
    }
}