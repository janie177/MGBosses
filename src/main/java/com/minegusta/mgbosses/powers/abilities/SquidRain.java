package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class SquidRain implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        final Player player = p;
        final World world = p.getWorld();
        player.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "I'm even better than Aquaman!");

        for (int i = 0; i < 20 * 9; i++)

        {
            final int k = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

                @Override
                public void run() {

                    if(k % 5 == 0) world.spawnEntity(player.getLocation().add(0, 25, 0), EntityType.SQUID);

                }

            }, i);
        }
    }
}