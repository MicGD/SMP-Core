package com.smp.core;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.*;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;

public class Hunger implements Listener{

    @EventHandler
    public void test(PlayerDeathEvent event) {
        Bukkit.broadcastMessage(ChatColor.RED + "Someone just died!");
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        String playerName = event.getPlayer().getName();
        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + ChatColor.RESET + "" + ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + playerName);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.RESET + "" + ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + playerName);
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        float exp = event.getPlayer().getExp();
        String playerName = event.getPlayer().getName();
        Bukkit.broadcastMessage(ChatColor.RED + playerName + ChatColor.RESET + " has just respawned!");
    }

}
