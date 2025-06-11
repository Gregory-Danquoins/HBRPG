package MoteurdeJeu;

import personnages.Personnage;

public class ResultatCombat {

    private Personnage vainqueur=null;
    private Personnage perdant=null;
    private Personnage mauvaisPerdant=null;

    public void setVainqueur(Personnage p){
        this.vainqueur = p;
    }

    public Personnage getVainqueur(){
        return vainqueur;
    }

    public void setPerdant(Personnage Perdant) {
        this.perdant = Perdant;
    }

    public Personnage getPerdant() {
        return perdant;
    }

    public void setMauvaisPerdant(Personnage mauvaisPerdant) {
        this.mauvaisPerdant = mauvaisPerdant;
    }

    public Personnage getMauvaisPerdant() {
        return mauvaisPerdant;
    }

    

    


   


    


}
