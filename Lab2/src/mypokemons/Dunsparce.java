package mypokemons;

import mymoves.dunsparce.Agility;
import mymoves.dunsparce.*;
import mymoves.rapidash.FireBlast;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Dunsparce extends Pokemon {
    public Dunsparce(String name,int level){
        super(name,level);
        super.setType(Type.NORMAL);
        super.setStats(100,70,70,65,65,45 );
        setMove(new Agility(),new DragonRush(),new WildCharge(),new FireBlast());
    }
}
