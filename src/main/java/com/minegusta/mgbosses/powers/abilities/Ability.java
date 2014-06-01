package com.minegusta.mgbosses.powers.abilities;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface Ability {

    public String getName();

    public void run(Player p, LivingEntity entity, double damage);
}