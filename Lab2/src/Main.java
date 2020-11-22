import mypokemons.*;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class Main {
    public static void main(String[]args){
        Battle b = new Battle();
        Oddish oddish = new Oddish("Meow",1);
        Bellossom bellossom = new Bellossom("TheCat",1);
        Dunsparce dunsparce = new Dunsparce("Banana",1);
        Gloom gloom = new Gloom("Apple",1);
        Ponyta ponyta = new Ponyta("Apricot",1);
        Rapidash rapidash = new Rapidash("Coconut",1);
        b.addAlly(oddish);
        b.addAlly(bellossom);
        b.addAlly(gloom);
        b.addFoe(ponyta);
        b.addFoe(dunsparce);
        b.addFoe(rapidash);
        b.go();
    }
}
