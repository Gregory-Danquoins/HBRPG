package specialisations;

import java.util.Arrays;
import java.util.List;
import personnages.Personnage;

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
    public int lancerPouvoir(int pouvoir) {
        return switch (pouvoir) {
            case 0 -> lancerEclairdeGivre();
            case 1 -> lancerBlizzard();
            default -> 0;
        };
    }

    private int lancerEclairdeGivre(){
        return Personnage.ATTAQUE_DE_BASE*2;
    }
    
    private int lancerBlizzard(){
        return Personnage.ATTAQUE_DE_BASE*2;
    }
    
}
