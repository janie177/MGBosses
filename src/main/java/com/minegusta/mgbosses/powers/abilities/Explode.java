package com.minegusta.mgbosses.powers.abilities;


import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Explode implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) 
    {
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "BOOM!");

        //TODO Not sure if this will work
        p.getWorld().createExplosion(p.getLocation(), Explosion.NORMAL, false);

    }
}
