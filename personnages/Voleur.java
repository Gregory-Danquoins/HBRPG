package personnages;


import factions.Hero;
import specialisations.Feu;

public class Voleur extends Hero{

    public Voleur(String nom) {
        super(nom, new Feu(), Personnage.PV_DE_BASE*2, Personnage.ATTAQUE_DE_BASE, Personnage.DEFENSE_DE_BASE*2, Personnage.MANA_DE_BASE);
    }
}
