package equipements;

public class GlaiveDuCauchemar extends Arme{

    public static final int BONUS_ATTAQUE = 15;
    public static final int BONUS_DEFENSE = 15;
    public static final int BONUS_MANA = 5;
    public static final String NOM = "Glaive du cauchemar";


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
