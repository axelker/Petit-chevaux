package gui;
import games.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;



public class PlateauGui extends JFrame implements ActionListener {
    private Plateau P;
    private De de = new De();
    VuePlateau vueP ;
    JButton rouleDe = new JButton("Rouler le dé");
    public PlateauGui(Plateau P)
    {
        super("Petits-chevaux");
        this.P=P;
        //Taille fenetre et quitter fenetre quand cliquer 
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Centrer la fentre 
        this.setLocationRelativeTo(null);
        JPanel cp=(JPanel) this.getContentPane();
        cp.setLayout(new BorderLayout());

        //Ajout des vues 
        vueP = new VuePlateau(P,de);
        cp.add(vueP,BorderLayout.CENTER);
        rouleDe.addActionListener(this);
        VueJoueurCourrant vueJ = new VueJoueurCourrant(P,rouleDe,de);
        cp.add(vueJ,BorderLayout.NORTH);
        cp.add(new VueJoueurCase(P),BorderLayout.SOUTH);
        
        

        this.setVisible(true);
    }

    //Permet d'executer le rouler du dé lorsque clique sur bouton 
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(P.isOver()!=true)
        {
            //Tirage du dé et joué le nombre tiré 
            int numTire = de.TirageDe();
            de.setValDe();
            P.play(de.getValDe());

            //SI partie terminer après l'execution du dé desactiver le bouton 
            if(P.isOver())
            {
                rouleDe.setEnabled(false);
            }
        }

        
    }

    
}