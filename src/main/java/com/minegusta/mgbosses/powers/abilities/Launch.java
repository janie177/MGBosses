package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Launch implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) 
    {
        Vector v = p.getVelocity();
        v.setY(3.0);
        v.multiply(1.9);
        p.setVelocity(v);
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Up, up, and away!");

    }
}
