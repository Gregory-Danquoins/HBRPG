package specialisations;

import java.util.Arrays;
import java.util.List;


public abstract  class Specialisation {

    public final List<String> POUVOIRS = Arrays.asList();
    public List<String> getPOUVOIRS() {
        return POUVOIRS;
    }

    private static final String categorie="";

    abstract public int lancerPouvoir(int pouvoir);

    public String getCategorie(){
        return this.categorie;
    }

    
}
