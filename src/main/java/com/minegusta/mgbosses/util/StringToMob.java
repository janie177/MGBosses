package com.minegusta.mgbosses.util;

import org.bukkit.entity.EntityType;

public enum StringToMob {

    ZOMBIE(EntityType.ZOMBIE),
    ENDER_DRAGON(EntityType.ENDER_DRAGON),
    COW(EntityType.COW),
    PIG(EntityType.PIG),
    SHEEP(EntityType.SHEEP),
    MUSHROOM_COW(EntityType.MUSHROOM_COW),
    VILLAGER(EntityType.VILLAGER),
    SQUID(EntityType.SQUID),
    OCELOT(EntityType.OCELOT),
    BAT(EntityType.BAT),
    HORSE(EntityType.HORSE),
    SNOWMAN(EntityType.SNOWMAN),
    CHICKEN(EntityType.CHICKEN),
    GIANT(EntityType.GIANT),
    SKELETON(EntityType.SKELETON),
    SPIDER(EntityType.SPIDER),
    CAVE_SPIDER(EntityType.CAVE_SPIDER),
    SILVERFISH(EntityType.SILVERFISH),
    ENDERMAN(EntityType.ENDERMAN),
    CREEPER(EntityType.CREEPER),
    BLAZE(EntityType.BLAZE),
    GHAST(EntityType.GHAST),
    PIG_ZOMBIE(EntityType.PIG_ZOMBIE),
    SLIME(EntityType.SLIME),
    MAGMA_CUBE(EntityType.MAGMA_CUBE),
    WOLF(EntityType.WOLF),
    WITCH(EntityType.WITCH),
    IRON_GOLEM(EntityType.IRON_GOLEM),
    WITHER(EntityType.WITHER);
    


    private EntityType e;

    private StringToMob(EntityType e)
    {
        this.e = e;
    }

    public EntityType get()
    {
        return e;
    }
}
