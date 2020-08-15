package com.smp.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class Commands implements CommandExecutor {

    private ArrayList<Player> list_Of_Flying_Players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("gmc")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.getGameMode() == GameMode.SURVIVAL || p.getGameMode() == GameMode.ADVENTURE || p.getGameMode() == GameMode.SPECTATOR) {
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
                if (p.getGameMode() == GameMode.SURVIVAL || p.getGameMode() == GameMode.ADVENTURE || p.getGameMode() == GameMode.SPECTATOR) {
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
        if (label.equalsIgnoreCase("heal")) {
            if (sender instanceof Player) {
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
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.GOLD + "You have been fed.");
                p.setFoodLevel(20);
            }
        }
        if (label.equalsIgnoreCase("clearchat")) {
            if (!(sender.hasPermission("core.clearchat"))) {
                sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Insufficient permissions!");
                return true;
            } else {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    for (int i = 0; i < 100; i++) {
                        Bukkit.broadcastMessage("");
                    }
                    p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.GOLD + " Chat cleared.");
                    return true;
                }
            }
        }
        if (label.equalsIgnoreCase("getpos")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " " + String.valueOf(p.getLocation().getBlockX()));
                p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " " + String.valueOf(p.getLocation().getBlockY()));
                p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " " + String.valueOf(p.getLocation().getBlockZ()));
            } else if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "ERROR: " + ChatColor.RESET + "" + ChatColor.LIGHT_PURPLE + "Only players may execute this command!");
            }
        }
        if (label.equalsIgnoreCase("nick")) {
            if (args.length == 0) { //Sender only typed '/hello' and nothing else
                sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "ERROR: " + ChatColor.RESET + ChatColor.LIGHT_PURPLE + "Incorrect arguments. Usage: /nick USERNAME");

            } else { //Sender typed more then 1 argument, so args[0] can't be null.
                if (args[0].equalsIgnoreCase(args[0])) { //Sender typed '/hello sir'
                    if (sender instanceof Player) {
                        Player p = (Player) sender;
                        p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Your nickname has been changed to " + ChatColor.BLUE + args[0].toUpperCase());
                        p.setDisplayName(args[0]);
                    }
                }
            }
        }
        if (label.equalsIgnoreCase("teleport")) {
            if (!(sender.hasPermission("core.teleport"))) {
                sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Insufficient permissions!");
                return true;
            } else {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Usage: /tp player or /tp player1 player2");
                    return true;
                } else {
                    if (args.length == 1) {
                        if (!(sender instanceof Player)) {
                            sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Players only!");
                            return true;
                        } else {
                            Player p = (Player) sender;
                            Player target = Bukkit.getPlayerExact(args[0]);
                            if (target == null) {
                                p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Target player is not online.");
                                return true;
                            } else {
                                p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " You have been teleported to " + ChatColor.GREEN + args[0]);
                                p.teleport(target);
                                return true;
                            }
                        }
                    } else {
                        Player p = (Player) sender;
                        Player target1 = Bukkit.getPlayerExact(args[0]);
                        Player target2 = Bukkit.getPlayerExact(args[1]);
                        if (target1 == null || target2 == null) {
                            p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " One or more players are not online.");
                            return true;
                        } else {
                            p.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " You have teleported " + ChatColor.GREEN + args[0] + ChatColor.LIGHT_PURPLE + " to " + ChatColor.YELLOW + args[1] + ".");
                            target1.teleport(target2);
                            return true;
                        }
                    }
                }
            }
        }
        if(label.equalsIgnoreCase("msg")){
            if(!(sender.hasPermission("core.msg"))){
                sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Insufficient permissions!");
                return true;
            } else {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Usage: /msg player message");
                } else {
                    if (args.length > 0) {
                        String joined = String.join(" ", args);
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if (target == null){
                            sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " The player is not online or does not exist.");
                            return true;
                        } else {
                            String name = sender.getName();
                            String targetName = target.getName();
                            joined.replace(targetName, "");
                            sender.sendMessage(ChatColor.YELLOW + "[" + ChatColor.RED + targetName + ChatColor.YELLOW + " -->" + ChatColor.RED + " " + name + ChatColor.YELLOW + "] " + joined);
                            target.sendMessage(ChatColor.YELLOW + "[" + ChatColor.RED + name + ChatColor.YELLOW + " -->" + ChatColor.RED + " " + targetName + ChatColor.YELLOW + "] " + joined);
                            return true;
                        }
                    }
                }
            }
        }
        if(label.equalsIgnoreCase("kill")){
            if(!(sender.hasPermission("core.kill"))){
                if(sender instanceof Player) {
                    Player p = (Player) sender;
                    p.sendTitle(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Insufficient permissions!", "");
                    return true;
                }
            } else {
                if (args.length == 0) {
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Players only!");
                        return true;
                    } else {
                        Player p = (Player) sender;
                        p.setHealth(0);
                        p.sendTitle(ChatColor.YELLOW + "Suicided", ChatColor.LIGHT_PURPLE + "Goodbye, cruel world.");
                        return true;
                    }
                } else {
                    Player p = (Player) sender;
                    String senderName = p.getName();
                    Player target = Bukkit.getPlayerExact(args[0]);
                    String name = target.getName();
                    sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " You have killed the great, " + ChatColor.RED + name.toUpperCase());
                    target.sendTitle(ChatColor.YELLOW + "You have been murdered by", ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + senderName);
                    target.setHealth(0);
                    return true;
                }
            }
        }
        if(label.equalsIgnoreCase("vault")){
            if(!(sender.hasPermission("core.vault"))){
                sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Insufficient permissions!");
                return true;
            }else {
                if(!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.YELLOW + ">>>" + ChatColor.LIGHT_PURPLE + " Players only!");
                    return true;
                } else {
                    Player p = (Player) sender;
                    String playerName = p.getName();
                    Inventory vault = Bukkit.createInventory(p, 9, playerName + "'s vault");
                    p.openInventory(vault);
                    return true;
                }
            }
        }
        return false;
    }
}

