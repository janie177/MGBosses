package com.minegusta.mgbosses.bosses;

import com.minegusta.mgbosses.util.TempData;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
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
        BossFileManager m = new BossFileManager();

        if(!m.bossExists(bossName))return;

        Boss boss = new Boss(bossName);
        if(TempData.isSpawned.get(boss.getName()))return;

        LivingEntity entity = (LivingEntity) w.spawnEntity(l, boss.getMob());
        entity.setCustomName(ChatColor.translateAlternateColorCodes('&', boss.getName()));
        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.CLOUD, 0,0,3,3,3,1,30,25);

        TempData.boss.put(entity.getUniqueId(), boss);
        TempData.isSpawned.put(boss.getName(), true);
        TempData.bossHealthMap.put(entity.getUniqueId(), boss.getHealth());
    }

}
