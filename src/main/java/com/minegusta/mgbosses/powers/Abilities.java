package com.minegusta.mgbosses.powers;

import com.minegusta.mgbosses.powers.abilities.Ability;
import com.minegusta.mgbosses.powers.abilities.Poison;

public enum Abilities {

    Poison(new Poison());


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
