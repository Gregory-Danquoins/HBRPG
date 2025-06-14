package specialisations;

import java.util.Arrays;
import java.util.List;

import personnages.Personnage;

public class Tank extends Specialisation{

    public static final String CATEGORIE ="TANK";

    public static final List<String> POUVOIRS = Arrays.asList("excalibur");

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
            case 0 -> lancerExcalibur();
            default -> 0;
        };
    }

    private int lancerExcalibur(){
        return Personnage.ATTAQUE_DE_BASE*2;
    }
   
}
