package com.minegusta.mgbosses.death;

import com.minegusta.mgbosses.bosses.Boss;
import com.minegusta.mgbosses.drops.DropList;
import com.minegusta.mgbosses.powers.abilities.ExplodeOnDeath;
import com.minegusta.mgbosses.util.TempData;
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

        sendMessageToPlayersAndAwardExp(ChatColor.RED + boss.getDeathMessage(), (LivingEntity) entity, boss.getExp());

        List<String> list = boss.getDropList();

        DropList dropList = new DropList(list);

        LivingEntity le = (LivingEntity) entity;
        le.getWorld().dropItemNaturally(le.getLocation(), dropList.get());

        removeFromMap(boss.getName());
    }

    //private

    private void removeFromMap(String name)
    {
        TempData.boss.remove(uuid);
        TempData.isSpawned.remove(name);
    }

    private void sendMessageToPlayersAndAwardExp(String message, LivingEntity e, int exp)
    {
        for(Entity ent : e.getNearbyEntities(15,15,15))
        {
            if(ent instanceof Player)
            {
                Player p = (Player) ent;
                p.sendMessage(ChatColor.RED + "[" + e.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + message);
                p.giveExp(exp);
            }
        }
    }
}
