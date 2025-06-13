package equipements;

import personnages.Personnage;

public abstract class Potion {

    private final String NOM = "Potion";

    public String getNom() {
        return NOM;
    }

    public void getEffect(Personnage cible) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
}
