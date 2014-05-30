package com.minegusta.mgbosses.util;

import com.google.common.collect.Maps;

import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

public class TempData {

    public static ConcurrentMap<UUID, Double> bossHealthMap = Maps.newConcurrentMap();
    public static ConcurrentMap<String, Boolean> bossIsSpawned = Maps.newConcurrentMap();
    public static ConcurrentMap<UUID, String> isBoss = Maps.newConcurrentMap();


}
