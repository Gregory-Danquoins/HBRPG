package personnages;

import factions.Ennemi;
import specialisations.Feu;

public class Troll extends Ennemi{

    public Troll(String nom) {
        super(nom, new Feu(), Personnage.PV_DE_BASE, Personnage.ATTAQUE_DE_BASE, Personnage.DEFENSE_DE_BASE, Personnage.MANA_DE_BASE, 50);
    }
}
