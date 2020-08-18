package com.smp.core;

import com.smp.core.commands.*;
import com.smp.core.events.*;
import com.smp.core.teleportbow.commands.TeleportBow;
import com.smp.core.teleportbow.events.TeleportBowEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public BossBar bar;
    
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        bar = new BossBar(this);
        bar.createBar();


        if(Bukkit.getOnlinePlayers().size() > 0)
            for(Player on : Bukkit.getOnlinePlayers())
                bar.addPlayer(on);
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
        getCommand("broadcast").setExecutor(new Broadcast());
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&ePlugin enabling!"));
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&ePlugin enabled, developed by Michele Pipicelli."));

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerChatHandler(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new TeleportBowEvent(this), this);

        Bukkit.setDefaultGameMode(GameMode.CREATIVE);
    }
    @Override
    public void onDisable() {
        bar.getBar().removeAll();
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&cPlugin disabling!"));
        System.out.println(ChatColor.translateAlternateColorCodes('&', "&cPlugin disabled!"));
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(!(bar.getBar().getPlayers().contains(event.getPlayer()))){
            bar.addPlayer(event.getPlayer());
        }
    }
}