package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Bleed implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        
        for (int i = 0; i < 80; i++) {
            final int k = i;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(MausWasHere.PLUGIN, new Runnable() {

                        @Override
                        public void run() {
                            if(k % 20 == 0)
                            {
        						p.sendMessage(ChatColor.RED + "You are bleeding!");
        						p.damage(2.0);
        						p.getWorld().spigot().playEffect(p.getLocation(), Effect.CRIT, 0, 0, 1, 1, 1, 1, 15, 25);
                            }
                    }, i);
    }
}
