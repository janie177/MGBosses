package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class SmokeScreen implements Ability{

    @Override
    public void run(Player player, LivingEntity ent, double damage) {

        final Player p = player;
        final LivingEntity entity = ent;
        final Location target = entity.getLocation();
        final World world = p.getWorld();
        for (int i = 0; i < 21; i++) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

                @Override
                public void run() {
                    world.spigot().playEffect(target, Effect.POTION_SWIRL, 0, 0, 9, 2, 9, 1, 30, 25);
                    p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Shadow is on my side " + p.getDisplayName() + ChatColor.RESET + "...");
                }

            }, i);
        }

    }
}
