package com.minegusta.mgbosses.powers.abilities;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class RemoveArmour implements Ability{

    @Override
    public void run(Player p, LivingEntity entity, double damage) {
        if (p.getInventory().getArmorContents().length == 0)return;

        ItemStack[] armour = p.getEquipment().getArmorContents();
        List<ItemStack> list = Lists.newArrayList();

        for(ItemStack s : armour)
        {
            list.add(s);
        }

        for(int i = 0; i < 5; i++)
        {
            if(p.getInventory().firstEmpty() != (-1))
            {
                p.getInventory().addItem(list.get((i-1)));
                list.remove(i-1);
            }
        }
        p.getEquipment().setArmorContents(new ItemStack[list.size()]);
        p.updateInventory();

        p.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + "HAHA You are naked now!");
    }
}