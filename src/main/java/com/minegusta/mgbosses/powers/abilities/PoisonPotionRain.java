package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.ItemStack;

public class PoisonPotionRain implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {

        World world = damager.getWorld();
        Location spawnLocation = damager.getLocation().add(0,10,0);

        ThrownPotion potion =(ThrownPotion) world.spawnEntity(spawnLocation, EntityType.SPLASH_POTION);
        potion.setShooter(entity);

        potion.setItem(new ItemStack(Material.POTION, 1, (short) 16388));

        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Acid rain!");
    }
}