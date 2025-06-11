package personnages;

import factions.Ennemi;
import specialisations.Feu;

public class Dragon extends Ennemi{

    public Dragon(String nom) {
        super(nom, new Feu(), Personnage.PV_DE_BASE*2, Personnage.ATTAQUE_DE_BASE*2, Personnage.DEFENSE_DE_BASE*2, Personnage.MANA_DE_BASE*2, 100);
    }
}
