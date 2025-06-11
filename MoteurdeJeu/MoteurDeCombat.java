package MoteurdeJeu;

import java.util.Scanner;
import personnages.Personnage;

public class MoteurDeCombat {

    private static final Scanner scanner = new Scanner(System.in);

    public ResultatCombat demmareCombat(Personnage p1, Personnage p2){

        while (p1.estVivant() && p2.estVivant()) {
            getActionDuJoueur(p1,p2);
  
            if (!p1.estVivant() || !p2.estVivant()) {
             break; 
            }
            getActionDuJoueur(p2,p1);
        }

        ResultatCombat result = new ResultatCombat();

        if(p1.estVivant()){
            result.setVainqueur(p1);
            result.setPerdant(p2);
            return result;
        } else if (p2.estVivant()){
            result.setVainqueur(p2);
            result.setPerdant(p1);
            return result;
        } else {
            // Si les deux joueurs sont a zero , c'est que le vaincu a explosé de rage et emporté le vainqueur dans la mort avec lui
            if(p1.getEtat().equals("furie")){
                result.setMauvaisPerdant(p1);
                result.setVainqueur(p2);
            } else {
                result.setMauvaisPerdant(p2);
                result.setVainqueur(p1);

            }
            return result;
        }

    }

    private void getActionDuJoueur(Personnage joueur, Personnage cible){
        int choix = 0;

        while (choix < 1 || choix > 3) {
            System.out.println(
                
            joueur.getNom() +" => pv: "+ joueur.getPv() + ", mana : " +joueur.getMana() +", xp: "+joueur.getXp()+", etat: "+ joueur.getEtat() +
            "\n"+ cible.getNom()+" => pv: "+ cible.getPv()+ ", mana : " +cible.getMana() +", xp: "+cible.getXp()+", etat: "+ cible.getEtat() +
            "\n___________________________________________________\n"+
            "\n\n"+joueur.getNom()+" choisis une action : "+
            "\n 1. Attaquer"+
            "\n 2. Utilser le pouvoir " + joueur.getSpecialisation().getPOUVOIRS().get(0)+
            "\n 3. Utiliser un objet");

            System.out.print("Votre choix (1-3) : ");

            choix = scanner.nextInt();
            
        }

        switch (choix) {
            case 1:
                joueur.attaquer(cible);
                break;
            case 2:
                joueur.lancerPouvoir(cible, 1);
                break;
            default:
                System.out.println("Choix invalide.");
                break;
        }

    }
}