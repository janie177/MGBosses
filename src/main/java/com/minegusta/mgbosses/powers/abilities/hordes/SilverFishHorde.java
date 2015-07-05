package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Silverfish;

public class SilverFishHorde implements Ability {

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        int amount = 8;
        for(int i = 0; i < amount + 1; i ++)
        {
            Silverfish mob = (Silverfish) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.SILVERFISH);
            mob.setCustomName(ChatColor.GRAY + "Crawler Minion");
            mob.setCustomNameVisible(true);
        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.POTION_BREAK, 0, 0, 3, 3, 3, 1, 15, 25);
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Can you feel the ground wiggle under your feet?");
    }
}