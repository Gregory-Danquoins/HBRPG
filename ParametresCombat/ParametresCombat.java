package ParametresCombat;

public abstract class ParametresCombat {

    // Les dégats varient avec un ratio entre 0.8 et 1  , ici 0.95 déclanchera un cout avec effet secondaire
    public static final Double RATIO_COUP_CRITIQUE = 0.95;

    // Active ou pas la régénération aprés chaque combat 
    public static final boolean RETABLISSEMENT = false;

    // Déclenche le suicide explosif du mauvais perdant
    public static final boolean FURIE = false;

    // Nombre d'ennemis par partie 
    public static final int TOTAL_ENNEMIS = 10;

}
