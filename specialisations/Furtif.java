package specialisations;

import java.util.Arrays;
import java.util.List;

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
    public int lancerPouvoir(int pouvoir, int attaqueNormale) {
        return switch (pouvoir) {
            case 0 -> assomer(attaqueNormale);
            default -> 0;
        };
    }

    private int assomer(int attaqueNormale){
        return attaqueNormale*2;
    }
   
}
