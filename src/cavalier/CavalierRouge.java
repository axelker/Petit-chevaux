package cavalier;
import games.*;
import java.util.*;
import java.awt.*;


public class CavalierRouge extends Cavalier
{
    public CavalierRouge(Position p,int x,int y,String nameCase)
    {
        super(p,x,y,nameCase);
    }


   
    public String getTypeCavalier()
    {
        return "ROUGE";
    }

     public void InitListeChemin(int longueur)
    {
        //Ajout case allant a Droite
        for(int j=1;j<longueur-1;j++)
        {
            super.setListe(super.getP().Place(1,j));
            
        }
        //Ajout bas 
        
        super.setListe(super.getP().Place(3,longueur-2));

        //Ajout gauche 
        for(int j=longueur-2;j>0;j--)
        {
            super.setListe(super.getP().Place(5,j));
        }
        //Haut jusqua objectif 
        if(longueur%2==0)
        {
            for(int j=1;j<(longueur/2)-2;j++)
            {
                super.setListe(super.getP().Place(3,j));
            }
        }
        else {
            for(int j=1;j<=(longueur/2)-2;j++)
            {
                super.setListe(super.getP().Place(3,j));
            }
        }
            
    }
    
    @Override
    public String toString()
    {
        return "R";
    }

}