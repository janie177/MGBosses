package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

/**
 * Created by Jan on 1-6-2014.
 */
public class SmokeScreen implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {

        final Location target = entity.getLocation();
        final World world = p.getWorld();
        for (int i = 0; i < 21; i++) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(MausWasHere.PLUGIN, new Runnable() {

                        @Override
                        public void run() {
							world.spigot().playEffect(target, Effect.POTION_SWIRL, 0, 0, 9, 2, 9, 1, 30, 25);
							p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Shadow is on my side " + p.getDisplayName() + ChatColor.RESET + "...");
                        }

                    }, i);
    }
}
