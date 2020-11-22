package mymoves.bellossom;

import ru.ifmo.se.pokemon.*;

public class Acid extends SpecialMove {
    public Acid(){
        super(Type.POISON,40,100);
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
        return "использует Acid";
    }

}



