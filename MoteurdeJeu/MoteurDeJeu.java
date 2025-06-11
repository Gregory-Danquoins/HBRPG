package MoteurdeJeu;

import factions.Ennemi;
import factions.Hero;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;
import personnages.*;

public class MoteurDeJeu {
        
    private static final ArrayList<Ennemi> ennemis = new ArrayList<>();
    private Hero hero;
    private static final Scanner scanner = new Scanner(System.in);
    private static final MoteurDeCombat moteurDeCombat= new MoteurDeCombat();

   
    public void lancerJeu(){
        creerEnnemis();
        creerHero();
        lancerPartie();

    }


    public void creerEnnemis() {
   
        ennemis.add(new Gobelin("Gobelin des bois"));
        ennemis.add(new Gobelin("Gobelin des bois"));
        ennemis.add(new Dragon("Dragon Noir"));
        ennemis.add(new Troll("Troll des cavernes"));
        ennemis.add(new Gobelin("Gobelin farouche"));
        ennemis.add(new Troll("Troll des montagnes"));
        ennemis.add(new Gobelin("Gobelin sournois"));
        ennemis.add(new Dragon("Dragon Ancien"));
        ennemis.add(new Troll("Troll Berserker"));
        ennemis.add(new Gobelin("Gobelin chaman"));

        System.out.println("10 ennemis ont été créés.");
    }


    public void creerHero() {

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
                scanner.nextLine(); // consomme le reste de la ligne
            } else {
                System.out.println("Veuillez entrer un nombre entier valide !");
                scanner.nextLine(); // consomme l'entrée invalide
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
    

        public void lancerPartie(){
            System.out.println("\n ###### Le combat commence #####\n");

            for (Personnage ennemi : ennemis) {
                ResultatCombat result =   moteurDeCombat.demmareCombat(hero, ennemi);

                if(result.getMauvaisPerdant() != null){
                        System.out.println(result.getMauvaisPerdant().getNom() + " se fait exploser avant de mourrir et emporte " + result.getVainqueur().getNom() + " avec lui dans la mort" );
                        System.out.println("GAME OVER");
                        break;
                } else {
                    result.getVainqueur().augmenterXp(result.getPerdant().getXp()/5);
                    System.out.println(
                    "\n#### " +result.getVainqueur().getNom() + " a vaincu " + result.getPerdant().getNom() + " ###\n"+
                    " NOUVEL ADVERSAIRE \n"
                    );
                    
                    if(result.getVainqueur() != hero){
                        System.out.println("GAME OVER");
                        break;
                    }
                }
            }
        }
        
}

    
   

    

