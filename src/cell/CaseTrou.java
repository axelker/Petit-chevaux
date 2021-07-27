package cell;
import java.util.*;
import java.awt.*;
import games.*;
import cavalier.*;


public class CaseTrou extends Case {
    private int cmpt = 4;
    public CaseTrou()
    {
        
    }
    

    public int getCompteurTrou()
    {
        return this.cmpt;
    }
    public void decrCmpt()
    {
        this.cmpt =this.cmpt-1;
    }
    public void setCompteurTrou(int valeur)
    {
        this.cmpt=valeur;
    }

    @Override
    public void Effetcase(int valeurTirage,Cavalier c1,Cavalier c2,Position P)
    {

        //Si cavalier sur case identique retour depart c2 et mettre le compteurtrou a 4
        if(super.CaseIdentique(c1,c2))
        {
            super.ReturnDepart(c1,c2);
            setCompteurTrou(4);
        } 
         
        if(getCompteurTrou()!=0)
        {
            //Decrementer compteur trou  
            decrCmpt();
                
        }
        if(getCompteurTrou()==0){
            super.executeDe(valeurTirage,c1,c2,P);
            //Mettre compteur trou à 4
            setCompteurTrou(4);

        }

        
            
    }

    @Override
    public String getTypeCase()
    {
        return "sur une case trou ";
    }
    @Override
    public String toString()
    {
        return "@";
    }
}