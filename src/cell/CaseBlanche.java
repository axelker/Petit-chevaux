package cell;
import games.*;
import cavalier.*;
import java.util.*;
import java.awt.*;


public class CaseBlanche extends Case{

    public CaseBlanche()
    {
       
        
    }

    @Override
    public void Effetcase(int valeurTirage,Cavalier c1,Cavalier c2,Position P)
    {
        System.out.println("Erreur ! " + getModifCase(c1));
    }

    
    @Override
    public String getTypeCase()
    {
        return "sur une case blanche";
    }
    @Override
    public String toString()
    {
        return " ";
    }
}