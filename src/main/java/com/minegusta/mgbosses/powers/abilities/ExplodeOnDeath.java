package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class ExplodeOnDeath implements Ability
{

    @Override
    public void run(Player player, LivingEntity entity, double damage)
    {
        
        if(entity.getHealth() == 0)
        {
            player.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "IF I GO, SO WIL YOU!");
            
        final Location l = entity.getLocation();
        final World world = player.getWorld();
        final Player p = player;
        final LivingEntity le = entity;

        for (int i = 0; i < 11; i++) {
            final int k = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

                @Override
                public void run() {
                    p.sendMessage(ChatColor.RED + "[" + le.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + (10 - k));
                    if (k == 10) {
                        world.createExplosion(l.getX(), l.getY(), l.getZ(), 2.5F, false, false);
                    }
                }

            }, i);
            }
        
        }
    }
}
