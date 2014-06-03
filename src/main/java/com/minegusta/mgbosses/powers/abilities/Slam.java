package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class Slam implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        entity.teleport(p.getLocation().add(0, 0.5, 0));
        entity.setVelocity(new Vector(0, 20, 0));


        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "BODYSLAM!");

        final Location l = entity.getLocation();
        final World world = p.getWorld();
        final Player player = p;
        final LivingEntity le = entity;


        for (int i = 0; i < 20 * 3; i++) {
            final int k = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

                @Override
                public void run() {
                    if(k == 59)
                    {
                        world.createExplosion(l.getX(), l.getY(), l.getZ(), 3.0F, false, false);
                        for(Entity nearby : le.getNearbyEntities(6,6,6))
                        {
                            if(nearby instanceof Player)
                            {
                                Player nearbyPlayer = (Player) nearby;
                                nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 5, 0));
                            }
                        }
                    }
                }
            }, i);
        }
    }
}