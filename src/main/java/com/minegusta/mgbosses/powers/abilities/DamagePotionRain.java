package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.ItemStack;

public class DamagePotionRain implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {

        World world = p.getWorld();
        Location spawnLocation = p.getLocation().add(0,10,0);

        ThrownPotion potion =(ThrownPotion) world.spawnEntity(spawnLocation, EntityType.SPLASH_POTION);
        potion.setShooter(entity);

        potion.setItem(new ItemStack(Material.POTION, 1, (short) 16396));

        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Better run!");

    }
}