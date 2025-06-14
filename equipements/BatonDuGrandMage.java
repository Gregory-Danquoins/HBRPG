package equipements;

public class BatonDuGrandMage extends Arme{

    public static final int BONUS_ATTAQUE = 5;
    public static final int BONUS_DEFENSE = 5;
    public static final int BONUS_MANA = 15;
    public static final String NOM = "Baton du grand mage";


    @Override
    public int getBonnusAttaque() {
        return BONUS_ATTAQUE;
    }
    @Override
    public int getBonnusDefense() {
        return BONUS_DEFENSE;
    }
    @Override
    public int getBonnusMana() {
        return BONUS_MANA;
    }

    @Override
    public String getNom() {
        return NOM;
    }
    


}
