package specialisations;

import Pouvoirs.PouvoirSpecial;
import java.util.Arrays;
import java.util.List;
import personnages.Personnage;

public class Feu extends Specialisation implements PouvoirSpecial{

    final private String categorie ="FEU";

    public final List<String> POUVOIRS = Arrays.asList("boule de feu", 
        "meteor");

    @Override
    public List<String> getPOUVOIRS() {
        return POUVOIRS;
    }

    @Override
    public int lancerPouvoir(int pouvoir) {
        return switch (pouvoir) {
            case 0 -> lancerBouleDeFeu();
            case 1 -> lancerMeteor();
            default -> 0;
        };
    }

    public String getCategorie(){
        return  categorie;
    }
    private int lancerBouleDeFeu(){
        return Personnage.ATTAQUE_DE_BASE*2;
    }
    
    private int lancerMeteor(){
        return Personnage.ATTAQUE_DE_BASE*2;
    }
}
