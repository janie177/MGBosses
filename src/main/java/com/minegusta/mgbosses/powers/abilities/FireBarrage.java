package com.minegusta.mgbosses.powers.abilities;

import com.minegusta.mgbosses.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class FireBarrage implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {

        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Pew! Pew Pew Pew!");

        final LivingEntity ent = entity;
        final Location pl = damager.getLocation();
        final Location el = ent.getLocation();
        for (int i = 0; i < 20 * 3; i++)

        {
            final Location l = damager.getLocation();
            final int k = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {

                @Override
                public void run() {
                    if (k % 4 == 0) shootFireball(el, pl, ent);
                }

            }, i);
        }
    }

    //Thanks to DemiGods for this method!

    public static void shootFireball(Location from, Location to, LivingEntity shooter)
    {
        org.bukkit.entity.Fireball fireball = (org.bukkit.entity.Fireball) shooter.getWorld().spawnEntity(from, EntityType.FIREBALL);
        to.setX(to.getX() + .5);
        to.setY(to.getY() + .5);
        to.setZ(to.getZ() + .5);
        Vector path = to.toVector().subtract(from.toVector());
        Vector victor = from.toVector().add(from.getDirection().multiply(2));
        fireball.teleport(new Location(shooter.getWorld(), victor.getX(), victor.getY(), victor.getZ()));
        fireball.setDirection(path);
        fireball.setShooter(shooter);
    }
}