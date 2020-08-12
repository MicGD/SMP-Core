package com.dream.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.*;

public class Hunger implements Listener{

    @EventHandler
    public void onPlayerJoin(EntityDamageEvent event) throws InterruptedException {
        if(event.getCause() == DamageCause.FALL) {
            Bukkit.broadcastMessage("SOME DUMB FUCK JUST FELL LOLOLOLOLOL " + ChatColor.RED + "FUCKING TRASH");
            double d = event.getDamage();
            Math.round(d);
            Bukkit.broadcastMessage("THAT GUY TOOK " + d + " POINTS OF FALL DAMAGE");
        }
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

}
