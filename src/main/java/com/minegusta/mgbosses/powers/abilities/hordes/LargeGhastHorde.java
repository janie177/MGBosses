package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class LargeGhastHorde implements Ability {

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        int amount = 8;
        for(int i = 0; i < amount + 1; i ++)
        {
            Ghast mob = (Ghast) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.GHAST);
            mob.setCustomName(ChatColor.RED + "Ghast Minion");
            mob.setCustomNameVisible(true);
        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.MOBSPAWNER_FLAMES, 0, 0, 3, 3, 3, 1, 15, 25);
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "DEATH FROM ABOVE!");
    }
}