package com.minegusta.mgbosses.listeners;

import com.minegusta.mgbosses.util.TempData;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class GodMode {

    private Entity entity;


    public GodMode(EntityDamageEvent e)
    {
        this.entity = e.getEntity();
    }

    public GodMode(EntityDamageByBlockEvent e)
    {
        this.entity = e.getEntity();
    }

    public GodMode(EntityDamageByEntityEvent e)
    {
        this.entity = e.getEntity();
    }


    //Checks

    public boolean hasGodMode()
    {
        return TempData.god.containsKey(entity.getUniqueId());
    }

    public void removeFromMap()
    {
        TempData.god.remove(entity.getUniqueId());
    }
}
