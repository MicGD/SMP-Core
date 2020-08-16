package com.smp.core;

import com.smp.core.commands.Commands;
import com.smp.core.commands.Fly;
import com.smp.core.commands.God;
import com.smp.core.commands.VanishTest;
import com.smp.core.events.*;
import com.smp.core.teleportbow.commands.TeleportBow;
import com.smp.core.teleportbow.events.TeleportBowEvent;
import org.bukkit.ChatColor;
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
        getCommand("god").setExecutor(new God());
        getCommand("tpbow").setExecutor(new TeleportBow(this));
        getCommand("vanish").setExecutor(new VanishTest());
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&ePlugin enabling!"));
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&ePlugin enabled, developed by Michele Pipicelli."));

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new TeleportBowEvent(this), this);


    }
    @Override
    public void onDisable() {
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&cPlugin disabling!"));
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&cPlugin disabled!"));
    }
}