package personnages;

import java.util.Arrays;
import java.util.List;

import factions.Ennemi;
import specialisations.Feu;

public class Gobelin extends Ennemi{

        public static final List<String> NOMS_DISPONIBLES = Arrays.asList("Gobelin du tréfond","Gobelin purulant","Gobelin des marais");


    public Gobelin(String nom) {
        super(nom, new Feu(), Personnage.PV_DE_BASE, Personnage.ATTAQUE_DE_BASE, Personnage.DEFENSE_DE_BASE, Personnage.MANA_DE_BASE*2, 50);
    }
}
