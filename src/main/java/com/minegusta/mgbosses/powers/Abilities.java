package com.minegusta.mgbosses.powers;

import com.minegusta.mgbosses.powers.abilities.Ability;
import com.minegusta.mgbosses.powers.abilities.Explode;
import com.minegusta.mgbosses.powers.abilities.effects.Poison;

public enum Abilities {

    //Make sure they are lowercase!!!!

    explode(new Explode()),
    poison(new Poison());


    Ability abilityClass;

    private Abilities(Ability abilityClass)
    {
        this.abilityClass = abilityClass;
    }

    public Ability get()
    {
        return abilityClass;
    }


}
