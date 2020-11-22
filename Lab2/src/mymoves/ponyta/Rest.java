package mymoves.ponyta;

import ru.ifmo.se.pokemon.*;

public class Rest extends PhysicalMove {
    public Rest(){
        super(Type.PSYCHIC,0,0);
    }
        @Override
        protected void applySelfEffects(Pokemon p) {
            super.applySelfEffects(p);
            p.setCondition(new Effect().condition(Status.SLEEP).attack(0.0).turns(2));
            p.setMod(Stat.HP,-6);
        }

        @Override
        protected String describe() {
            return "REST";
        }
    }

