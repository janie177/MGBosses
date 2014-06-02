package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Lightning implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {

        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Zap! Zap!");
        p.getWorld().strikeLightning(p.getLocation());

    }
}