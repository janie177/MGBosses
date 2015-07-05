package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import com.minegusta.mgbosses.util.TempData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class Slam implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        entity.teleport(entity.getLocation().add(0, 0.5, 0));
        entity.setVelocity(new Vector(0, 3.1, 0));
        entity.setFallDistance(0);
        TempData.god.put(entity.getUniqueId(), true);

        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "BODYSLAM!");

        final Location l = entity.getLocation();
        final World world = damager.getWorld();
        final LivingEntity le = entity;


        for (int i = 0; i < 20 * 3; i++) {
            final int k = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, ()-> {

                    if(k == 59)
                    {
                        TempData.god.put(le.getUniqueId(), true);
                        world.createExplosion(l.getX(), l.getY(), l.getZ(), 3.0F, false, false);

                        le.getWorld().getPlayers().stream().filter(pl -> pl.getLocation().distance(le.getLocation()) < 7).forEach(pl -> pl.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 5, 0)));
                    }

            }, i);
        }
    }
}