package com.minegusta.mgbosses.listeners;

import com.minegusta.mgbosses.damage.Damage;
import com.minegusta.mgbosses.death.BossDeath;
import com.minegusta.mgbosses.health.BossHealth;
import com.minegusta.mgbosses.powers.AbilityManager;
import com.minegusta.mgbosses.signspawn.SpawnBoss;
import com.minegusta.mgbosses.util.SignCreation;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractEvent;

public class BossListener implements Listener {


    //Damage from other entities. Also boss damage to others and Abilities.
    @EventHandler
    public void onBossDamage(EntityDamageByEntityEvent e)
    {
        BossHealth health = new BossHealth(e);
        if(health.isBoss())
        {
            health.damage();
            e.setDamage(1.0);
        }

        Damage damage = new Damage(e);
        if(damage.isArrow() && damage.isBossMob() && damage.victimIsHuman())
        {
            damage.applyDamage();
        }

        AbilityManager ability = new AbilityManager(e);
        if(ability.isBossMob() && ability.isPlayer())
        {
            ability.runAbility();
        }

        GodMode god = new GodMode(e);
        if(god.hasGodMode())
        {
            e.setCancelled(true);
            god.removeFromMap();
        }


    }

    //Potion throw power listener
    @EventHandler
    public void onPotionBounce(PotionSplashEvent e)
    {
        PotionBounce bounce = new PotionBounce(e);
        if(bounce.isBoss())
        {
            bounce.bouncePotions();
        }
    }


    //Dieing.
    @EventHandler
    public void onBossDeath(EntityDeathEvent e)
    {
        BossDeath death = new BossDeath(e);
        if(death.isBoss())
        {
            death.slay();
        }
    }


    //Damage by blocks.
    @EventHandler
    public void onBossDamage(EntityDamageByBlockEvent e)
    {
        BossHealth health = new BossHealth(e);
        if(health.isBoss())
        {
            health.damage();
            e.setDamage(1.0);
        }

        GodMode god = new GodMode(e);
        if(god.hasGodMode())
        {
            e.setCancelled(true);
            god.removeFromMap();
        }
    }


    //Damage by other stuff.
    @EventHandler
    public void onBossWeirdDamage(EntityDamageEvent e)
    {
        BossHealth health = new BossHealth(e);
        if(health.isBoss())
        {
            health.damage();
            e.setDamage(1.0);
        }

        GodMode god = new GodMode(e);
        if(god.hasGodMode())
        {
            e.setCancelled(true);
            god.removeFromMap();
        }
    }


    //Interacting with a sign
    @EventHandler
    public void onBossSpawn(PlayerInteractEvent e)
    {
        SpawnBoss spawn = new SpawnBoss(e);
        if(spawn.isRightClick() && spawn.hasABlock() && spawn.isSign() && spawn.isBossSign())
        {
            spawn.spawnMob();
        }

    }

    //Stop people from making their own boss signs.
    @EventHandler
    public void onSignplace(SignChangeEvent e)
    {
        SignCreation sign = new SignCreation(e);
        if(sign.isBossSign() && !sign.isOP())
        {
            sign.cancel();
        }

    }

}
