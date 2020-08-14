package com.smp.core.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    @EventHandler
    public void PlayerMove(PlayerMoveEvent e) {
        if(!(e.getPlayer().hasPermission("core.move"))){
            e.setCancelled(true);
        }
    }
}
