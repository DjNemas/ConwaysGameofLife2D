package LOGIK.MODEL;

import LOGIK.GEOMETRY.Rechteck;
import java.util.ArrayList;
import org.lwjgl.opengl.Display;

public class GameField
{
    public ArrayList<ArrayList<Rechteck>> berechneFeldGroeße(ArrayList<ArrayList<Rechteck>> rechteck, int rechteckBreiteHoeheInPix, int marginInPix)
    {
        int countObj = 0;
        int countAL = 0;
        
        for (int i = 4; i <= Display.getWidth()-rechteckBreiteHoeheInPix; i+= (rechteckBreiteHoeheInPix+marginInPix))
        {   
            rechteck.add(new ArrayList<Rechteck>());
            for (int j = 4; j <= Display.getHeight()-rechteckBreiteHoeheInPix; j+= (rechteckBreiteHoeheInPix+marginInPix))
            {           
                rechteck.get(countAL).add(new Rechteck());
                rechteck.get(countAL).get(countObj).set_Pos_Top_Left_in_pix(i, j, rechteckBreiteHoeheInPix, rechteckBreiteHoeheInPix);
                
                countObj++;
            }  
            countObj=0;
            countAL++;
        }
        return rechteck;
    }
    
    public void copyAR(ArrayList<ArrayList<Rechteck>> rechteckFrom, ArrayList<ArrayList<Rechteck>> rechteckTo)
    {
       for (int i = 0; i < rechteckFrom.size(); i++)
            {
                for (int j = 0; j < rechteckFrom.get(i).size(); j++)
                {
                    rechteckTo.get(i).get(j).color = rechteckFrom.get(i).get(j).color;
                    rechteckTo.get(i).get(j).alive = rechteckFrom.get(i).get(j).alive;
                }

            } 
        
    }
    
    public void showField(ArrayList<ArrayList<Rechteck>> rechteck)
    {
        for (int i = 0; i < rechteck.size(); i++)
            {
                for (int j = 0; j < rechteck.get(i).size(); j++)
                {
                    
                    if (i == 0 || j == 0 || i == rechteck.size()-1 || j == rechteck.get(i).size()-1)
                    {
                        rainbowBorder(rechteck, i , j);
                    }
                    
                    rechteck.get(i).get(j).zeichne(true);
                }
            }
    }
    
    public void rainbowBorder(ArrayList<ArrayList<Rechteck>> rechteck, int i, int j)
    {
        if (rechteck.get(i).get(j).color.x == 0.8f && rechteck.get(i).get(j).color.z == 0.5f)
        {
            rechteck.get(i).get(j).setColor(0.8f, 0.5f, 0);
        }
        else if (rechteck.get(i).get(j).color.x == 0.8f && rechteck.get(i).get(j).color.y == 0.5f)
        {
            rechteck.get(i).get(j).setColor(0, 0.8f, 0.5f);
        }
        else if ( rechteck.get(i).get(j).color.y == 0.8f && rechteck.get(i).get(j).color.z == 0.5f)
        {
            rechteck.get(i).get(j).setColor(0.8f, 0, 0.5f);
        }
    }
}
