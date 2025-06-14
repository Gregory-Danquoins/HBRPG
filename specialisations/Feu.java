package specialisations;

import Pouvoirs.PouvoirSpecial;
import java.util.Arrays;
import java.util.List;

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
    public int lancerPouvoir(int pouvoir, int attaqueNormale) {
        return switch (pouvoir) {
            case 0 -> lancerBouleDeFeu(attaqueNormale);
            case 1 -> lancerMeteor(attaqueNormale);
            default -> 0;
        };
    }
    
    private int lancerBouleDeFeu(int attaqueNormale){
        double totalDegats = attaqueNormale*1.3;
        return (int) totalDegats;
    }
    
    private int lancerMeteor(int attaqueNormale){
        double totalDegats = attaqueNormale*1.3;
        return (int) totalDegats;
    }

    
}
