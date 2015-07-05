package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Villager;

public class Cage implements Ability {

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        int amount = 6;
        for(int i = 0; i < amount + 1; i ++)
        {
            Villager mob = (Villager) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.VILLAGER);
            mob.setCustomName(ChatColor.RED + "Nicolas Cage");
            mob.setCustomNameVisible(true);
        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.MOBSPAWNER_FLAMES, 0, 0, 3, 3, 3, 1, 15, 25);
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "NOO THE BEES!");
    }
}