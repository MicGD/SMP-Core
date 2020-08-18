package com.smp.core.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerChatHandler implements Listener {

    @EventHandler
    public void onPlayerChat(PlayerChatEvent e) {
        e.setCancelled(true);
        String message = e.getMessage();
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8" + e.getPlayer().getDisplayName() + ": &r" + message));
    }
}
