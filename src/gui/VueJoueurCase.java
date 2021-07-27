package gui;
import games.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class VueJoueurCase extends JPanel implements EcouteurModel
{

    private Plateau P;
    private JLabel J;
    public VueJoueurCase(Plateau P)
    {
        this.P=P;
        P.ajoutEcouteur(this);
        setPreferredSize(new Dimension(50,30));
        J = new JLabel(P.CasePositionJoueur());
        this.add(J,BorderLayout.NORTH);
        
    }


@Override
public void NouvelleAffichage(Object source)
{
    //Modification Affichage des valeurs des cases joueurs 
    J.setText(P.CasePositionJoueur());
}

}