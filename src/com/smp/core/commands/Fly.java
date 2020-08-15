package com.smp.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Fly implements CommandExecutor {

    private ArrayList<Player> list_Of_Flying_Players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("fly")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if(p.hasPermission("core.fly")){
                    if(args.length == 0) {
                        if (list_Of_Flying_Players.contains(p)) {
                            list_Of_Flying_Players.remove(p);
                            p.sendTitle(ChatColor.YELLOW + " Flight mode " + ChatColor.RED + "disabled " + ChatColor.LIGHT_PURPLE + "for " + p.getName(), "");
                            p.setAllowFlight(false);
                            return true;
                        } else if (!(list_Of_Flying_Players.contains(p))){
                            list_Of_Flying_Players.add(p);
                            p.sendTitle(ChatColor.YELLOW + " Flight mode " + ChatColor.GREEN + "enabled " + ChatColor.LIGHT_PURPLE + "for " + p.getName(), "");
                            p.setAllowFlight(true);
                            return true;
                        }
                    } else if (args.length == 1){
                        if(!(sender.hasPermission("core.fly.others"))){
                            p.sendTitle(ChatColor.YELLOW + "You do not have permission", ChatColor.YELLOW + "to make others fly.");
                            return true;
                        }
                        Player target = Bukkit.getPlayer(args[0]);
                        if(target == null){
                            p.sendTitle(ChatColor.YELLOW + "Target player is offline!", "");
                            return true;
                        } else {
                            String targetName = target.getName();
                            if(list_Of_Flying_Players.contains(target)){
                                target.setAllowFlight(false);
                                p.sendTitle(ChatColor.YELLOW + " Flight mode " + ChatColor.RED + "disabled " + ChatColor.LIGHT_PURPLE + "for " + targetName, "");
                                list_Of_Flying_Players.remove(target);
                                p.playSound(p.getLocation(), Sound.ENTITY_CAT_DEATH, 10, 20);
                                return true;
                            } else if (!(list_Of_Flying_Players.contains(target))) {
                                target.setAllowFlight(true);
                                p.sendTitle(ChatColor.YELLOW + " Flight mode " + ChatColor.GREEN + "enabled " + ChatColor.LIGHT_PURPLE + "for " + targetName, "");
                                list_Of_Flying_Players.add(target);
                                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                                return true;
                            }
                        }
                    }
                } else {
                    p.sendTitle(ChatColor.YELLOW + " Insufficient permissions!", "");
                }
            }
        }
        return false;
    }
}




/*

 */