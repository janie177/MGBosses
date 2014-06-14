package com.minegusta.mgbosses.bosses;

import org.bukkit.entity.EntityType;

import java.util.List;

public interface DefaultBoss {

    public String getName();

    public double getHealth();

    public EntityType getMob();

    public List<String> getDropList();

    public List<String> getAbilities();

    public double getDamage();

    public String getDeathMessage();

    public int getAbilityChance();

    public boolean isWither();

    public int getExp();

    public int getCredits();
}
