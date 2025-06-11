package personnages;

import equipements.Arme;
import equipements.Potion;
import equipements.PotionDeVie;
import equipements.PotionEtat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import specialisations.Specialisation;



public abstract class Personnage {

    public final static String[] ETATS  = {
        "normal",
        "gelé",
        "en feu",
        "furie"
    };
    
    private final Random random = new Random();
    public static final int ATTAQUE_DE_BASE=10;
    public static final int DEFENSE_DE_BASE=5;
    public static final int MANA_DE_BASE=10;
    public static final int PV_DE_BASE=20;

    private ArrayList<Potion> potions = new ArrayList<>();
    private Specialisation specialisation;
    private Arme arme;
    private int compteurEtat = 0;
    private int degatsRececifs = 0;
    private String nom;
    private int pvDedepart;    
    private int attaqueDeDepart;
    private int defenseDeDepart;
    private int manaDeDepart;
    private int pv;    
    private int attaque;
    private int defense;
    private int mana;
    private int xp=0;
    private int etat = 0;


    public Personnage(String nom, Specialisation specialisation, int pv, int attaque, int defense, int mana, int xp){
        this.nom = nom;
        this.specialisation = specialisation;
        this.attaqueDeDepart = attaque;
        this.defenseDeDepart = defense;
        this.manaDeDepart = mana;
        this.pvDedepart = pv;
        this.augmenterXp(xp);

    }

     // L'attaque et la défence sont modulé par la racine carrée des xp pour atténué l'impact d'un xp au fil de la progression
    public void augmenterXp(int xp){
        this.xp = this.xp + xp;
        this.attaque = this.attaqueDeDepart + (int) Math.sqrt(this.xp);
        this.defense = this.defenseDeDepart + (int) Math.sqrt(this.xp);
        this.pv = this.pvDedepart + (int) Math.sqrt(this.xp);
        this.mana = this.manaDeDepart + (int) Math.sqrt(this.xp);
    }

    // Les degats envoyés avec une variation aleatoire de 20%, le cout en mana est proportionnel a la puissance de l'attaque
    public void attaquer(Personnage cible){
        int degats = aleaDegats(attaque);
        cible.prendreDegats(degats);
    }

    /*Le jouveur choisis un pouvoir disponible dans un menu, 
    le pouvoir correspondant renvois le montant de degat a infliger*/
    public void lancerPouvoir(Personnage cible, int pouvoir ){

         int degats = aleaDegats(specialisation.lancerPouvoir(pouvoir)) ;
         mana= mana - degats/2;

        cible.prendreDegats(degats);

        /*Si l'attaque' a infliger les degats maximum , la cible subira également des effets secondaires
         en fonction de la specialité au tour suivant*/
        if(degats > attaque*0.90){
            infilgerEffetsSecondaire(cible, degats);   
        } 

        /*
        Si les degats infligés sont strictement égaux au pv restant,
        la cible se fait exploser et emporte l'adversaire dans la mort
         */ 
        if(degats == cible.getPv()){
            cible.setEtat("furie");
            setPv(0);
            cible.setPv(0);
            return;
        }        
        
    }

    private void utiliserPotion(Potion potion){
        potion.getEffect(this);
    }


    private void infilgerEffetsSecondaire(Personnage cible, int degats){

        if (specialisation.getCategorie().equals("GLACE")) {
            cible.setEtat(Personnage.ETATS[1]);
            cible.setDegatsRececifs(0);
            cible.setCompteurEtat(1);
        }
        if (specialisation.getCategorie().equals("FEU")) {
            cible.setEtat(Personnage.ETATS[2]);
            cible.setDegatsRececifs(degats/20);
            cible.setCompteurEtat(3);
        }
        if (specialisation.getCategorie().equals("FURTIF")) {

            Potion potion = cible.potions.get(0);
            potions.add(potion);
            cible.potions.remove(potion);
            System.out.println(getNom() + " vient de voler "+ potion.getNOM() );
        }
        
    }

    public void prendreDegats(int degats){
        int totalDegats = degats - degats/defense;

        if(getCompteurEtat() > 0){
          totalDegats =  totalDegats + getDegatsRececifs();
          setCompteurEtat(getCompteurEtat()-1);
        }


        pv = pv - totalDegats ;
    }

    public int getPvDedepart() {
        return this.pvDedepart;
    }

    public void setPvDedepart(int pvDedepart) {
        this.pvDedepart = pvDedepart;
    }

    public int getAttaqueDeDepart() {
        return this.attaqueDeDepart;
    }

    public void setAttaqueDeDepart(int attaqueDeDepart) {
        this.attaqueDeDepart = attaqueDeDepart;
    }

    public int getDefenseDeDepart() {
        return this.defenseDeDepart;
    }

    public void setDefenseDeDepart(int defenseDeDepart) {
        this.defenseDeDepart = defenseDeDepart;
    }

    public int getManaDeDepart() {
        return this.manaDeDepart;
    }

    public void setManaDeDepart(int manaDeDepart) {
        this.manaDeDepart = manaDeDepart;
    }

     public Random getRandom() {
        return this.random;
    }

    public ArrayList<Potion> getPotions() {
        return this.potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public Arme getArme() {
        return this.arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public int getXp() {
        return this.xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPv(){
        return pv;
    }

    // Apporte une variation aux degats entre 80 et 100%
    private int aleaDegats(int degats){
        double totalDegats = ( 0.8 + (1.0 - 0.8) * random.nextDouble() * degats);
    return (int) totalDegats;
    
    }

    // Modifie l'etat
    public void setEtat(String etat){
        this.etat = Arrays.asList(ETATS).indexOf(etat); 
    }

    public String getEtat(){
        return ETATS[etat];
    }
    
    public boolean estVivant(){
        return pv > 0;
    }

    public int getCompteurEtat() {
        return compteurEtat;
    }

    public void setCompteurEtat(int compteur) {
        this.compteurEtat = compteur;

        if(getCompteurEtat() < 1){
            this.compteurEtat = 0;
            this.etat = 0;
        }
    }

    public int getDegatsRececifs() {
        return degatsRececifs;
    }

    public void setDegatsRececifs(int degatsRececifs) {
        this.degatsRececifs = degatsRececifs;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Specialisation getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(Specialisation specialisation) {
        this.specialisation = specialisation;
    }



}
