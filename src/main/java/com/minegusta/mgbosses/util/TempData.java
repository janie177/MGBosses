package com.minegusta.mgbosses.util;

import com.google.common.collect.Maps;
import com.minegusta.mgbosses.bosses.Boss;

import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

public class TempData {

    public static ConcurrentMap<UUID, Double> bossHealthMap = Maps.newConcurrentMap();
    public static ConcurrentMap<UUID, Boss> boss = Maps.newConcurrentMap();
    public static ConcurrentMap<String, Boolean> isSpawned = Maps.newConcurrentMap();
    public static ConcurrentMap<UUID, Boolean> god = Maps.newConcurrentMap();
}
