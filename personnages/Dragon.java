package personnages;

import java.util.Arrays;
import java.util.List;

import factions.Ennemi;
import specialisations.Feu;

public class Dragon extends Ennemi{

    public static final List<String> NOMS_DISPONIBLES = Arrays.asList("Dragon ancien","Dragon du cauchemar","Dragon céleste");

    public Dragon(String nom) {
        super(nom, new Feu(), Personnage.PV_DE_BASE*2, Personnage.ATTAQUE_DE_BASE*2, Personnage.DEFENSE_DE_BASE*2, Personnage.MANA_DE_BASE*2, 100);
    }
}
