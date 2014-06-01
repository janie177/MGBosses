package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;

public class LargeSpiderHorde implements Ability {

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        int amount = 8;
        for(int i = 0; i < amount + 1; i ++)
        {
            Spider mob = (Spider) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.SPIDER);
            mob.setCustomName(ChatColor.DARK_GRAY + "Spider Hatchling");
            mob.setCustomNameVisible(true);
        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.FLAME, 0, 0, 3, 3, 3, 1, 15, 25);
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Feed on your pray! Leave none alive!");
    }
}