package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class ArrowRain implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage)
    {
    final Player player = p;
    final World world = p.getWorld();
    final LivingEntity le = entity;
    for (int i = 0; i < 21; i++)

    {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

            @Override
            public void run() {
                world.spawnEntity(player.getLocation().add(0, 12, 0), EntityType.ARROW);

                player.sendMessage(ChatColor.RED + "[" + le.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "That's right! Keep running!!");
            }

        }, i);
        }
    }
}

