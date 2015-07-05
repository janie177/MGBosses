package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;

public class Choke implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {

        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Force Choke!");
        for(int i = 0; i < 20; i++)
        {
            damager.setRemainingAir(0);
        }
    }
}