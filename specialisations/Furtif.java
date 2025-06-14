package specialisations;

import java.util.Arrays;
import java.util.List;
import personnages.Personnage;

public class Furtif extends Specialisation{

    public static final String CATEGORIE ="FURTIF";

    public static final List<String> POUVOIRS = Arrays.asList("assomer");

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
            case 0 -> assomer();
            default -> 0;
        };
    }

    private int assomer(){
        return Personnage.ATTAQUE_DE_BASE*2;
    }
   
}
