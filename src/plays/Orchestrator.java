package plays;
import games.*;
import gui.*;
import cell.*;
import cavalier.*;
import java.util.*;


public class Orchestrator {

    public Orchestrator()
    {

    }

    //Saisie longueur plateau
    public int saisieLongueur()
    {
         
        Scanner scanner=new Scanner(System.in);
        System.out.println("Saisir la longueur du plateau (Supérieur à 10 !) : ");
        int longueur = scanner.nextInt();
        while(longueur<10)
        {
            longueur=saisieLongueur();
        }
        return longueur;
    }
    //Execution du jeu 
    public void executionGame()
    {
        De de= new De();
        //Saisir longueur 
        int longueur = saisieLongueur();
        Plateau p = new Plateau(longueur);
        p.Initalise();
        PlateauGui gui = new PlateauGui(p);
        System.out.println("Plateau Initialisé : ");
        System.out.println(p.AffichagePlateau());

    }
}