package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

public class SwitchLocation implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Plot twist!");
        final Location ploc = damager.getLocation();
        final Location eloc = entity.getLocation();

        entity.teleport(ploc);
        damager.teleport(eloc);
    }
}