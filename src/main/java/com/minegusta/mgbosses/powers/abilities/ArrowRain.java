package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class ArrowRain implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
 final Player player = p;
        final World world = p.getWorld();
        for (int i = 0; i < 21; i++) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(MausWasHere.PLUGIN, new Runnable() {

                        @Override
                        public void run() {
							world.spawnEntity(p.getLocation().add(0,12,0), EntityType.ARROW);
							
							p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "That's right! Keep running!!");
                        }

                    }, i);

    }
}
