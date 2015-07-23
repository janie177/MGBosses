package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;

public class ZombieMinions implements Ability {

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {

        if(entity.getWorld().getLivingEntities().stream().filter(ent -> ent instanceof Zombie && ((Zombie)ent).isBaby() && ent.getLocation().distance(entity.getLocation()) < 15).count() > 15)
        {
            return;
        }
        int amount = 8;
        for(int i = 0; i < amount + 1; i ++)
        {
            Zombie mob = (Zombie) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.ZOMBIE);
            mob.setCustomName(ChatColor.DARK_GREEN + "Mini Minion");
            mob.setCustomNameVisible(true);
            mob.setBaby(true);

        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.SLIME, 0, 0, 3, 3, 3, 1, 15, 25);
        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Minions! Attack!");
    }
}