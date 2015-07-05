package com.minegusta.mgbosses.powers.abilities;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

public class Explode implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage)
    {
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "BOOM!");
        Location l = damager.getLocation();
        damager.getWorld().createExplosion(l.getX(), l.getY(), l.getZ(), 2.5F, false, false);

    }
}
