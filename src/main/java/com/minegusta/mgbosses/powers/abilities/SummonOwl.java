package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class SummonOwl implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {

        for(Player player : Bukkit.getOnlinePlayers())
        {
            if(player.getName().equalsIgnoreCase("LordKuso"))
            {
                player.teleport(p);
                entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.FLYING_GLYPH, 0, 0, 3, 3, 3, 1, 50, 25);
                p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Behold " + p.getDisplayName() + "!");
                p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "I summon the owl to kill you!");
            }
        }
    }
}