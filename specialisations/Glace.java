package specialisations;

import java.util.Arrays;
import java.util.List;
import personnages.Personnage;

public class Glace extends Specialisation {

    final private String categorie ="GLACE";

    
    public final List<String> POUVOIRS = Arrays.asList("eclair de givre", 
        "blizzard");

    @Override
    public List<String> getPOUVOIRS() {
        return this.POUVOIRS;
    }

    @Override
    public int lancerPouvoir(int pouvoir) {
        return switch (pouvoir) {
            case 0 -> lancerEclairdeGivre();
            case 1 -> lancerBlizzard();
            default -> 0;
        };
    }

    public String getCategorie(){
        return  categorie;
    }

    private int lancerEclairdeGivre(){
        return Personnage.ATTAQUE_DE_BASE*2;
    }
    
    private int lancerBlizzard(){
        return Personnage.ATTAQUE_DE_BASE*2;
    }
    
}
