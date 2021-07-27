package games;
import cell.*;
import java.util.*;
import java.awt.*;

/////////////// TIRAGE POSITION CASE ALEATOIREMENT ///////
public class Aleatoire{
    private Random r = new Random();
    private int hauteur;
    private int longueur;
    public Aleatoire(int h,int l)
    {
        this.hauteur=h;
        this.longueur=l;
    }

    public int getHauteur()
    {
        return this.hauteur;
    }
    public int getLongueur()
    {
        return this.longueur;
    }
    public int LigneAlea()
    {
        int ligne = Alea(getHauteur());
        return ligne;
    }
    public int ColonneAlea()
    {
        int colonne = Alea(getLongueur());
        return colonne;
    }
    public void TestCasePiege(Case c,int colonne,int ligne,Case[][] Board)
    {
        while(!Board[ligne][colonne].toString().equals("."))
        {
            ligne=LigneAlea();
            colonne=ColonneAlea();
        }
        Board[ligne][colonne]=c;
    }

    public int Alea(int valeur)
    {
        Random r = new Random();
        int nombre=r.nextInt(valeur);
        return nombre;
    }

   
    

}