package gui;
import games.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class VueJoueurCourrant extends JPanel implements EcouteurModel
{

    private Plateau P;
    private JButton rouleDe;
    private JLabel J;
    private De de;

    public VueJoueurCourrant(Plateau P,JButton B,De d)
    {
        this.P=P;
        this.rouleDe=B;
        this.de=d;
        P.ajoutEcouteur(this);
        // Taille
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //Placement du boutons et affichage cavalier joue 
        c.gridx =0;
        c.gridy=1;
        J = new JLabel("");
        this.add(J,c);
        c.gridx =0;
        c.gridy=2;
        this.add(rouleDe,c);
    }


@Override
public void NouvelleAffichage(Object source)
{
    
    
    //Modifie le texte mentionnant l'état des joueurs 
    J.setText(P.AfficheJoueurCourrant());
    
}

}