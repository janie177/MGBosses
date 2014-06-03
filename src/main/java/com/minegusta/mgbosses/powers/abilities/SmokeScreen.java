package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class SmokeScreen implements Ability{

    @Override
    public void run(Player player, LivingEntity ent, double damage) {

        player.sendMessage(ChatColor.RED + "[" + ent.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Shadow is on my side " + p.getDisplayName() + ChatColor.RESET + "...");

        final Player p = player;
        final LivingEntity entity = ent;
        final Location target = entity.getLocation();
        final World world = p.getWorld();
        for (int i = 0; i < 20 * 12; i++) {
            final int k = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

                @Override
                public void run() {
                    if(k % 5 == 0)world.spigot().playEffect(target, Effect.POTION_SWIRL, 0, 0, 9, 2, 9, 1, 30, 25);
                }

            }, i);
        }

    }
}
