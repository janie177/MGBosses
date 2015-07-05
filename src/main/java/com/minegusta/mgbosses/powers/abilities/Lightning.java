package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;

public class Lightning implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {

        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Zap! Zap!");
        damager.getWorld().strikeLightning(damager.getLocation());

    }
}