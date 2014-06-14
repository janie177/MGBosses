package com.minegusta.mgbosses.command;

import com.minegusta.mgbosses.filemanager.Files;
import com.minegusta.mgbosses.util.TempData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class BossCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("bossreload") && (s.isOp() || s instanceof ConsoleCommandSender))
        {
            Files.loadConfigFiles();
            TempData.isSpawned.clear();
            s.sendMessage(ChatColor.GREEN + "MGBosses reloaded!");
        }
        return true;
    }
}
