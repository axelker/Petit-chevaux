package cell;
import games.*;
import cavalier.*;
import java.util.*;
import java.awt.*;



public abstract class Case implements Questionnable
{
    
    public Case()
    {
        
    }
    

    //Cavalier case même coordonée 
    public boolean CaseIdentique(Cavalier c1,Cavalier c2)
    {
        if(c1.getX()==c2.getX() && c1.getY()==c2.getY())
        {
            return true;
        }
        return false;
    }

    public void ReturnDepart(Cavalier c1,Cavalier c2)
    {
        if(CaseIdentique(c1,c2))
        {
            if(c2.toString().equals("B"))
            {
                c2.RetourDepart(c2.getEcurieX()-1,c2.getEcurieY());
            }

            if(c2.toString().equals("R"))
            {
                c2.RetourDepart(1,1);
            }
            c2.setCmptChemin(0);
        }
    }

    public void executeDe(int valeurTirage,Cavalier c1,Cavalier c2,Position P)
    {
        //Incrementer compteur de la liste 
        c1.IncrementeCmpt(valeurTirage);
        int compteur = c1.getCmptChemin();
        int coup = c1.getListeVal(compteur);
        //Modife coordonée joueur 
        c1.setX(P.Ligne(coup)); 
        c1.setY(P.Colonne(coup));
    }
    @Override
    public String getModifCase(Cavalier c)
    {
        return "** Le cavalier " + c.getTypeCavalier() + " est " + getTypeCase() +" **";
    }

    public abstract void Effetcase(int valeurTirage,Cavalier c1,Cavalier c2,Position P);
    
   
}