package specialisations;

import java.util.Arrays;
import java.util.List;
import personnages.Personnage;

public class Furtif extends Specialisation{

    final private String categorie ="FURTIF";

    public final List<String> POUVOIRS = Arrays.asList("assomer");

    @Override
    public List<String> getPOUVOIRS() {
        return this.POUVOIRS;
    }

    @Override
    public int lancerPouvoir(int pouvoir) {
        return switch (pouvoir) {
            case 0 -> assomer();
            default -> 0;
        };
    }

    public String donnerCategorie(){
        return  categorie;
    }

    private int assomer(){
        return Personnage.ATTAQUE_DE_BASE*2;
    }
   
}
