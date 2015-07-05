package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class FireBall implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {

        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Pew!");
        shootFireball(entity.getLocation(), damager.getLocation(), entity);

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