package com.minegusta.mgbosses.powers.abilities;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.LivingEntity;

import java.util.List;
import java.util.Random;

public class Taunt implements Ability{

    @Override
    public void run(LivingEntity damager, LivingEntity entity, double damage) {

        List<String> list = Lists.newArrayList("I could win with my eyes closed!", "When I was younger, I wanted to become a " + entity.getType().toString() + " astronaut.", "Why did I drop out of school and become a boss..", "Wanna date after this?", "Eat my fist!", "My breath is death!.. I might need to visit a dentist.", "My armor is iron!", "I AM DEATH!", "I killed Mufasa!", "Why can't we just be friends?", "DIE!", "Scared, Potte-... I mean " + damager.getName() + ".", "Adventurer! What is the airspeed velocity of a fully laden swallow?", damager.getName() + ", I am your father!", "YOU HAVE NO POWER HERE, " + damager.getName().toUpperCase() + "!!", "Someone stole your sweetroll?", "What is it? Dragons?", "My causing is out hunring dragons, and what do I get? Guard duty..", "It's just a scratch!", "Your mother fights better!", "You wont defeat me!");

        Random rand = new Random();
        int number = rand.nextInt(list.size());

        entity.getWorld().spigot().playEffect(entity.getLocation(), Effect.VILLAGER_THUNDERCLOUD, 0, 0, 3, 3, 3, 1, 6, 25);

        damager.sendMessage(ChatColor.RED + "[" + entity.getCustomName() + ChatColor.RED + "] " + ChatColor.RESET + list.get(number));
    }
}