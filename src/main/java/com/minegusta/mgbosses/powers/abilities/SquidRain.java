package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class SquidRain implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        
        final Location target = p.getLocation();
        location.add(0,20,0);
        final World world = p.getWorld();
        for (int i = 0; i < 21; i++) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(MausWasHere.PLUGIN, new Runnable() {

                        @Override
                        public void run() {
							world.spawnEntity(location, EntityType.SQUID);
							p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "I'm even better than Aquaman!");
                        }

                    }, i);

    }
}
