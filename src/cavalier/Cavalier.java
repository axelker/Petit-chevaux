package cavalier;
import games.*;
import java.util.*;
import java.awt.*;

public abstract class Cavalier {

    private ArrayList<Integer> listeChemin;
    private int x;
    private int y;
    private String nameCase;
    private Position P;
    private int cmptChemin=0;
    private int ecurieLigne;
    private int ecurieColonne;
    
    public Cavalier(Position p,int ligne,int colonne,String nameCase)
    {
        this.x=ligne;
        this.y=colonne;
        this.nameCase=nameCase;
        this.listeChemin= new ArrayList<Integer> ();
        this.P=p;
        this.ecurieLigne=ligne;
        this.ecurieColonne=colonne;

    }
    public Position getP()
    {
        return this.P;
    }
    public ArrayList<Integer> getListe()
    {
        return this.listeChemin;
    }
    public int getListeVal(int i)
    {
        return this.listeChemin.get(i);
    }
    public void setListe(int valeur)
    {
        this.listeChemin.add(valeur);
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public String getnameCase()
    {
        return this.nameCase;
    }
    public void setX(int x)
    {
        this.x=x;
    }
    public void setY(int y)
    {
        this.y=y;
    }
    public void setname(String name)
    {
        this.nameCase=name;
    }
    public int getCmptChemin()
    {
        return this.cmptChemin;
    }
    public void IncrementeCmpt(int valeur)
    {
        
        this.cmptChemin+=valeur;
        //TEST POUR NE PAS JOUER UN COUP INVALIDE 
        if(this.cmptChemin > this.listeChemin.size()-1)
        {
            this.cmptChemin=this.listeChemin.size()-1;
        }
    }
    public void setCmptChemin(int valeur)
    {
        this.cmptChemin=valeur;
    }
    public void RetourDepart(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public int getEcurieX()
    {
        return this.ecurieLigne;
    }
    public int getEcurieY()
    {
        return this.ecurieColonne;
    }
    public abstract String getTypeCavalier();
    public abstract void InitListeChemin(int longueur);
    
}