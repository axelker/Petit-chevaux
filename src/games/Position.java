package games;



public class Position {

    private int hauteur;
    private int longeur;

    public Position(int l,int h)
    {
        this.hauteur=h;
        this.longeur=l;
    }



    public int getLongueur()
    {
        return this.longeur;
    }

    public int getHauteur()
    {
        return this.hauteur;
    }



 ////Convertis un entier en une ligne de la grille //////
    public int Ligne(int place)
    {
        int ligne=0;int i=0;int debut=0;
        int fin=getLongueur();
        // incrémenter les lignes de 0 jusqu'a 10 
        while(i!=getHauteur())
        {   
            // Tester si la valeur de place est entre deux valeurs 
            if(place>=debut && place<fin)
            {
                ligne=i;
                return ligne;
            }
            i++;
            debut+=getLongueur();
            fin+=getLongueur();

        }
        return ligne;    
    }

         

    public int Colonne(int place)
    {
        int colonne=0;
        
        return colonne = place%getLongueur();

    }

    public int Place(int ligne,int colonne)
    {
        int place=(ligne*getLongueur())+colonne;
        return place;
        
    }

}