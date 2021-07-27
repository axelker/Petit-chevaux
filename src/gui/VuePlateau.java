package gui;
import games.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


public class VuePlateau extends JPanel implements EcouteurModel
{
    private De de;
    private Plateau P;
    private final static Color[] COULEUR = {Color.CYAN,Color.BLUE,Color.GRAY,Color.lightGray,Color.WHITE,Color.YELLOW,Color.PINK,Color.GREEN};
    private final static String [] StringCase = {"*","~","|","."," ","@","#","+"};
    public VuePlateau(Plateau P,De d)
    {
        this.P=P;
        this.de=d;
        P.ajoutEcouteur(this);
        // Taille
        this.setLayout(new GridLayout(P.getHauteur(),P.getLongueur()));
        ModifLabel();
        
    }
    
    //Text mentionnant le dé et les deux joueurs sur le plateau
    public void textLabel(int i,int k,JLabel lab)
    {
        //Centre text dans le label 
        lab.setHorizontalAlignment(JLabel.CENTER);
        lab.setVerticalAlignment(JLabel.CENTER);
        if(P.testPosCavalier(i,k,P.getBleu()))
        {
            lab.setText("B");
            
        }
        if(P.testPosCavalier(i,k,P.getRouge()))
        {
            lab.setText("R");
        }
        if(P.getHauteur()/2==i && P.getLongueur()/2-1==k)
        {
            lab.setText("Dé");
        }
        if(P.getHauteur()/2==i && P.getLongueur()/2==k && de.getValDe()!=-1)
        {
            lab.setText(""+de.getValDe());
        }
    }

    //Colorie le label selon le remplissage du plateau 
    public void Dessin(String c,JLabel lab)
    {
        lab.setOpaque(true);
        for(int i=0;i<8;i++)
        {
            if(c.equals(StringCase[i]))
            {
                lab.setBackground(COULEUR[i]);
            }
        }
        
        if(!c.equals("+"))
        {
             Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            lab.setBorder(border);
        }
    }
        
    //Modifie les labels 
    public void ModifLabel()
    {
        for(int i=0;i<P.getHauteur();i++)
        {   
            
            for(int k=0;k<P.getLongueur();k++)
            {
                JLabel lab = new JLabel();
                textLabel(i,k,lab);
                Dessin(P.getValBoard(i,k),lab);
                this.add(lab);
            }
        }
    }
       

    @Override
    public void NouvelleAffichage(Object source)
    {
        this.removeAll();
        ModifLabel();
        //Plateau AFFICHAGE terminal 
        System.out.println(P.AfficheJoueurCourrant() + " \nValeur du dé: " + de.getValDe() + P.AffichagePlateau());
    }
}