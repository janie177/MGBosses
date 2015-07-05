package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class SquidRain implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        final LivingEntity le = damager;
        final World world = damager.getWorld();
        le.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "I'm even better than Aquaman!");

        for (int i = 0; i < 20 * 9; i++)

        {
            final int k = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

                @Override
                public void run() {

                    if(k % 5 == 0) world.spawnEntity(le.getLocation().add(0, 25, 0), EntityType.SQUID);

                }

            }, i);
        }
    }
}