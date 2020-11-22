package mymoves.dunsparce;

import ru.ifmo.se.pokemon.*;

public class Agility extends StatusMove {
    public Agility() {
        super(Type.PSYCHIC, 0, 0);

    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        super.applySelfEffects(p);
        Effect e1 = new Effect().stat(Stat.SPEED, 2);
    }
    @Override
    protected String describe() {
        return "Agility";
    }
}
