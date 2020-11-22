package mymoves.dunsparce;

import ru.ifmo.se.pokemon.*;

public class FireBlast extends SpecialMove {
    public FireBlast (double pow,double acc){

        super(Type.FIRE,110,85);
    }
    @Override
    protected void applyOppDamage(Pokemon def, double damage){
        def.setMod(Stat.HP, (int) Math.round(damage));}
    @Override
    protected void applyOppEffects(Pokemon p){
        if(Math.random()<=0.1){
            Effect.burn(p);
        }
        }
}
