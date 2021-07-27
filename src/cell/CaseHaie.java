package cell;
import games.*;
import cavalier.*;
import java.util.*;
import java.awt.*;


public class CaseHaie extends Case {
    public CaseHaie()
    {
        
    }
   



     @Override
    public void Effetcase(int valeurTirage,Cavalier c1,Cavalier c2,Position P)
    {
        if(valeurTirage%2==1)
        {
            super.executeDe(valeurTirage,c1,c2,P);
        }
       
        super.ReturnDepart(c1,c2);

    }
    @Override
    public String getTypeCase()
    {
        return "sur une case haie ";
    }
    @Override
    public String toString()
    {
        return "|";
    }
}