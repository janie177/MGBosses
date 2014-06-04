package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RemoveArmour implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        if (p.getInventory().getArmorContents().length == 0)return;
        if(p.getInventory().firstEmpty() == (-1))return;

        ItemStack[] armour = p.getEquipment().getArmorContents();
        EntityEquipment equipment = p.getEquipment();
        Inventory inv = p.getInventory();
        ItemStack air = new ItemStack(Material.AIR);

        if(!equipment.getHelmet().getType().equals(Material.AIR))
        {
            inv.addItem(equipment.getHelmet());
            equipment.setHelmet(air);
        }

        if(!equipment.getLeggings().getType().equals(Material.AIR) && inv.firstEmpty() != (-1))
        {
            inv.addItem(equipment.getLeggings());
            equipment.setLeggings(air);
        }

        if(!equipment.getChestplate().getType().equals(Material.AIR) && inv.firstEmpty() != (-1))
        {
            inv.addItem(equipment.getChestplate());
            equipment.setChestplate(air);
        }

        if(!equipment.getBoots().getType().equals(Material.AIR) && inv.firstEmpty() != (-1))
        {
            inv.addItem(equipment.getBoots());
            equipment.setBoots(air);
        }



        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "HAHA You are naked now!");
    }
}