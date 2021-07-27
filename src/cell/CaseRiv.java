package cell;
import games.*;
import cavalier.*;
import java.util.*;
import java.awt.*;


public class CaseRiv extends Case {

    public CaseRiv()
    {
    
    }


    @Override
    public void Effetcase(int valeurTirage,Cavalier c1,Cavalier c2,Position P)
    {
        if(valeurTirage%2==0)
        {
            super.executeDe(valeurTirage,c1,c2,P);
        }
        
        super.ReturnDepart(c1,c2);

    }

    @Override
    public String getTypeCase()
    {
        return "sur une case rivière ";
    }
    @Override
    public String toString()
    {
        return "~";
    }
}