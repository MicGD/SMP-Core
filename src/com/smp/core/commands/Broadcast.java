package com.smp.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Broadcast implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender.hasPermission("core.broadcast"))){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e>>> &dInsufficient Permissions!"));
            return true;
        } else {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e>>> &dUsage: /broadcast message"));
                return true;
            } else {
                String joined = String.join(" ", args);
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7[&cAlert&7] " + "&r" + joined));
                return true;
            }
        }
    }
}
