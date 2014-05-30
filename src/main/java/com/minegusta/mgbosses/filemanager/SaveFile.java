package com.minegusta.mgbosses.filemanager;

import com.minegusta.mgbosses.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class SaveFile {

    private String fileName;
    private File file;
    private FileConfiguration conf;
    private Plugin PLUGIN = Main.PLUGIN;

    public SaveFile(String fileName, FileConfiguration conf)
    {
        this.conf = conf;
        this.fileName = fileName;
        saveFile();
    }

    private void saveFile()
    {
    try {
        file = new File(PLUGIN.getDataFolder(), fileName + ".yml");
        conf.save(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}