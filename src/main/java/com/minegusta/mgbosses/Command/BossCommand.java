package com.minegusta.mgbosses.Command;

import com.minegusta.mgbosses.filemanager.Files;
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
            s.sendMessage(ChatColor.GREEN + "MGBosses reloaded!");
        }
        return true;
    }
}
