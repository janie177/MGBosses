package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;

public class ExplodeOnDeath
{
    public void run(LivingEntity entity)
    {
        
        if(entity.isDead())
        {

        final Location l = entity.getLocation();
        final World world = entity.getWorld();
        final LivingEntity le = entity;

            for (int i = 0; i < 20 * 11; i++) {
                final int k = i;
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

                    @Override
                    public void run() {
                        if(k % 20 == 0)
                        {
                            le.getWorld().getPlayers().stream().filter(p -> p.getLocation().distance(le.getLocation()) < 21).forEach(pler ->
                            {
                                if(k == 0)
                                {
                                    pler.sendMessage(ChatColor.RED + "[" + le.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "IF I GO, SO WILL YOU!");
                                }
                                else
                                {
                                    pler.sendMessage(ChatColor.RED + "[" + le.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + ((200 - k) / 20));
                                }
                            });
                        }
                        if (k == 200) {
                            world.createExplosion(l.getX(), l.getY(), l.getZ(), 3.0F, false, false);
                        }
                    }
                }, i);
            }
        
        }
    }
}
