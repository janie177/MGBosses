package com.minegusta.mgbosses.bosses;

import com.minegusta.mgbosses.util.TempData;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;

public class Spawn {

    private String bossName;
    private Location l;
    private World w;

    public Spawn(String bossName, Location l, World w)
    {
        this.bossName = bossName;
        this.l = l;
        this.w = w;
        spawnBoss();
    }

    private void spawnBoss()
    {
        BossFileManager m = new BossFileManager();

        if(!m.bossExists(bossName))return;

        Boss boss = new Boss(bossName);
        LivingEntity entity = (LivingEntity) w.spawnEntity(l, boss.getMob());

        if(TempData.isSpawned.containsKey(boss.getName()))return;

        TempData.isSpawned.put(boss.getName(), entity.getUniqueId());


        if(boss.isWither())
        {
            Skeleton skele = (Skeleton) entity;
            skele.setSkeletonType(Skeleton.SkeletonType.WITHER);
        }
        entity.setCustomName(ChatColor.translateAlternateColorCodes('&', boss.getName()));
        entity.setCustomNameVisible(true);
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.CLOUD, 0,0,3,3,3,1,30,25);
        entity.setRemoveWhenFarAway(false);

        TempData.boss.put(entity.getUniqueId(), boss);
        TempData.bossHealthMap.put(entity.getUniqueId(), boss.getHealth());
    }

}
