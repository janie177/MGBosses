package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Witch;


public class WitchHorde implements Ability {

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        int amount = 4;
        for(int i = 0; i < amount + 1; i ++)
        {
            Witch mob = (Witch) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.WITCH);
            mob.setCustomName(ChatColor.DARK_AQUA + "Magician Minion");
            mob.setCustomNameVisible(true);
        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.FLAME, 0, 0, 3, 3, 3, 1, 15, 25);
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Lets see how you will handle alchemy!");
    }
}