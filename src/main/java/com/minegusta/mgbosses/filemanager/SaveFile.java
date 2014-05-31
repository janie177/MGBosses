package com.minegusta.mgbosses.filemanager;

import com.minegusta.mgbosses.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class SaveFile {

    private static String fileName;
    private static File file;
    private static FileConfiguration conf;
    private static Plugin PLUGIN = Main.PLUGIN;

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