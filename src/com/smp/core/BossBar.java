package com.smp.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Player;

public class BossBar {

    private int taskID = -1;
    private final Main plugin;
    private org.bukkit.boss.BossBar bar;

    public BossBar(Main plugin) {
        this.plugin = plugin;

    }

    public void addPlayer(Player player) {
        bar.addPlayer(player);
    }

    public org.bukkit.boss.BossBar getBar() {
        return bar;
    }

    public void createBar() {
        String title = format("&eWelcome to the Plugin Test Server");
        BarColor color = BarColor.BLUE;
        BarStyle style = BarStyle.SOLID;
        bar = Bukkit.createBossBar(title, color, style);
        bar.setVisible(true);
        cast();
    }

    public void cast() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            int count = -1;
            double progress = 1.0;
            double time = 1.0/5;

            @Override
            public void run() {
                bar.setProgress(progress);

                switch (count) {
                    case -1:
                        break;
                    case 0:
                        bar.setColor(BarColor.GREEN);
                        bar.setTitle(format("&eCreated by Michele Pipicelli"));
                        break;
                    default:
                        bar.setColor(BarColor.BLUE);
                        bar.setTitle(format("&eWelcome to the Plugin Test Server"));
                        count = -1;
                        break;
                }

                progress = progress - time;
                if (progress <= 0) {
                    count++;
                    progress = 1.0;
                }

            }

        }, 0, 20);
    }
    private String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
