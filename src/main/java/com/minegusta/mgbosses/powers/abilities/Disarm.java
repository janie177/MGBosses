package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Disarm implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {

        if(p.getInventory().firstEmpty() != (-1) && !p.getItemInHand().getType().equals(Material.AIR))
        {
            ItemStack weapon = p.getItemInHand();
            p.getInventory().addItem(weapon);
            p.setItemInHand(new ItemStack(Material.AIR));
            p.updateInventory();

            p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "Real (wo)men fight with their fists!");
        }

    }
}