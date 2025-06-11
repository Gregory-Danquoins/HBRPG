package factions;

import personnages.Personnage;
import specialisations.Feu;
import specialisations.Specialisation;

public class Ennemi extends Personnage{

    public Ennemi(String nom, Specialisation specialisation, int pv, int attaque, int defense, int mana) {
        super(nom, specialisation, pv, attaque, defense, mana);
    }
    
}
