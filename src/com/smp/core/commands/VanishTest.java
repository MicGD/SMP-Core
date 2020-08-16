package com.smp.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class VanishTest implements CommandExecutor {
    private ArrayList<Player> list_of_Vanished_Players = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("core.vanish")) {
                if (!(list_of_Vanished_Players.contains(p))) {
                    p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&eYou are now vanished!"), "");
                    for (int i = 0; i < 20; i++) {
                        p.getWorld().spawnEntity(p.getLocation(), EntityType.LIGHTNING);
                        p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
                    }
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        if (!p.equals(players)) {
                            players.hidePlayer(p);
                            list_of_Vanished_Players.add(p);
                        } else if (list_of_Vanished_Players.contains(p)) {
                            for (int i = 0; i < 20; i++) {
                                p.getWorld().spawnEntity(p.getLocation(), EntityType.LIGHTNING);
                                p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
                            }
                            if (!p.equals(players)) {
                                players.showPlayer(p);
                                p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&eYou are no longer vanished!"), "");
                                list_of_Vanished_Players.remove(p);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}