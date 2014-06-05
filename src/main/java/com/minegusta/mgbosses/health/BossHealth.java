package com.minegusta.mgbosses.health;

import com.minegusta.mgbosses.util.TempData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.UUID;

public class BossHealth {

    private UUID uuid;
    private double damage;
    Entity entity;
    EntityDamageByEntityEvent entityDamageByEntityEvent;
    EntityDamageEvent entityDamageEvent;
    EntityDamageByBlockEvent entityDamageByBlockEvent;

    //Constructors

    public BossHealth(EntityDamageByEntityEvent e)
    {
        this.uuid = e.getEntity().getUniqueId();
        this.damage = e.getDamage();
        this.entity = e.getEntity();
        this.entityDamageByEntityEvent = e;
    }

    public BossHealth(EntityDamageEvent e)
    {
        this.uuid = e.getEntity().getUniqueId();
        this.damage = e.getDamage();
        this.entity = e.getEntity();
        this.entityDamageEvent = e;
    }

    public BossHealth(EntityDamageByBlockEvent e)
    {
        this.uuid = e.getEntity().getUniqueId();
        this.damage = e.getDamage();
        this.entity = e.getEntity();
        this.entityDamageByBlockEvent = e;
    }

    //Checks
    public boolean isBoss()
    {
        return TempData.boss.containsKey(uuid);
    }

    //private
    private void setMaxhealth()
    {
       LivingEntity livingEntity = (LivingEntity) entity;
       livingEntity.setHealth(livingEntity.getMaxHealth());

    }


    //Do damage

    public void damage()
    {
        if(!TempData.bossHealthMap.containsKey(uuid))return;
        double health = TempData.bossHealthMap.get(uuid);

        if(health > damage)
        {
            TempData.bossHealthMap.put(uuid, health - damage);
            setMaxhealth();
        }
        else
        {
            TempData.bossHealthMap.remove(uuid);
            setMaxhealth();
        }
        setDamageToOne();
    }


    private void setDamageToOne()
    {
        if(entityDamageByEntityEvent != null) entityDamageByEntityEvent.setDamage(1.0);
        if(entityDamageEvent != null) entityDamageEvent.setDamage(1.0);
        if(entityDamageByBlockEvent != null) entityDamageByBlockEvent.setDamage(1.0);

    }


}
