package games;
import gui.*;
import cavalier.*;
import cell.*;
import java.util.*;
import java.awt.*;

public class Plateau extends AbstractModelEcoutable {

    private Aleatoire A;
    private Position P;
    private Cavalier rouge;
    private Cavalier bleu;
 
    private Cavalier CavalierCourrant;
    //Constante 
    private final static int hauteurPlateau=7;
    //Permet d'ajouter les bords gauche droit du plateau
    private final static int Bord=2;
    private int longueurPlateau=Bord;

    //Plateau 
    private Case[][] Board;

    //Partie terminer 
    private boolean finish;

    public Plateau(int longueur)
    {
        this.longueurPlateau+=longueur;
        this.P=new Position(longueurPlateau,hauteurPlateau);
        this.rouge = new CavalierRouge(P,0,1,"dans l'écurie");
        this.bleu = new CavalierBleu(P,this.hauteurPlateau-1,this.longueurPlateau-2,"dans l'écurie");
        this.Board= new Case[this.hauteurPlateau][this.longueurPlateau];
        this.A=new Aleatoire(hauteurPlateau,longueurPlateau);
        this.CavalierCourrant=rouge;
        this.finish=false;
        
        
    }


    public int getLongueur()
    {
        return this.longueurPlateau;
    }
    
    public int getHauteur()
    {
        return this.hauteurPlateau;
    }
    public Cavalier getBleu()
    {
        return this.bleu;
    }
    public Cavalier getRouge()
    {
        return this.rouge;
    }

    public Cavalier getCavalierCourrant()
    {
        return this.CavalierCourrant;
    }
    public String getValBoard(int i,int j)
    {
        return this.Board[i][j].toString();
    }
    public void ChangeCavalierCourrant()
    {
        if(this.CavalierCourrant.equals(this.rouge))
        {
            this.CavalierCourrant=this.bleu;
        }
        else {
            this.CavalierCourrant=this.rouge;
        }
    }
    public Cavalier getCavalierNonCourrant()
    {
        if(getCavalierCourrant().equals(getBleu()))
        {
            return getRouge();
        }
        return getBleu();
    }
    public Position getPos()
    {
        return this.P;
    }

    public void Initalise()
    {
        
        // Remplissage du tableau par des cases neutre 
        for(int i=0;i<getHauteur();i++)
        {
            for(int j=0;j<getLongueur();j++)
            {
                Case neutre = new CaseLibre();
                Board[i][j] = neutre;
            }
        }


        //Remplissage case Blanche 
        for(int j=1;j<getLongueur()-1;j++)
        {   
            Case blanche = new CaseBlanche();
            Board[2][j] = blanche;
            Board[4][j]=blanche;
        }

        // Case de départ des cavalier 
        Case departRouge= new CaseDepart();
        Board[1][1]=departRouge;

        Case departBleu=new CaseDepart();
        Board[getHauteur()-2][getLongueur()-2] = departBleu;

        //Case arriver 

        //Selon longueur deplacer l'arriver du rouge 
        int colonneRouge;
        if(getLongueur()%2==1)
        {
            colonneRouge=P.Colonne((getLongueur()/2)-2);
        }
        else {
            colonneRouge=P.Colonne((getLongueur()/2)-3);
        }
        
        Case ArriveRouge = new CaseArrive();
        Board[3][colonneRouge] = ArriveRouge;

        int colonneBleu=P.Colonne((getLongueur()/2)+2);
        Case ArriveBleu = new CaseArrive();
        Board[3][colonneBleu] = ArriveBleu;

        //Case blanche entre arrivé 
        for(int j=colonneRouge+1;j<colonneBleu;j++)
        {
            Case blanche = new CaseBlanche();
            Board[3][j]=blanche;

        }
        //Bord écurie 
        for(int i=0;i<getLongueur();i++)
        {
            Case cote = new CaseCote();
            Board[0][i]=cote;
            Board[getHauteur()-1][i]=cote;
        }
        for(int i=0;i<getHauteur();i++)
        {
            Case cote = new CaseCote();
            Board[i][0]=cote;
            Board[i][getLongueur()-1]=cote;
        }

        //Case Trou Aléatoire 
        //Eviter case départ
        
        Case trou = new CaseTrou();
        A.TestCasePiege(trou,A.ColonneAlea(),A.LigneAlea(),Board);
        //Case rivière
        Case riv = new CaseRiv();
        A.TestCasePiege(riv,A.ColonneAlea(),A.LigneAlea(),Board);
        //Case Haie
        Case haie = new CaseHaie();
        A.TestCasePiege(haie,A.ColonneAlea(),A.LigneAlea(),Board);

               
        //Initialiser liste chemin 

        rouge.InitListeChemin(getLongueur());
        bleu.InitListeChemin(getLongueur());



    }
    //Execute la valeur du dé pour le cavalier courrant 
    public void play(int valeurTirage)
    {
        Cavalier courrant = getCavalierCourrant();
        Cavalier nonCourrant = getCavalierNonCourrant();
        Board[courrant.getX()][courrant.getY()].Effetcase(valeurTirage,courrant,nonCourrant,this.P);
        
        //Mise a jour nom des cases ou le joueur se situe 
        courrant.setname(this.Board[courrant.getX()][courrant.getY()].getTypeCase());
        nonCourrant.setname(this.Board[nonCourrant.getX()][nonCourrant.getY()].getTypeCase());
        
        //Si gagnant 
        if(this.Board[courrant.getX()][courrant.getY()].toString().equals("*"))
        {
            this.finish=true;
            
        }
        
        ChangeCavalierCourrant();
        MiseAjourAffichage();
        
    }
    //Affichage gagnant 
    public String winner(Cavalier courrant)
    {
        return "Le gagnant est le cavalier  "+ courrant.getTypeCavalier();
    }
   
    //Test si partie est terminer 
    public boolean isOver()
    {
        if(this.finish==true)
        {
            return true;
        }
        return false;
    }

    //Renvoi les cavaliers et leur case de positionnement actuelle 
    public String CasePositionJoueur()
    {
        String res="";
        res+=System.lineSeparator();
        res+=rouge.toString()+" "+ rouge.getTypeCavalier() + " "+ rouge.getnameCase() + "   " + bleu.toString() + " " + bleu.getTypeCavalier() +" " + bleu.getnameCase();
        res+=System.lineSeparator();
       return res;
    }
    //Renvoie le joueur effectuant le lancer de dé  
    public String AfficheJoueurCourrant()
    {
        if(isOver()==false)
        {
            return "Le cavalier de couleur " + getCavalierNonCourrant().getTypeCavalier() + " joue";
        }
        return winner(getCavalierNonCourrant());
    }

    //TEST LA POSITION D'UN CAVALIER 
    public boolean testPosCavalier(int i,int j,Cavalier c)
    {
        if(i==c.getX() && j==c.getY())
        {
            return true;
        }
        return false;
    }

    //Renvoi le plateau 
    public String AffichagePlateau()
    {
        String res="";
        res+=System.lineSeparator();
        res+=System.lineSeparator();
        for(int i=0;i<getHauteur();i++)
        {
            for(int j=0;j<getLongueur();j++)
            {
                if(testPosCavalier(i,j,rouge))
                {
                    res+=rouge.toString();
                }
                
                else if(testPosCavalier(i,j,bleu))
                {
                    res+=bleu.toString();
                }
                else {
                res+=this.Board[i][j].toString();
                }
                res+=" ";
            }
            res+=System.lineSeparator();
        }
        res+="____________________________________________________";
        res+=CasePositionJoueur();
        res+="____________________________________________________";
        return res;
    }

    
}