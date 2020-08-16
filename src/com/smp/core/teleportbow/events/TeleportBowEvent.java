package com.smp.core.teleportbow.events;

import com.smp.core.Main;
import com.smp.core.teleportbow.commands.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.ArrayList;

public class TeleportBowEvent implements Listener {

    Main plugin;

    public TeleportBowEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onArrowLand(ProjectileHitEvent event) {
        Player p = (Player)event.getEntity().getShooter();
        ArrayList<String> tpbowlore = new ArrayList<>();
        if(event.getEntity() instanceof Arrow) {
            Location loc = event.getEntity().getLocation();

            p.teleport(loc);
            p.playSound(p.getLocation(), Sound.ENTITY_ENDER_EYE_LAUNCH, 50, 5);
            p.sendTitle(ChatColor.LIGHT_PURPLE + plugin.getConfig().getString("teleport-description"), "");
        }
    }
}
