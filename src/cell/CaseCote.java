package cell;
import games.*;
import cavalier.*;
import java.util.*;
import java.awt.*;


public class CaseCote extends Case  {

    public CaseCote()
    {
        
    }


    @Override
    public void Effetcase(int valeurTirage,Cavalier c1,Cavalier c2,Position P)
    {
        if(valeurTirage==6)
        {
            if(c1.toString().equals("B"))
            {
                //Modife coordonée joueur 
                c1.setX(c1.getEcurieX()-1); 
                c1.setY(c1.getEcurieY());
            }
            else {
                c1.setX(c1.getEcurieX()+1); 
                c1.setY(1);
            }
            c1.setCmptChemin(0);
                
        }
        
        super.ReturnDepart(c1,c2);
    }

    @Override
    public String getTypeCase()
    {
        return "dans l'écurie ";
    }
    @Override
    public String toString()
    {
        return "+";
    }
}
