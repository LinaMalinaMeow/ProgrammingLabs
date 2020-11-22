package mypokemons;

import mymoves.bellossom.LeafBlade;
import mymoves.gloom.Acid;
import mymoves.oddish.DazzlingGleam;
import mymoves.oddish.EnergyBall;
import ru.ifmo.se.pokemon.Type;

public class Bellossom extends Gloom {
    public Bellossom(String name,int level){
        super(name,level);
        super.setType(Type.GRASS);
        super.setStats(75,80,95,90,100,50);
        setMove(new Acid(),new DazzlingGleam(),new EnergyBall(),new LeafBlade());
    }
}
