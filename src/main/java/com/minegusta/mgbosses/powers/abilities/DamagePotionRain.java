package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;

public class DamagePotionRain implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {

        World world = p.getWorld();
        Location spawnLocation = p.getLocation().add(0,10,0);

        ThrownPotion potion =(ThrownPotion) world.spawnEntity(spawnLocation, EntityType.SPLASH_POTION);
        potion.setShooter(entity);
    }
}