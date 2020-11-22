package mymoves.rapidash;

import ru.ifmo.se.pokemon.*;

import static ru.ifmo.se.pokemon.Status.*;

public class Rest extends StatusMove {
    public Rest(){
        super(Type.PSYCHIC,0,0);
    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        super.applySelfEffects(p);
        p.setCondition(new Effect().condition(SLEEP).attack(0.0).turns(2));
        p.setMod(Stat.HP,-6);
    }

    @Override
    protected String describe() {
        return "REST";
    }
}


