package com.minegusta.mgbosses.bosses;

import org.bukkit.entity.EntityType;

import java.util.List;

public class Boss implements DefaultBoss{

    private String bossName;
    private double health;
    private EntityType mob;
    private List<String> droplist;
    private List<String> abilities;
    private String deathMessage;
    private double damage;
    private int abilityChance;
    private int exp;
    private int credits;
    private boolean isWither;
    BossFileManager m = new BossFileManager();

    public Boss(String bossName)
    {
        this.bossName = m.getName(bossName);
        damage = m.getDamage(bossName);
        health = m.getHealth(bossName);
        mob = m.getMob(bossName);
        abilityChance = m.getAbilityChance(bossName);
        droplist = m.getDropList(bossName);
        deathMessage = m.getDeathMessage(bossName);
        abilities = m.getAbilities(bossName);
        isWither = m.isWither(bossName);
        exp = m.getExp(bossName);
        credits = m.getCredits(bossName);
    }

    @Override
    public String getName()
    {
        return bossName;
    }

    @Override
    public double getHealth()
    {
        return health;
    }

    @Override
    public double getDamage()
    {
        return damage;
    }

    @Override
    public EntityType getMob()
    {
        return mob;
    }

    @Override
    public List<String> getDropList()
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

    @Override
    public int getAbilityChance()
    {
        return abilityChance;
    }

    @Override
    public boolean isWither() {
        return isWither;
    }

    @Override
    public int getExp() {
        return exp;
    }

    @Override
    public int getCredits() {
        return credits;
    }
}
