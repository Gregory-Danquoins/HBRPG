package factions;

import java.util.Arrays;
import java.util.List;
import personnages.Personnage;
import specialisations.Feu;
import specialisations.Specialisation;


public class Hero extends Personnage {

    public static final List<String> CLASSES_DISPONIBLES = Arrays.asList("Guerrier","Mage","Voleur");

   public Hero(String nom, Specialisation specialisation, int pv, int attaque, int defense, int mana) {
        super(nom, specialisation, pv, attaque, defense, mana);
    }

}
