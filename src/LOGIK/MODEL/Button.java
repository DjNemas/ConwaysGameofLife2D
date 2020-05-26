package LOGIK.MODEL;

import LOGIK.GEOMETRY.Rechteck;
import RENDER.Display.DisplayManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.input.Mouse;

public class Button extends Rechteck
{
    public float pixel_von_links;
    public float pixel_von_oben;
    public float breite_in_pixeln;
    public float hoehe_in_pixeln;
    
    public boolean mouse_over_button = false;
    public boolean mouse_is_down = false;
    
    private String programm_pfad;
    
    
    public Button()
    {
        this.pixel_von_links  = 0;
        this.pixel_von_oben   = 0;
        this.breite_in_pixeln = 0;
        this.hoehe_in_pixeln  = 0;
    }
    
    public void set_Pos_Top_Left_in_proz( float top_proz , float left_proz , float width_proz , float height_proz )
    {
        // bekommt in prozent die obere linke ecke des button 
        // die Pixel coordinaten von oben und links im aktullen fenster berechnen
        // opengl Zeichnungs coordinaten berechnen
        float breite   = DisplayManager.WIDTH;
        float hoehe    = DisplayManager.HEIGHT;
        float aspec   = DisplayManager.ASPECT_RATIO;

        // pixel angaben 
        this.pixel_von_links  = Math.round( (left_proz   * 0.01f )  * breite );
        this.pixel_von_oben   = Math.round( (top_proz    * 0.01f )  * hoehe );
        this.breite_in_pixeln = Math.round( (width_proz  * 0.01f )  * breite );
        this.hoehe_in_pixeln  = Math.round( (height_proz * 0.01f )  * hoehe );
        
        float breite_in_opengl_coord = ((this.breite_in_pixeln / breite) * 2.0f );//  / aspec;
        float hoehe_in_opengl_coord  = ((this.hoehe_in_pixeln / hoehe) * 2.0f );
        
        // a b c d des rechtecks 
        this.a.x = ((this.pixel_von_links / breite) * 2.0f ) -1.0f;
        this.a.y = (((this.pixel_von_oben  / hoehe) * 2.0f ) -1.0f) * -1f;
        
        this.b.set2( this.a.x , this.a.y - hoehe_in_opengl_coord );
        this.c.set2( this.a.x + breite_in_opengl_coord , this.a.y - hoehe_in_opengl_coord );
        this.d.set2( this.a.x + breite_in_opengl_coord , this.a.y );
        
    }
    
    
    public void checkMouseover( int x , int y )
    {
        y = Math.abs( y - DisplayManager.HEIGHT );

        if(    x > this.pixel_von_links 
            && y > this.pixel_von_oben 
            && x < this.pixel_von_links + this.breite_in_pixeln
            && y < this.pixel_von_oben + this.hoehe_in_pixeln )
        {
            if( this.color.y > 0 ) 
                this.color.y -= 0.15f;
            
            if( this.color.z > 0 ) 
                this.color.z -= 0.15f;
                
            if( this.mouse_over_button == false )
            {
                this.mouse_over_button = true;              
            }
            
        }
        else 
        {
            if( this.color.y < 1 ) 
                this.color.y += 0.15f;
            
            if( this.color.z < 1 ) 
                this.color.z += 0.15f;            
            
            if( this.mouse_over_button == true )
            {
                this.mouse_over_button = false;
            }
        }
        
        // den mouse click "loslassen" abfangen
        if( this.mouse_is_down == true && Mouse.isButtonDown( 0 ) == false )
        {
            this.mouse_is_down = false;
        }
        
    }    
    
    
    public void onClick()
    {
        if( this.mouse_over_button && this.mouse_is_down == false )
        {
            System.out.println( " ich wurde gedrückt " );
            
            try {
                Process process = new ProcessBuilder(  this.programm_pfad  ).start();
            } catch (IOException ex) {
                Logger.getLogger(Button.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.mouse_is_down = true;
        }
        
    }
    
    public void setProgramm( String path )
    {
        this.programm_pfad = path;
    }
    
}
