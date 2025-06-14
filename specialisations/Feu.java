package specialisations;

import Pouvoirs.PouvoirSpecial;
import java.util.Arrays;
import java.util.List;
import personnages.Personnage;

public class Feu extends Specialisation implements PouvoirSpecial{

    public static final String CATEGORIE ="FEU";

    public static final List<String> POUVOIRS = Arrays.asList("boule de feu", 
        "meteor");

    @Override
    public List<String> getPouvoirs() {
        return POUVOIRS;
    }

    @Override
    public String getCategorie() {
        return CATEGORIE;
    }

    @Override
    public int lancerPouvoir(int pouvoir) {
        return switch (pouvoir) {
            case 0 -> lancerBouleDeFeu();
            case 1 -> lancerMeteor();
            default -> 0;
        };
    }
    
    private int lancerBouleDeFeu(){
        return Personnage.ATTAQUE_DE_BASE*2;
    }
    
    private int lancerMeteor(){
        return Personnage.ATTAQUE_DE_BASE*2;
    }

    
}
