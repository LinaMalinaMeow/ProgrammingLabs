package mypokemons;

import mymoves.gloom.Acid;
import mymoves.gloom.DazzlingGleam;
import mymoves.gloom.EnergyBall;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Gloom extends Oddish {
    public Gloom(String name,int level){
        super(name,level);
        super.setType(Type.GRASS,Type.POISON);
        super.setStats(60,65,70,85,75,40);
        setMove(new Acid(),new DazzlingGleam(),new EnergyBall());
    }
}
