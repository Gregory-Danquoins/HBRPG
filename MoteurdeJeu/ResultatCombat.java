package moteurdeJeu;

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

    public void setPerdant(Personnage perdant) {
        this.perdant = perdant;
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
