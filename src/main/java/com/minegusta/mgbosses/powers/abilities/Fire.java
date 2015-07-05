package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;

public class Fire implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Burn!");
        damager.setFireTicks(20 * 6);
        
    }
}
