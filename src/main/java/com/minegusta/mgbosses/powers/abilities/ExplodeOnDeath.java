package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

/**
 * Created by Jan on 1-6-2014.
 */
public class ExplodeOnDeath implements Ability
{

    @Override
    public void run(Player p, LivingEntity entity, double damage) 
    {
        
        if(entity.getHealth() == 0)
        {
            p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "IF I GO, SO WIL YOU!");
            
        final Location target = entity.getLocation();
        final World world = p.getWorld();
        for (int i = 0; i < 11; i++) {
            final int k = i;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(MausWasHere.PLUGIN, new Runnable() {

                        @Override
                        public void run() {
							p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + 10 - k);
                            if(k == 10)
                            {
                                world.createExplosion(location, Explosion.LARGE, false);
                            }
                        }

                    }, i);
        
        }
    }
}
