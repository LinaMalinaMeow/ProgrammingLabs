package mymoves.gloom;

import ru.ifmo.se.pokemon.*;

public class EnergyBall extends SpecialMove {
    public EnergyBall(){
        super(Type.GRASS,90,100);
    }
    @Override
    protected void applyOppDamage(Pokemon def, double damage){
        def.setMod(Stat.HP, (int) Math.round(damage));
    }
    @Override
    protected void applyOppEffects(Pokemon p){
        if(Math.random()<=0.1){
            Effect.flinch(p);
        }
    }
    @Override
    protected String describe() {
        return "использует EnergyBall";
    }
}
