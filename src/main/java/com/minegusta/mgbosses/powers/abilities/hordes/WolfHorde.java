package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Wolf;

public class WolfHorde implements Ability {

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        int amount = 6;
        for(int i = 0; i < amount + 1; i ++)
        {
            Wolf mob = (Wolf) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.WOLF);
            mob.setCustomName(ChatColor.DARK_RED + "SnowHound Minion");
            mob.setCustomNameVisible(true);
            mob.setAngry(true);
            mob.setTarget(damager);

        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.VILLAGER_THUNDERCLOUD, 0, 0, 3, 3, 3, 1, 15, 25);
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "The pack will devour you!");
    }
}