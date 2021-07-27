package cell;
import games.*;
import cavalier.*;
import java.util.*;
import java.awt.*;


public class CaseArrive extends Case {

    public CaseArrive()
    {
    
        
    }

    
    @Override
    public void Effetcase(int valeurTirage,Cavalier c1,Cavalier c2,Position P)
    {
   
        System.out.println(getModifCase(c1));
    }
    

    @Override
    public String getTypeCase()
    {
        return "sur la case d'arrivé";
    }
    @Override
    public String toString()
    {
        return "*";
    }

}