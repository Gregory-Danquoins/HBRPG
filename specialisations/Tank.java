package specialisations;

import personnages.Personnage;

public class Tank extends Specialisation{

    final private String categorie ="TANK";

    public final static String[] pouvoirs = {
        "excalibur"
    };

    @Override
    public int lancerPouvoir(int pouvoir) {
        return switch (pouvoir) {
            case 0 -> lancerExcalibur();
            default -> 0;
        };
    }

    public String donnerCategorie(){
        return  categorie;
    }

    private int lancerExcalibur(){
        return Personnage.ATTAQUE_DE_BASE*2;
    }
   
}
