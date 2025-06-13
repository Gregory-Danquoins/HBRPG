package equipements;

import personnages.Personnage;

public class PotionEtat extends Potion{

    private final String NOM = "potion d'etat";

    @Override
    public String getNom() {
      return NOM;
    }

    public void getEffect(Personnage cible) {
                cible.setEtat("normal");
                cible.getPotions().remove(this);   

        }
    
}
