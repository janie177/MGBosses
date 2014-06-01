package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;

public class LargeSkeletonHorde implements Ability {

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        int amount = 16;
        for(int i = 0; i < amount + 1; i ++)
        {
            Skeleton mob = (Skeleton) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.SKELETON);
            mob.setCustomName(ChatColor.GRAY + "Skeletal Minion");
            mob.setCustomNameVisible(true);

        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.SLIME, 0, 0, 3, 3, 3, 1, 15, 25);
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Soon you will be among those!");
    }
}