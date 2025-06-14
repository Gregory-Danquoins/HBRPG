package equipements;

import personnages.Personnage;

public class PotionDeVie extends Potion{

        public static final String NOM = "Potion de vie";
        public static final int RATIO = 1;

        @Override
        public String getNom() {
                return NOM;
        }

        @Override
        public void getEffect(Personnage cible) {
                cible.setPv(cible.getPvDedepart()*RATIO);   
                cible.getPotions().remove(this);   
        }
  
    
}
