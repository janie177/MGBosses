package com.minegusta.mgbosses.death;

import com.minegusta.mgbosses.bosses.Boss;
import com.minegusta.mgbosses.drops.DropList;
import com.minegusta.mgbosses.util.TempData;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;

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
        sendMessageToPlayers(ChatColor.RED + boss.getDeathMessage(), (LivingEntity) entity);

        DropList dropList = new DropList(boss.getDropList());

        LivingEntity le = (LivingEntity) entity;
        le.getWorld().dropItemNaturally(le.getLocation(), dropList.get());

        removeFromMap(boss.getName());
    }

    //private

    private void removeFromMap(String name)
    {
        TempData.boss.remove(uuid);
        TempData.isSpawned.put(name, false);
    }

    private void sendMessageToPlayers(String message, LivingEntity e)
    {
        for(Entity ent : e.getNearbyEntities(15,15,15))
        {
            if(ent instanceof Player)
            {
                Player p = (Player) ent;
                p.sendMessage(ChatColor.RED + "[" + e.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + message);

            }
        }
    }
}
