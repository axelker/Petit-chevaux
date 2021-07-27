package cavalier;
import games.*;
import java.util.*;
import java.awt.*;


public class CavalierBleu extends Cavalier
{

    public CavalierBleu(Position p,int x,int y,String nameCase)
    {
        super(p,x,y,nameCase);
    }


    public String getTypeCavalier()
    {
        return "BLEU";
    }
     
    public void InitListeChemin(int longueur)
    {
        //Ajout gauche 
        for(int j=longueur-2;j>0;j--)
        {
            super.setListe(super.getP().Place(5,j));
        }

        //Ajout Haut 
        super.setListe(super.getP().Place(3,1));

        //Ajout case allant a Droite
        for(int j=1;j<longueur-1;j++)
        {
            super.setListe(super.getP().Place(1,j));
        }

        //Ajout jusqu'a arrive 
        for(int j=longueur-2;j>=(longueur/2)+2;j--)
        {
            super.setListe(super.getP().Place(3,j));
        }

    }
    @Override
    public String toString()
    {
        return "B";
    }

   
}