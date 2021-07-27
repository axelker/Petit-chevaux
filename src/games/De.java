package games;
import java.util.*;
import java.awt.*;


public class De {
    private int ValDe=-1;
    public De()
    {
        
    }
    public void setValDe()
    {
        this.ValDe=TirageDe();
    }
    public int getValDe()
    {
        return this.ValDe;
    }
    public int TirageDe()
    {
        Random r = new Random();
        int nombre=r.nextInt(7);
        return nombre;
    }

}