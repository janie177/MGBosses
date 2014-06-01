package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;

public class LargeWolfHorde implements Ability {

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        int amount = 12;
        for(int i = 0; i < amount + 1; i ++)
        {
            Wolf mob = (Wolf) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.WOLF);
            mob.setCustomName(ChatColor.DARK_RED + "SnowHound Minion");
            mob.setCustomNameVisible(true);
            mob.setAngry(true);
            mob.setTarget(p);

        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.VILLAGER_THUNDERCLOUD, 0, 0, 3, 3, 3, 1, 15, 25);
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "The pack will devour you!");
    }
}