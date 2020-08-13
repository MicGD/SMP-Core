package com.smp.core;

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
        if (label.equalsIgnoreCase("gm")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
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
        return false;
    }
}
