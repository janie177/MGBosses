package com.minegusta.mgbosses.bosses;

import com.minegusta.mgbosses.util.TempData;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;

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
        Boss boss = new Boss(bossName);

        LivingEntity entity = (LivingEntity) w.spawnEntity(l, boss.getMob());

        TempData.boss.put(entity.getUniqueId(), boss);
        TempData.bossHealthMap.put(entity.getUniqueId(), boss.getHealth());

    }

}
