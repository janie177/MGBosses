package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class Choke implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {

        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Force Choke!");
        for(int i = 0; i < 20; i++)
        {
            p.setRemainingAir(0);
        }
    }
}