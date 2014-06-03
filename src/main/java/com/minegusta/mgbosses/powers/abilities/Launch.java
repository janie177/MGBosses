package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Launch implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) 
    {
        Vector v = p.getVelocity();
        v.setY(3.0);
        v.multiply(10);
        p.teleport(p.getLocation().add(0, 0.5, 0));
        p.setVelocity(v);
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Up, up, and away!");

    }
}
