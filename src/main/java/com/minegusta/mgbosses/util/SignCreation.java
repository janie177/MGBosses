package com.minegusta.mgbosses.util;

import org.bukkit.entity.Player;
import org.bukkit.event.block.SignChangeEvent;

public class SignCreation {
    private Player player;
    private SignChangeEvent e;

    public SignCreation(SignChangeEvent e)
    {
     this.player = e.getPlayer();
     this.e = e;
    }

    //Methods to check the sign.

    public boolean isOP()
    {
        return player.isOp();
    }

    public boolean isBossSign()
    {
        return e.getLine(1).equalsIgnoreCase("[Boss]");
    }


    //Canceling the event.

    public void cancel()
    {
        e.setCancelled(true);
    }
}
