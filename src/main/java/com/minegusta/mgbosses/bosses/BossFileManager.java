package com.minegusta.mgbosses.bosses;

import com.minegusta.mgbosses.filemanager.Files;
import com.minegusta.mgbosses.util.StringToMob;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;

import java.util.List;

public class BossFileManager {

    private FileConfiguration conf()
    {
        return Files.getBossConfig();
    }

    //All the config options
    public String getName(String bossName)
    {
        if(!conf().isSet(bossName + ".name"))return "Boss not found!";
        return conf().getString(bossName + ".name");
    }

    public double getHealth(String bossName)
    {
        if(!conf().isSet(bossName + ".health"))return 40;
        return conf().getDouble(bossName + ".health");
    }

    public EntityType getMob(String bossName)
    {
        if(!conf().isSet(bossName + ".mob"))return EntityType.ZOMBIE;
        return StringToMob.valueOf(conf().getString(bossName + ".mob").toUpperCase()).get();
    }

    public boolean isWither(String bossName)
    {
        return StringToMob.valueOf(conf().getString(bossName + ".mob").toUpperCase()).isWither();
    }

    public double getDamage(String bossName)
    {
        if(!conf().isSet(bossName + ".damage"))return 4;
        return conf().getDouble(bossName + ".damage");
    }

    public List<String> getDropList(String bossName)
    {
        if(!conf().isSet(bossName + ".droplist"))return null;
        return (List<String>) conf().getList(bossName + ".droplist");
    }

    public List<String> getAbilities(String bossName)
    {
        if(!conf().isSet(bossName + ".abilities"))return null;
        return (List<String>) conf().getList(bossName + ".abilities");
    }

    public String getDeathMessage(String bossName)
    {
        if(!conf().isSet(bossName + ".deathmessage"))return null;
        return  conf().getString(bossName + ".deathmessage");
    }

    public int getAbilityChance(String bossName)
    {
        if(!conf().isSet("abilitychance"))return 10;
        return conf().getInt(bossName + ".abilitychance");
    }

    public int getExp(String bossName)
    {
        if(!conf().isSet("exp"))return 0;
        return conf().getInt(bossName + ".exp");
    }

    public boolean bossExists(String bossName)
    {
        return conf().isSet(bossName);
    }


}
