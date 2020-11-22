package mypokemons;

import mymoves.ponyta.Facade;
import mymoves.ponyta.FireBlast;
import mymoves.ponyta.Rest;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Ponyta extends Pokemon {
    public Ponyta(String name,int level){
        super(name,level);
        super.setType(Type.FIRE);
        super.setStats(65,100,70,80,80,105);
        setMove(new Facade(),new FireBlast(),new Rest());
    }
}

