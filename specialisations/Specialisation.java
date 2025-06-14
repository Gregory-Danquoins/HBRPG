package specialisations;

import java.util.List;


public abstract  class Specialisation {

    public abstract List<String> getPouvoirs();

    public abstract int lancerPouvoir(int pouvoir, int attaqueNormale);

    public abstract String getCategorie();

    
}
