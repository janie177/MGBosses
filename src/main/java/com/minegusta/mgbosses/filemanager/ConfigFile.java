package com.minegusta.mgbosses.filemanager;

import com.minegusta.mgbosses.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigFile {

    private String fileName;
    private FileConfiguration conf;
    private File file;
    private Plugin p = Main.PLUGIN;

    public ConfigFile(String fileName, FileConfiguration conf)
    {
        this.fileName = fileName;
        this.conf = conf;

    }

    public FileConfiguration create()
    {
        createDataFolder();
        createConfig();
        return conf;
    }

    private void createConfig()
    {
        try {
        file = new File(p.getDataFolder(), fileName + ".yml");
        if (!file.exists()) {
            file.createNewFile();
        }
        conf = YamlConfiguration.loadConfiguration(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createDataFolder()
    {
        try {
            if (!p.getDataFolder().exists()) {
                p.getDataFolder().mkdirs();
            }
        }catch(Exception error)
        {
            error.printStackTrace();
        }
    }
}
