package mymoves.dunsparce;

import ru.ifmo.se.pokemon.*;

public class DragonRush extends PhysicalMove {
    public DragonRush(){
        super(Type.DRAGON,100,75);
    }
    @Override
    protected void applyOppDamage(Pokemon def, double damage){
        def.setMod(Stat.HP, (int) Math.round(damage));
    }
    @Override
    protected void applySelfEffects(Pokemon p){
        if(Math.random()<=0.2){
            Effect.flinch(p);
        }
    }
}
