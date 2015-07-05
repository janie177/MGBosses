package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class LargeCaveSpiderHorde implements Ability {

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        int amount = 16;
        for(int i = 0; i < amount + 1; i ++)
        {
            CaveSpider mob = (CaveSpider) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.CAVE_SPIDER);
            mob.setCustomName(ChatColor.DARK_RED + "Poisonous Spider");
            mob.setCustomNameVisible(true);
        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.PARTICLE_SMOKE, 0, 0, 3, 3, 3, 1, 15, 25);
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Feed my children!");
    }
}