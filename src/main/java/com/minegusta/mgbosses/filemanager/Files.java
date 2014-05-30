package com.minegusta.mgbosses.filemanager;

import org.bukkit.configuration.file.FileConfiguration;

public class Files {

    private FileConfiguration bossList, dropList;

    //Boss configs -----------------------------------------------------------------------

    private void bossConfig()
    {
        ConfigFile bosses = new ConfigFile("Bosses", bossList);
        bossList = bosses.create();
    }

    //Drop configs -----------------------------------------------------------------------

    private void dropConfig()
    {
        ConfigFile drops = new ConfigFile("DropList", dropList);
        dropList = drops.create();
    }

    //Public -----------------------------------------------------------------------------

    public void loadConfigFiles()
    {
        dropConfig();
        bossConfig();
    }

    public FileConfiguration getBossConfig()
    {
        return bossList;
    }

    public FileConfiguration getDropList()
    {
        return dropList;
    }

}
