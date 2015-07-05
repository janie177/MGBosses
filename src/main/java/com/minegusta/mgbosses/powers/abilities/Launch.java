package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class Launch implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage)
    {
        Vector v = damager.getVelocity();
        v.setY(2.8);
        damager.teleport(damager.getLocation().add(0, 0.5, 0));
        damager.setVelocity(v);
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Up, up, and away!");

    }
}
