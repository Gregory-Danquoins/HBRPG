package equipements;

import personnages.Personnage;

public class PotionDeMana extends Potion{

        public static final String NOM = "Potion de Mana";
        public static final int RATIO = 1;

        @Override
        public String getNom() {
                return NOM;
        }

        @Override
        public void getEffect(Personnage cible) {
                cible.setMana(cible.getManaDeDepart()*RATIO);
                cible.getPotions().remove(this);   
        }
  
    
}
