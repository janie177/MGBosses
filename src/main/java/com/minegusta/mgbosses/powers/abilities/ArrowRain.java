package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class ArrowRain implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage)
    {

        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "That's right! Keep running!!");

    final World world = damager.getWorld();
    final LivingEntity le = damager;
    for (int i = 0; i < 20 * 8; i++)
    {
        final int k = i;
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

            @Override
            public void run() {
               if(k % 5 == 0) world.spawnEntity(le.getLocation().add(0, 12, 0), EntityType.ARROW);

            }

        }, i);
        }
    }
}

