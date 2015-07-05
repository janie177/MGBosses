package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Bleed implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        final LivingEntity le = damager;
        if(le instanceof  Player) le.sendMessage(ChatColor.RED + "You are bleeding!");
        for (int i = 0; i < 80; i++) {
            final int k = i;
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

                    @Override
                    public void run() {
                        if (k % 20 == 0)
                        {
                            le.damage(2.0);
                            le.getWorld().spigot().playEffect(le.getLocation(), Effect.CRIT, 0, 0, 1, 1, 1, 1, 15, 25);
                        }
                    }
            }, i);
        }
    }
}
