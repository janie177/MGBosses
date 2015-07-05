package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.*;
import org.bukkit.entity.LivingEntity;

public class SmokeScreen implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity ent, double damage) {

        damager.sendMessage(ChatColor.RED + "[" + ent.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Shadow is on my side " + damager.getName() + ChatColor.RESET + "...");

        final LivingEntity p = damager;
        final LivingEntity entity = ent;
        final Location target = entity.getLocation();
        final World world = p.getWorld();
        for (int i = 0; i < 20 * 12; i++) {
            final int k = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

                @Override
                public void run() {
                    if(k % 5 == 0)world.spigot().playEffect(target, Effect.PARTICLE_SMOKE, 0, 0, 9, 2, 9, 1/20, 250, 25);
                }

            }, i);
        }

    }
}
