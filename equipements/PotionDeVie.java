package equipements;

import personnages.Personnage;

public class PotionDeVie extends Potion{

        private final String NOM = "Potion de vie";

        private final int RATIO = 1;

        @Override
        public String getNom() {
                return NOM;
        }

        public void getEffect(Personnage cible) {
                cible.setPv(cible.getPvDedepart());   
                cible.getPotions().remove(this);   
        }
  
    
}
