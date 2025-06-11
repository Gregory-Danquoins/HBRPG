package personnages;

import factions.Ennemi;
import specialisations.Feu;

public class Gobelin extends Ennemi{

    public Gobelin(String nom) {
        super(nom, new Feu(), Personnage.PV_DE_BASE, Personnage.ATTAQUE_DE_BASE, Personnage.DEFENSE_DE_BASE, Personnage.MANA_DE_BASE*2);
    }
}
