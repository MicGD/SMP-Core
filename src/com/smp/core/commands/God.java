package com.smp.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class God implements CommandExecutor {

    private ArrayList<Player> list_of_God_players = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&ePlayers only!"));
        } else {
            Player p = (Player) sender;
            if(!(p.hasPermission("core.god"))){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e>>> &dInsufficient Permissions!"));
                return true;
            } else {
                if(args.length == 0){
                    if(list_of_God_players.contains(p)){
                        p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&cYou are no longer god!"), "");
                        p.setInvulnerable(false);
                        list_of_God_players.remove(p);
                        return true;
                    } else if (!(list_of_God_players.contains(p))){
                        p.setInvulnerable(true);
                        p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&aYou are now god!"), "");
                        p.playSound(p.getLocation(), Sound.ENTITY_CAT_PURR, 5, 5);
                        list_of_God_players.add(p);
                        return true;
                    }
                } else {
                    Player target = Bukkit.getPlayer(args[0]);
                    String targetName = target.getName();
                    if(target == null){
                        p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&cTarget player (" + ChatColor.GREEN + targetName + ") &c is not online!"), "");
                        return true;
                    } else {
                        if(list_of_God_players.contains(target)){
                            p.setInvulnerable(false);
                            p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&cTarget player (" + ChatColor.YELLOW + targetName + ")&c is no longer god!"), "");
                            target.sendTitle(ChatColor.translateAlternateColorCodes('&', "&cYou are no longer god!"), "");
                            list_of_God_players.remove(target);
                            return true;
                        } else {
                            p.setInvulnerable(true);
                            p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&aTarget player (" + ChatColor.YELLOW + targetName + ")&a is now god!"), "");
                            target.sendTitle(ChatColor.translateAlternateColorCodes('&', "&aYou are now god!"), "");
                            list_of_God_players.add(target);
                            return true;
                        }
                    }
                }
            }
        }





        return false;
    }
}
