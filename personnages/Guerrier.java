package personnages;

import factions.Hero;
import specialisations.Tank;


public class Guerrier extends Hero{
 
  public Guerrier(String nom) {
        super(nom, new Tank(), Personnage.PV_DE_BASE*2, Personnage.ATTAQUE_DE_BASE*2, Personnage.DEFENSE_DE_BASE*2, Personnage.MANA_DE_BASE);
    }

    
}
