package com.smp.core.events;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffect.*;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffectType.*;

public class CreatureSpawn implements Listener {

    @EventHandler
    public void creatureSpawn(CreatureSpawnEvent e) {
        if(e.getEntityType() == EntityType.CREEPER) {
            Creeper creeper = (Creeper)e.getEntity();
            creeper.setPowered(true);
        }
        if(e.getEntityType() == EntityType.ZOMBIE) {
            Zombie zombie = (Zombie)e.getEntity();
            ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
            zombie.getEquipment().setItemInMainHand(sword);
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999, 20));
        }
        if(e.getEntityType() == EntityType.SKELETON) {
            Skeleton opbow = (Skeleton)e.getEntity();
            ItemStack bow = new ItemStack(Material.BOW);
            bow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
            opbow.getEquipment().setItemInMainHand(bow);
        }
        if(e.getEntityType() == EntityType.SPIDER) {
            Spider spider = (Spider)e.getEntity();
            spider.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999, 20));
        }
        if(e.getEntityType() == EntityType.SHEEP){
            Sheep sheep = (Sheep)e.getEntity();
            sheep.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 30));
        }
    }
}
