package com.minegusta.mgbosses.death;

import com.minegusta.mgbosses.Main;
import com.minegusta.mgbosses.bosses.Boss;
import com.minegusta.mgbosses.drops.DropList;
import com.minegusta.mgbosses.powers.abilities.ExplodeOnDeath;
import com.minegusta.mgbosses.util.TempData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public class BossDeath {

    private UUID uuid;
    private Entity entity;

    //Constructor

    public BossDeath(EntityDeathEvent e)
    {
        this.uuid = e.getEntity().getUniqueId();
        this.entity = e.getEntity();
    }

    //Methods

    public boolean isBoss()
    {
        return TempData.boss.containsKey(uuid);
    }

    //Death

    public void slay()
    {
        Boss boss = TempData.boss.get(uuid);


        //Explode on death check
        for(String s : boss.getAbilities())
        if(s.equalsIgnoreCase("ExplodeOnDeath"))
        {
            ExplodeOnDeath explode = new ExplodeOnDeath();
            explode.run((LivingEntity)entity);
        }

        if(entity instanceof Zombie || entity instanceof Skeleton)
        {
            ItemStack air = new ItemStack(Material.AIR);
            LivingEntity le = (LivingEntity) entity;
            le.getEquipment().setBoots(air);
            le.getEquipment().setHelmet(air);
            le.getEquipment().setItemInHand(air);
            le.getEquipment().setLeggings(air);
            le.getEquipment().setChestplate(air);
        }



        sendMessageToPlayersAndAwardExp(ChatColor.RED + boss.getDeathMessage(), (LivingEntity) entity, boss.getExp(), boss.getCredits());

        List<String> list = boss.getDropList();

        final DropList dropList = new DropList(list);

        final LivingEntity le = (LivingEntity) entity;

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.PLUGIN, new Runnable() {
            @Override
            public void run() {
                le.getWorld().dropItemNaturally(le.getLocation(), dropList.get());
            }
        },20 * 3);


        removeFromMap(boss.getName());
    }

    //private

    private void removeFromMap(String name)
    {
        TempData.boss.remove(uuid);
        TempData.isSpawned.remove(name);
    }

    private void sendMessageToPlayersAndAwardExp(String message, LivingEntity e, int exp, int credits)
    {
        for(Entity ent : e.getNearbyEntities(15,15,15))
        {
            if(ent instanceof Player)
            {
                Player p = (Player) ent;
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "addcredits " + p.getName() + " " + credits);
                p.sendMessage(ChatColor.RED + "[" + e.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + message);
                p.giveExp(exp);
            }
        }
    }
}
