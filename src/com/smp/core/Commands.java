package com.smp.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("gmc")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.getGameMode() == GameMode.SURVIVAL || p.getGameMode() == GameMode.ADVENTURE || p.getGameMode() == GameMode.SPECTATOR){
                    p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.GREEN + " Your game mode has been updated to " + ChatColor.BLUE + "" + ChatColor.BOLD + "CREATIVE!");
                    p.setGameMode(GameMode.CREATIVE);
                } else {
                    p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "ERROR:" + ChatColor.RESET + "" + ChatColor.GREEN + " You must be in survival mode to execute this command!");
                }
            }
        }
        if (label.equalsIgnoreCase("gm")) { // command executor /gm
            if (sender instanceof Player) {
                Player p = (Player) sender; // creates player entity
                if (p.getGameMode() == GameMode.SURVIVAL || p.getGameMode() == GameMode.ADVENTURE || p.getGameMode() == GameMode.SPECTATOR){
                    p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.GREEN + " Your game mode has been updated to " + ChatColor.BLUE + "" + ChatColor.BOLD + "CREATIVE!");
                    p.setGameMode(GameMode.CREATIVE);
                    return true;
                } else {
                    p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.GREEN + " Your game mode has been updated to " + ChatColor.RED + "" + ChatColor.BOLD + "SURVIVAL!");
                    p.setGameMode(GameMode.SURVIVAL);
                    return true;
                }
            }

        }
        if (label.equalsIgnoreCase("fly")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.getAllowFlight() == true) {
                    p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Flight mode " + ChatColor.RED + "disabled " + ChatColor.LIGHT_PURPLE + "for " + p.getName());
                    p.setAllowFlight(false);
                } else {
                    p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Flight mode " + ChatColor.GREEN + "enabled " + ChatColor.LIGHT_PURPLE + "for " + p.getName());
                    p.setAllowFlight(true);
                }
            }
        }
        if (label.equalsIgnoreCase("heal")) {
            if(sender instanceof Player) {
                if (args.length == 0) {
                    Player p = (Player) sender;
                    p.sendMessage(ChatColor.GOLD + "You have been healed.");
                    p.setFoodLevel(20);
                    p.setHealth(20);
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target == null) {
                        sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Target player (" + args[0] + ") does not exist or is not online.");
                    } else {
                        sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " You have healed " + ChatColor.GREEN + args[0].toUpperCase());
                        target.setHealth(20);
                        target.setFoodLevel(20);
                    }
                }
            }
        }
        if (label.equalsIgnoreCase("feed")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.GOLD + "You have been fed.");
                p.setFoodLevel(20);
            }
        }
        if(label.equalsIgnoreCase("clearchat")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                for (int i = 0; i < 100; i++) {
                    Bukkit.broadcastMessage("");
                }
                p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.GOLD + " Chat cleared.");
            }
        }
        if(label.equalsIgnoreCase("getpos")){
            if(sender instanceof Player){
                Player p = (Player) sender;
                p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " " + String.valueOf(p.getLocation().getBlockX()));
                p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " " + String.valueOf(p.getLocation().getBlockY()));
                p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " " + String.valueOf(p.getLocation().getBlockZ()));
            } else if(!(sender instanceof Player)){
                sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "ERROR: " + ChatColor.RESET + "" + ChatColor.LIGHT_PURPLE + "Only players may execute this command!");
            }
        }
        if (label.equalsIgnoreCase("nick")) {
            if (args.length == 0) { //Sender only typed '/hello' and nothing else
                sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "ERROR: " + ChatColor.RESET + ChatColor.LIGHT_PURPLE + "Incorrect arguments. Usage: /nick USERNAME" );

            } else { //Sender typed more then 1 argument, so args[0] can't be null.
                if (args[0].equalsIgnoreCase(args[0])) { //Sender typed '/hello sir'
                    if(sender instanceof Player) {
                        Player p = (Player) sender;
                        p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Your nickname has been changed to " + ChatColor.BLUE + args[0].toUpperCase());
                        p.setDisplayName(args[0]);
                    }
                }
            }
            }
        return false;
    }
}
