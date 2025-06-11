package equipements;

import personnages.Personnage;

public class PotionDeVie extends Potion{

        private final String NOM = "Potion de vie";

        public String getNOM() {
                return NOM;
        }

        private final int RATIO = 1;

        public void getEffect(Personnage cible) {
                cible.setPv(cible.getPvDedepart());
        }
  
    
}
