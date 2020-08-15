package com.smp.core.teleportbow.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import com.smp.core.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TeleportBow implements CommandExecutor {

    Main plugin;

    public TeleportBow(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("core.tpbow")){
                ItemStack tpBow = new ItemStack(Material.BOW);
                tpBow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
                ItemMeta meta = tpBow.getItemMeta();
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-name")));
                meta.setUnbreakable(true);
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-description")));
                meta.setLore(lore);
                tpBow.setItemMeta(meta);

                p.getInventory().addItem(tpBow);
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e>>> &dPlayers only!"));
        }

        return true;
    }
}
