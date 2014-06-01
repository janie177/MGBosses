package com.minegusta.mgbosses.damage;

import com.minegusta.mgbosses.bosses.Boss;
import com.minegusta.mgbosses.util.TempData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.UUID;

public class Damage {

    private UUID uuid;
    private Entity victim;
    private EntityDamageByEntityEvent e;

    public Damage(EntityDamageByEntityEvent e)
    {
        this.uuid = e.getDamager().getUniqueId();
        this.victim = e.getEntity();
        this.e = e;
    }

    //Checks

    public boolean isBossMob()
    {
        return TempData.boss.containsKey(uuid);
    }

    public boolean victimIsHuman()
    {
        return victim instanceof Player;
    }

    //Apply damage

    public void applyDamage()
    {
        Boss boss = TempData.boss.get(uuid);
        e.setDamage(boss.getDamage());

    }


}
