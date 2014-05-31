package com.minegusta.mgbosses.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class BossListener implements Listener {


    //Damage from other entities.
    @EventHandler
    public void onBossDamage(EntityDamageByEntityEvent e)
    {

    }


    //Dieing.
    @EventHandler
    public void onBossDeath(EntityDeathEvent e)
    {

    }


    //Damage by blocks.
    @EventHandler
    public void onBossDamage(EntityDamageByBlockEvent e)
    {

    }


    //Damage by other stuff.
    @EventHandler
    public void onBossWeirdDamage(EntityDamageEvent e)
    {

    }


}
