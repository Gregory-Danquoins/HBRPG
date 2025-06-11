package equipements;

import personnages.Personnage;

public class PotionEtat extends  Potion{

    private final String NOM = "potion d'etat";

    
    public String getNOM() {
        return NOM;
    }

    public void getEffect(Personnage cible) {
                cible.setEtat("normal");
        }
    
}
