package MoteurdeJeu;

import java.util.List;
import java.util.Scanner;

import equipements.Potion;
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
                
            joueur.getNom() +" => PV: "+ joueur.getPv() + "| Mana : " +joueur.getMana() +"| XP: "+joueur.getXp()+"| Etat: "+ joueur.getEtat() + "| Potions: "+ joueur.getPotions().size()+
            "\n"+ cible.getNom()+" => PV: "+ cible.getPv()+ "| Mana : " +cible.getMana() +"| XP: "+cible.getXp()+"| Etat: "+ cible.getEtat() + "| Potions: "+ joueur.getPotions().size()+
            "\n___________________________________________________\n"+
            "\n\n"+joueur.getNom()+" choisis une action : "+
            "\n 1. Attaquer"+
            "\n 2. Utilser le pouvoir " + joueur.getSpecialisation().getPouvoirs().get(0)+
            "\n 3. Utiliser une potion");

            System.out.print("Votre choix (1-3) : ");

            choix = scanner.nextInt();
            
        }

        try {
                switch (choix) {
            case 1:
                joueur.attaquer(cible);
                break;
            case 2:
                joueur.lancerPouvoir(cible, 1);
                break;
            case 3:
                 afficherMenuPotion(joueur,cible);
                break;
            default:
                break;
        }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            getActionDuJoueur(joueur, cible);

        }

        
    }

    private void afficherMenuPotion (Personnage joueur, Personnage cible) {

        List<Potion> potionsDisponibles = joueur.getPotions();

        if (potionsDisponibles.isEmpty()) {
            System.out.println("Aucune potion disponible !");
            getActionDuJoueur(joueur, cible);
        }

        System.out.println("Potions disponibles :");
        for (int i = 0; i < potionsDisponibles.size(); i++) {
            Potion p = potionsDisponibles.get(i);
            System.out.println((i + 1) + ". " + p.getNom());
        }


        System.out.println("Choisissez une potion (entrez le numéro) :");

        Scanner scanner = new Scanner(System.in);
        int choix = -1;

        // Boucle de validation pour éviter les mauvaises saisies
        while (choix < 1 || choix > potionsDisponibles.size()) {
            try {
                System.out.print("> ");
                choix = scanner.nextInt();
                if (choix < 1 || choix > potionsDisponibles.size()) {
                    System.out.println("Choix invalide, veuillez réessayer.");
                }
            } catch (Exception e) {
                System.out.println("Entrée invalide, veuillez entrer un numéro.");
                scanner.nextLine(); // on consomme l'entrée incorrecte
            }
        }

        Potion potionChoisie = potionsDisponibles.get(choix - 1);
        potionChoisie.getEffect(joueur);
        System.out.println("Vous avez choisi : " + potionChoisie.getNom());
            getActionDuJoueur(joueur, cible);



        
        
    }

    
}