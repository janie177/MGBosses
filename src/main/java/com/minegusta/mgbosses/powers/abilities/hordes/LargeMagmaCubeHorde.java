package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;

public class LargeMagmaCubeHorde implements Ability {

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        int amount = 7;
        for(int i = 0; i < amount + 1; i ++)
        {
            MagmaCube mob = (MagmaCube) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.MAGMA_CUBE);
            mob.setCustomName(ChatColor.RED + "MagmaCube Minion");
            mob.setCustomNameVisible(true);
        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.SLIME, 0, 0, 3, 3, 3, 1, 15, 25);
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Weebly wob, your life supply will drop!");
    }
}