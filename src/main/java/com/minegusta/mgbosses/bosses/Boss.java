package com.minegusta.mgbosses.bosses;

import org.bukkit.entity.EntityType;

import java.util.List;

public class Boss implements DefaultBoss{

    @Override
    public String getname() {
        return null;
    }

    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public EntityType getMob() {
        return null;
    }

    @Override
    public List<Integer> getDrops() {
        return null;
    }
}
