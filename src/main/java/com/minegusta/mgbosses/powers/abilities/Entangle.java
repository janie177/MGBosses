package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Entangle implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {

        final Player player = p;
        final Location l = p.getLocation();


        player.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Not so fast now!");
        player.sendMessage(ChatColor.RED + "You have been entangled!");



        for (int i = 0; i < 20 * 6; i++)
        {
            final int k = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

                @Override
                public void run() {
                    if(k % 5 == 0)
                    {
                        player.teleport(l);
                    }
                }

            }, i);
        }

    }
}