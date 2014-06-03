package com.minegusta.mgbosses.drops;

import com.minegusta.mgbosses.filemanager.Files;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;

public class DropList {

    private String dropList;
    private FileConfiguration conf = Files.getDropList();

    public DropList(String dropList)
    {
        this.dropList = dropList;
    }

    public ItemStack get()
    {
        return getDrop();
    }

    private ItemStack getDrop()
    {
        ItemStack i;
        if(conf.isSet(dropList))
        {
            List<String> drops = (List<String>) conf.getList(dropList);
            String[] split = splitToParts(drops);

            Material material = Material.getMaterial(Integer.parseInt(split[0]));
            int amount = Integer.parseInt(split[1]);
            short data = (short) Integer.parseInt(split[2]);
            i = new ItemStack(material, amount, data);

            if(split.length == 5)
            {
                try
                {
                    i.addUnsafeEnchantment(Enchantment.getById(Integer.parseInt(split[3])), Integer.parseInt(split[4]));
                } catch (Exception ignored)
                {
                    Bukkit.getLogger().info("An error appeared in MGBosses while adding an enchantment!");
                }
            }

        }
        else
        {
            i = new ItemStack(Material.AIR);
        }


        return i;
    }

    private String[] splitToParts(List<String> i)
    {
        Random rand = new Random();
        String chosen = i.get(rand.nextInt(i.size()));

        String[] split = chosen.split(",");

        return split;
    }

}
