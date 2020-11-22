package mymoves.oddish;

import ru.ifmo.se.pokemon.*;
import sun.applet.Main;

public class EnergyBall extends SpecialMove {
    public EnergyBall(){
        super(Type.GRASS,90,100);
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if(Math.random() <= 0.1) {
            super.applyOppEffects(pokemon);
            Effect effect = new Effect().stat(Stat.SPECIAL_DEFENSE, -1);
            pokemon.addEffect(effect);
        }
    }
    @Override
    protected String describe() {
        return "использует Energy Ball";
    }
}

