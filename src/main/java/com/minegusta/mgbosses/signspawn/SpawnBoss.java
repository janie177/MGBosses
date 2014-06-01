package com.minegusta.mgbosses.signspawn;

import com.minegusta.mgbosses.bosses.Spawn;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SpawnBoss {

    private Sign sign;
    private String bossName;
    PlayerInteractEvent e;

    public SpawnBoss(PlayerInteractEvent e)
    {
        this.e = e;
    }

    //Checks

    public boolean hasABlock()
    {
        return e.hasBlock();
    }

    public boolean isRightClick()
    {
        return e.getAction().equals(Action.RIGHT_CLICK_BLOCK);
    }

    public boolean isSign()
    {
        return e.getClickedBlock().getState() instanceof Sign && (e.getClickedBlock().getType().equals(Material.SIGN) || e.getClickedBlock().getType().equals(Material.WALL_SIGN) || e.getClickedBlock().getType().equals(Material.SIGN_POST));
    }

    //Checking sign

    public boolean isBossSign()
    {
        BlockState state = e.getClickedBlock().getState();
        sign = (Sign) state;

        if(sign.getLine(1).equalsIgnoreCase("[Boss]") && !sign.getLine(2).equalsIgnoreCase(""))
        {
        bossName = sign.getLine(2);
            return true;
        }
        return false;
    }


    //Spawning the mob

    public void spawnMob()
    {
        new Spawn(bossName,  e.getPlayer().getLocation(), e.getPlayer().getWorld());
    }

}
