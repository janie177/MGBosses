package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class LargeCreeperHorde implements Ability {

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        int amount = 10;
        for(int i = 0; i < amount + 1; i ++)
        {
            Creeper mob = (Creeper) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.CREEPER);
            mob.setCustomName(ChatColor.GREEN + "Walking Green TNT Stick");
            mob.setCustomNameVisible(true);
            mob.setPowered(true);
        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.COLOURED_DUST, 0, 0, 3, 3, 3, 1, 15, 25);
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "This will blow your mind!");
    }
}