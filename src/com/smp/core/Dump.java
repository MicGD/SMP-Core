package com.smp.core;

public class Dump {
    /*
        @EventHandler
    public void OPCreeper(CreatureSpawnEvent event) {
        if (disable == true) {
            event.setCancelled(true);
        } else if (disable == false) {
            event.setCancelled(false);
        }
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
        if (event.getEntityType() == EntityType.ZOMBIE) {
            Zombie zombie = (Zombie)event.getEntity();
            ItemStack OPSword = new ItemStack(Material.NETHERITE_SWORD);
            OPSword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
            zombie.getEquipment().setItemInMainHand(OPSword);
        }

    }




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("emobs")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                Bukkit.broadcastMessage("This message proves this command is working.");
                disable = false;
                p.sendMessage(ChatColor.YELLOW + "E-MOBS enabled.");
                return true;
            }
        }
        if(label.equalsIgnoreCase("dmobs")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                Bukkit.broadcastMessage("This message proves this command is working.");
                disable = true;
                p.sendMessage(ChatColor.YELLOW + "E-Mobs disabled.");
                return true;
            }
        }
        return false;
    }
     */
}
