package com.minegusta.mgbosses.bosses;

import com.minegusta.mgbosses.util.TempData;
import org.bukkit.entity.EntityType;

import java.util.List;

public class Boss implements DefaultBoss{

    private String bossName;
    private double health;
    private EntityType mob;
    private String droplist;
    private List<String> abilities;
    private String deathMessage;
    BossFileManager m = new BossFileManager();

    public Boss(String bossName)
    {
        this.bossName = bossName;
        health = m.getHealth(bossName);
        mob = m.getMob(bossName);
        droplist = m.getDropList(bossName);
        deathMessage = m.getDeathMessage(bossName);
        abilities = m.getAbilities(bossName);
    }

    @Override
    public String getname()
    {
        return bossName;
    }

    @Override
    public double getHealth()
    {
        return health;
    }

    @Override
    public EntityType getMob()
    {
        return mob;
    }

    @Override
    public String getDropList()
    {
        return droplist;
    }

    @Override
    public List<String> getAbilities()
    {
        return abilities;
    }

    @Override
    public String getDeathMessage()
    {
        return deathMessage;
    }
}
