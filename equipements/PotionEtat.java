package equipements;

import personnages.Personnage;

public class PotionEtat extends Potion{

    public static final String NOM = "Potion d'état'";

    @Override
    public String getNom() {
            return NOM;
    }
    
    @Override
    public void getEffect(Personnage cible) {
                cible.setEtat("normal");
                cible.getPotions().remove(this);   
        }
    
}
