package moteurdeJeu;

import factions.Ennemi;
import factions.Hero;
import parametresCombat.ParametresCombat;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import personnages.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MoteurDeJeu {
        
    private static final ArrayList<Ennemi> ennemis = new ArrayList<>();
    private Hero hero;
    private static final Scanner scanner = new Scanner(System.in);
    private static final MoteurDeCombat moteurDeCombat= new MoteurDeCombat();
    private final Random random = new Random();
    private int ennemisVaincus=0;


   
    public void lancerJeu(){
        creerEnnemis();
        creerHero();
        lancerPartie();

    }

    private Ennemi genererEnnemiAleatoire() {
    
        // Étape 1 : choisir une classe aléatoire
        List<String> classesDisponibles = Ennemi.CLASSES_DISPONIBLES;
        String nomClasse = classesDisponibles.get(random.nextInt(classesDisponibles.size()));

        try {
            //  obtenir la classe 
            Class<?> clazz = Class.forName("personnages." + nomClasse);

            // récuper NOMS_DISPONIBLES de la classe
            Field nomsDisponiblesField = clazz.getDeclaredField("NOMS_DISPONIBLES");
            List<String> nomsDisponibles = (List<String>) nomsDisponiblesField.get(null);

            // choisir un nom aléatoire
            String nomAleatoire = nomsDisponibles.get(random.nextInt(nomsDisponibles.size()));

            // créer l'ennemi
            Ennemi ennemi = (Ennemi) clazz.getDeclaredConstructor(String.class).newInstance(nomAleatoire);
            System.out.println("Un Ennemi vient de naître : " + ennemi.getClass().getSimpleName() + " nommé " + nomAleatoire);
            return ennemi;

        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException |
                 NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void creerEnnemis() {

        for (int i = 0; i < ParametresCombat.TOTAL_ENNEMIS+1; i++) {
          ennemis.add(genererEnnemiAleatoire());
        }
         
        System.out.println(ParametresCombat.TOTAL_ENNEMIS+" ennemis ont été créés.");
    }


    private void creerHero() {

            System.out.println("\n ####  Création du personnage  #### \n");
            for (int i = 0; i < Hero.CLASSES_DISPONIBLES.size(); i++) {
                System.out.println((i + 1) + " - " + Hero.CLASSES_DISPONIBLES.get(i));
            }

            int nombreDeClasse = Hero.CLASSES_DISPONIBLES.size();
            int indexClasse = -1;

            while (indexClasse < 0 || indexClasse >= nombreDeClasse) {
                System.out.print("\n Choisis ton héro (1-" + nombreDeClasse + ") : ");
                
                if (scanner.hasNextInt()) {
                    indexClasse = scanner.nextInt() - 1;
                    scanner.nextLine(); 
                } else {
                    System.out.println("Veuillez entrer un nombre entier valide !");
                    scanner.nextLine(); 
                }


            }

            System.out.print("\n Nom de ton héro : ");
            String nomHero = scanner.nextLine();
            String nomClasse = Hero.CLASSES_DISPONIBLES.get(indexClasse);

        // Genere un nom de classe dynamiquement basé sur un indexClasse valide d'utilisateur 
        try {
            Class<? extends Hero> clazz = (Class<? extends Hero>) Class.forName("personnages." + nomClasse);
            hero = clazz.getDeclaredConstructor(String.class).newInstance(nomHero);
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException 
                    | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace(); 
                }
            System.out.println("Un hero vient de naître  : " + hero.getClass().getSimpleName() + " nommé " + nomHero);    
        }
    

    private void lancerPartie(){
        System.out.println("\n ########### LE COMBAT COMMENCE ##########\n");

        for (Personnage ennemi : ennemis) {
            ResultatCombat result =   moteurDeCombat.demmareCombat(hero, ennemi);

            if(result.getMauvaisPerdant() != null){
                    System.out.println(result.getMauvaisPerdant().getNom() + " se fait exploser avant de mourrir et emporte " + result.getVainqueur().getNom() + " avec lui dans la mort" );
                    System.out.println("GAME OVER");
                    break;
            } else {
                // Le vainqueur récupère 20% des xp du perdant 
                result.getVainqueur().augmenterXp(result.getPerdant().getXp()/5, ParametresCombat.RETABLISSEMENT);
                System.out.println(
                "\n###### " +result.getVainqueur().getNom() + " a vaincu " + result.getPerdant().getNom() + " ######\n"
                );
                
                if(result.getVainqueur() != hero){
                    System.out.println("GAME OVER");
                    break;
                }
                System.out.print(" ###############  NOUVEL ADVERSAIRE  ################## \n");
                ennemisVaincus+=1;
            }
        }

        System.out.println(hero.getNom()+ " a vaincu "+ ennemisVaincus + " ennemis");
        sauvegarderResultat(ennemisVaincus);
    }

    private void sauvegarderResultat(int ennemisVaincus) {
        String nomFichier = "resultats.txt";

        try (FileWriter fw = new FileWriter(nomFichier, true); 
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println("Ennemis vaincus par " + hero.getNom()+ ": " + ennemisVaincus);

            System.out.println("Résultat sauvegardé dans " + nomFichier);

        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
        
}

    
   

    

