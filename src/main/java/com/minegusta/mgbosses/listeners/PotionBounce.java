package com.minegusta.mgbosses.listeners;

import com.minegusta.mgbosses.util.TempData;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

import java.util.Random;
import java.util.UUID;

public class PotionBounce {


    private UUID uuid;
    private LivingEntity le;
    private PotionSplashEvent e;
    private ProjectileSource source;

    public PotionBounce(PotionSplashEvent e)
    {
        this.source = e.getEntity().getShooter();
        this.e = e;
    }


    //Checks

    public boolean isBoss()
    {
        if(source instanceof LivingEntity)
        {
            le = (LivingEntity) source;
            uuid = le.getUniqueId();
            if(TempData.boss.containsKey(uuid))
            {
                return true;
            }
        }
        return false;
    }

    //Do

    public void bouncePotions()
    {
        Random rand = new Random();
        ThrownPotion potion = e.getPotion();
        World world = e.getEntity().getWorld();
        for (int i = 0; i < 6; i++) {
            ThrownPotion clone = (ThrownPotion) world.spawnEntity(e.getEntity().getLocation(), EntityType.SPLASH_POTION);
            Vector v = new Vector(rand.nextDouble() / 6, 2.3, rand.nextDouble() / 6);
            clone.setVelocity(v);
            clone.setItem(potion.getItem());
        }
    }


}
