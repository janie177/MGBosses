package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class BatShield implements Ability {

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        for(int i = 0; i < 16; i++)
        {
            Bat bat = (Bat) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.BAT);
            bat.setCustomName("BatManBat");
            bat.setCustomNameVisible(true);

        }
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Shield me, my babies!");

    }
}