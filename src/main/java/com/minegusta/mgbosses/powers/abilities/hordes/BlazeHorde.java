package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class BlazeHorde implements Ability {

    @Override
    public void run(Player p, LivingEntity entity, double damage) {

        int amount = 6;
        for(int i = 0; i < amount + 1; i ++)
        {
            Blaze mob = (Blaze) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.BLAZE);
            mob.setCustomName(ChatColor.DARK_RED + "Blaze Minion");
            mob.setCustomNameVisible(true);
        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.VILLAGER_THUNDERCLOUD, 0, 0, 3, 3, 3, 1, 15, 25);
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Lets see if you can beat my minions!");
    }
}