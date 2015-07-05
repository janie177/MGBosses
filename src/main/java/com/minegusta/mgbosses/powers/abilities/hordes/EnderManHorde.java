package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class EnderManHorde implements Ability {

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        int amount = 8;
        for(int i = 0; i < amount + 1; i ++)
        {
            Enderman mob = (Enderman) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.ENDERMAN);
            mob.setCustomName(ChatColor.DARK_PURPLE + "Ender Minion");
            mob.setCustomNameVisible(true);
        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.ENDER_SIGNAL, 0, 0, 3, 3, 3, 1, 15, 25);
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "This is your END!");
    }
}