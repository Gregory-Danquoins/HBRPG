package specialisations;

import java.util.Arrays;
import java.util.List;

public class Glace extends Specialisation {

    public static final String CATEGORIE ="GLACE";
    
    public static final List<String> POUVOIRS = Arrays.asList("eclair de givre", "blizzard");

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
            case 0 -> lancerEclairdeGivre(attaqueNormale);
            case 1 -> lancerBlizzard(attaqueNormale);
            default -> 0;
        };
    }

    private int lancerEclairdeGivre(int attaqueNormale){
        return attaqueNormale*2;
    }
    
    private int lancerBlizzard(int attaqueNormale){
        return attaqueNormale*2;
    }
    
}
