package com.minegusta.mgbosses.powers.abilities.hordes;

import com.minegusta.mgbosses.powers.abilities.Ability;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;

public class LargeZombiePigManHorde implements Ability {

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        int amount = 16;
        for(int i = 0; i < amount + 1; i ++)
        {
            PigZombie mob = (PigZombie) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.PIG_ZOMBIE);
            mob.setCustomName(ChatColor.LIGHT_PURPLE + "Bacon Zombie");
            mob.setCustomNameVisible(true);
            mob.setAngry(true);
            mob.setTarget(p);

        }
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.POTION_SWIRL, 0, 0, 3, 3, 3, 1, 15, 25);
        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "The nether will make you perish!");
    }
}