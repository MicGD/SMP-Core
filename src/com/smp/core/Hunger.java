package com.smp.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.*;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Hunger implements Listener {

    @EventHandler
    public void test(PlayerDeathEvent event) {
        Bukkit.broadcastMessage(ChatColor.RED + "Someone just died!");
    }

    @EventHandler
    public void onPlayerJoin(EntityDamageEvent event) throws InterruptedException {
        if(event.getCause() == DamageCause.FIRE_TICK) {

        }
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        String playerName = event.getPlayer().getName();
        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + ChatColor.RESET + "" + ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + playerName);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+ <3" + ChatColor.GRAY + "] " + ChatColor.RESET + "" + ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + playerName);
    }

    @EventHandler
    public void testevent(PlayerRespawnEvent event) {
        float exp = event.getPlayer().getExp();
        String playerName = event.getPlayer().getName();
        Bukkit.broadcastMessage(ChatColor.RED + playerName + ChatColor.RESET + " has just respawned and lost " + ChatColor.LIGHT_PURPLE + exp + " levels!");
    }

    @EventHandler
    public void OPCreeper(CreatureSpawnEvent event) {
        if (event.getEntityType() == EntityType.CREEPER) {
            Creeper creeper = (Creeper)event.getEntity();
            creeper.setPowered(true);
        }
        if (event.getEntityType() == EntityType.SKELETON) {
            Skeleton skeleton = (Skeleton)event.getEntity();
            ItemStack OPSword = new ItemStack(Material.NETHERITE_SWORD);
            OPSword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
            skeleton.getEquipment().setItemInMainHand(OPSword);
            skeleton.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999, 200));
        }
        if (event.getEntityType() == EntityType.SPIDER) {
            Spider spider = (Spider)event.getEntity();
            spider.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 99));
        }

    }

}
