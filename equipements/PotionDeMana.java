package equipements;

import personnages.Personnage;

public class PotionDeMana extends Potion{

        private final String NOM = "Potion de mana";

        public String getNOM() {
                return NOM;
        }

        private final int RATIO = 1;

        public void getEffect(Personnage cible) {
                cible.setMana(cible.getManaDeDepart());
        }
  
    
}
