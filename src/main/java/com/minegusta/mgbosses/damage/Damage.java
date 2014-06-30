package com.minegusta.mgbosses.damage;

import com.minegusta.mgbosses.bosses.Boss;
import com.minegusta.mgbosses.util.TempData;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;

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

    public boolean isArrow()
    {
        if(e.getDamager() instanceof Arrow)
        {
            ProjectileSource source = ((Arrow) e.getDamager()).getShooter();
            if(source instanceof LivingEntity)
            {
                uuid =((LivingEntity) source).getUniqueId();
                return true;
            }
        }
        return true;
    }

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
