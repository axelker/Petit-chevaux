package cell;
import games.*;
import cavalier.*;
import java.util.*;
import java.awt.*;



public class CaseLibre extends Case {

    public CaseLibre()
    {
        
    }

    @Override
    public void Effetcase(int valeurTirage,Cavalier c1,Cavalier c2,Position P)
    {
        super.executeDe(valeurTirage,c1,c2,P);
        super.ReturnDepart(c1,c2);
    }
    
    @Override
    public String getTypeCase()
    {
        return "sur une case neutre ";
    }
    @Override
    public String toString()
    {
        return ".";
    }
}