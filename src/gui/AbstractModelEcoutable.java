package gui;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public abstract class AbstractModelEcoutable {

     // Liste des differentes vue    
     private ArrayList<EcouteurModel>ecouteurs;
    public AbstractModelEcoutable()
    {
        ecouteurs=new ArrayList<>();
    }

    public void ajoutEcouteur(EcouteurModel e)
    {
        ecouteurs.add(e);
    }

    public void retraitEcouteur(EcouteurModel e)
    {
        ecouteurs.remove(e);
    }

    protected void MiseAjourAffichage()
    {
        for(EcouteurModel e : ecouteurs)
        {
            e.NouvelleAffichage(this);
        }
    }


}