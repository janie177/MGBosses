package com.minegusta.mgbosses;


import com.minegusta.mgbosses.command.BossCommand;
import com.minegusta.mgbosses.filemanager.Files;
import com.minegusta.mgbosses.listeners.BossListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Plugin PLUGIN;

    @Override
    public void onEnable()
    {
        //Plugin
        PLUGIN = this;

        //Config
        Files.loadConfigFiles();

        //Commands
        getCommand("bossreload").setExecutor(new BossCommand());

        //Listener
        Bukkit.getPluginManager().registerEvents(new BossListener(), this);

    }

    @Override
    public void onDisable()
    {

    }
}
