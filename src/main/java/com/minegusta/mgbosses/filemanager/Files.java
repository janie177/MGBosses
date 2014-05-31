package com.minegusta.mgbosses.filemanager;

import org.bukkit.configuration.file.FileConfiguration;

public class Files {

    private static FileConfiguration bossList, dropList;

    //Boss configs -----------------------------------------------------------------------

    private static void bossConfig()
    {
        ConfigFile bosses = new ConfigFile("Bosses", bossList);
        bossList = bosses.create();
    }

    //Drop configs -----------------------------------------------------------------------

    private static void dropConfig()
    {
        ConfigFile drops = new ConfigFile("DropList", dropList);
        dropList = drops.create();
    }

    //Public -----------------------------------------------------------------------------

    public static void loadConfigFiles()
    {
        dropConfig();
        bossConfig();
    }

    public static FileConfiguration getBossConfig()
    {
        return bossList;
    }

    public static FileConfiguration getDropList()
    {
        return dropList;
    }

}
