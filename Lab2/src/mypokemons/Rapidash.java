package mypokemons;

import mymoves.ponyta.Facade;
import mymoves.ponyta.Rest;
import mymoves.rapidash.FireBlast;
import mymoves.rapidash.Megahorn;
import ru.ifmo.se.pokemon.Type;

public class Rapidash extends Ponyta {
    public Rapidash (String name,int level){
        super(name,level);
        super.setType(Type.FIRE);
        super.setStats(65,100,70,80,80,105);
        setMove(new Facade(),new FireBlast(),new Megahorn(),new Rest());

    }
}

