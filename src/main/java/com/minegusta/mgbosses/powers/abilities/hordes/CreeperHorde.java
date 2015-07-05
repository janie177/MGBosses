package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class CreeperHorde implements Ability {

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        int amount = 5;
        for(int i = 0; i < amount + 1; i ++)
        {
            Creeper mob = (Creeper) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.CREEPER);
            mob.setCustomName(ChatColor.GREEN + "Walking Green TNT Stick");
            mob.setCustomNameVisible(true);
        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.PARTICLE_SMOKE, 0, 0, 3, 3, 3, 1, 15, 25);
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "This will blow your mind!");
    }
}