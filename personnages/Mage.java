package personnages;


import factions.Hero;
import specialisations.Glace;

public class Mage extends Hero{

   public Mage(String nom) {
        super(nom, new Glace(), Personnage.PV_DE_BASE*2, Personnage.ATTAQUE_DE_BASE*2, Personnage.DEFENSE_DE_BASE, Personnage.MANA_DE_BASE*2, 100);
    }
}
