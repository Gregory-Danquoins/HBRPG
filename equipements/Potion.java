package equipements;

import personnages.Personnage;

public abstract class Potion {

    public abstract String getNom();
    
    public abstract void getEffect(Personnage cible);
   
}
