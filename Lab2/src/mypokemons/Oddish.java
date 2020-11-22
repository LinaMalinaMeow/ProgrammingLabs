package mypokemons;

import mymoves.oddish.DazzlingGleam;
import mymoves.oddish.EnergyBall;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Oddish extends Pokemon {
    public Oddish(String name,int level){
        super(name,level);
        super.setType(Type.GRASS,Type.POISON);
        super.setStats(45,50,55,75,65,30);
        setMove(new DazzlingGleam(),new EnergyBall());
    }
}
