package LOGIK.MODEL;

import LOGIK.GEOMETRY.Punkt;
import LOGIK.GEOMETRY.Rechteck;
import RENDER.Display.DisplayManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
public class Game 
{  
    ArrayList<ArrayList<Rechteck>> rechteckAL1 = new ArrayList();
    ArrayList<ArrayList<Rechteck>> rechteckAL2 = new ArrayList();
    Rechteck rechteck = new Rechteck();
    GameField gf = new GameField();
    Rules rule = new Rules();
    public Game() 
    {
        DisplayManager.createDisplay();

        Inputs.initInputs();
    }
    
    public void start()
    {   
        int breiteHoehe = 10; // breiteHoehe > 0
        int margin = 10; // margin > 0
        
        rechteckAL1 = gf.berechneFeldGroeße(rechteckAL1, breiteHoehe, margin);
        rechteckAL2 = gf.berechneFeldGroeße(rechteckAL2, breiteHoehe , margin);
        
        int seed = 450; // 1 - 1000
        rule.initRandomStartPoulation(rechteckAL1, seed);
        rule.initRandomStartPoulation(rechteckAL2, seed);
        
        // main game loop starten
        this.run();
    }
    
    public void ende()
    {        
        // game beenden und aufräumen
        this.closeGame();          
    }
    
    private void run()
    {
        int count = 0;
        // ab hier die grosse endlos game schleife 
        while (!Display.isCloseRequested()) 
        {
            // Exit game on Ecp Button Click
            if( Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) )
                break;
            ///////////////////////////////////////////
            // vor dem Zeichnen des nächsten Frames
            // löschen wir alle was vorher da war
            rule.checkNeighbour(rechteckAL1, rechteckAL2);
            gf.copyAR(rechteckAL2, rechteckAL1);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            gf.showField(rechteckAL1);
            DisplayManager.updateDispaly();
        }
    }
    
    private void closeGame()
    {         
        DisplayManager.closeDisplay();        
    }    

    private Punkt Punkt(int i, int i0, int i1)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

