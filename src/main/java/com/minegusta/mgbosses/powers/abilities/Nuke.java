package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.*;
import org.bukkit.entity.LivingEntity;

public class Nuke implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {

        for (int i = 0; i < 60; i++) {
            final int k = i;
            final Location target = damager.getLocation();
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {
                @Override
                public void run() {
                    nukeEffect(target, 110 + k, 30 * k, k / 4);
                }
            }, i);
        }
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "DESTRUCTION!!");


    }

    public static void nukeEffect(Location target, int range, int particles, int offSetY) {
        target.getWorld().createExplosion(target.getX(), target.getY() + 3 + offSetY, target.getZ(), 6F, false, false);
        target.getWorld().playSound(target, Sound.AMBIENCE_CAVE, 1F, 1F);
        target.getWorld().spigot().playEffect(target, Effect.CLOUD, 1, 1, 0F, 3F + offSetY, 3F, 1F, particles, range);
        target.getWorld().spigot().playEffect(target, Effect.LAVA_POP, 1, 1, 0F, 3F, 0F, 1F, particles, range);
        target.getWorld().spigot().playEffect(target, Effect.SMOKE, 1, 1, 0F, 3F + offSetY, 0F, 1F, particles, range);
        target.getWorld().spigot().playEffect(target, Effect.FLAME, 1, 1, 0F, 3F + offSetY, 0F + offSetY, 1F, particles, range);
    }
}