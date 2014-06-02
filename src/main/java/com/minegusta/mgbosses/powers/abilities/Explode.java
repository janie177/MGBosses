package com.minegusta.mgbosses.powers.abilities;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Explode implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) 
    {
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "BOOM!");
        Location l = p.getLocation();
        p.getWorld().createExplosion(l.getX(), l.getY(), l.getZ(), 2.5F, false, false);

    }
}
