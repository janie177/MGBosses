package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;

public class LargeWitherSkeletonHorde implements Ability {

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {
        int amount = 10;
        for(int i = 0; i < amount + 1; i ++)
        {
            Skeleton mob = (Skeleton) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.SKELETON);
            mob.setCustomName(ChatColor.GRAY + "Wither Warrior");
            mob.setCustomNameVisible(true);
            mob.setSkeletonType(Skeleton.SkeletonType.WITHER);

        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.WITCH_MAGIC, 0, 0, 3, 3, 3, 1, 15, 25);
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "WITHER AWAY!");
    }
}