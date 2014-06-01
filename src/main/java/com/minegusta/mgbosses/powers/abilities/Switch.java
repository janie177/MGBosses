package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Switch implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Plot twist!");
        final Location ploc = p.getLocation();
        final Location eloc = entity.getLocation();

        entity.teleport(ploc);
        p.teleport(eloc);
    }
}