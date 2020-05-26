package LOGIK.GEOMETRY;

import RENDER.Display.DisplayManager;
import org.lwjgl.opengl.GL11;

public class Rechteck 
{
    public Punkt a;
    public Punkt b;
    public Punkt c;
    public Punkt d;
    public Punkt color;
    public boolean alive = false;
    
    public Rechteck()
    {
        this.a = new Punkt( 0, 0 );
        this.b = new Punkt( 0, 0 );
        this.c = new Punkt( 0 ,0 );
        this.d = new Punkt( 0 ,0 );
        this.color = new Punkt( 0 , 0 , 0);
        this.alive = false;
    }
    
    public void set_Pos_Top_Left_in_pix( float left_pix , float top_pix , float width_pix , float height_pix )
    {
        // bekommt in prozent die obere linke ecke des button 
        // die Pixel coordinaten von oben und links im aktullen fenster berechnen
        // opengl Zeichnungs coordinaten berechnen
        float breite   = DisplayManager.WIDTH;
        float hoehe    = DisplayManager.HEIGHT;
        float aspec   = DisplayManager.ASPECT_RATIO;
        
        // a b c d des rechtecks 
        this.a.x = (( left_pix / breite) * 2.0f ) -1.0f;
        this.a.y = (((top_pix  / hoehe) * 2.0f ) -1.0f) * -1f;
        
        this.b.set2( this.a.x , this.a.y - ((height_pix / hoehe) * 2.0f ));
        this.c.set2( this.a.x + ((width_pix / breite) * 2.0f ) , this.a.y -((height_pix / hoehe) * 2.0f ));
        this.d.set2( this.a.x + ((width_pix / breite) * 2.0f ) , this.a.y );
        
    }
    
    public void zeichne( boolean filled )
    {
        // farbe setzen
        GL11.glColor3f(this.color.x, this.color.y, this.color.z);
        
        if( filled == true )
            GL11.glBegin( GL11.GL_QUADS );
        else
            GL11.glBegin( GL11.GL_LINE_LOOP );

        // gegen den uhrzeigersinn
        // die eckpunkte      X    ,    Y       ,    Z
        GL11.glVertex3f(  this.a.x , this.a.y   , this.a.z );
        GL11.glVertex3f(  this.b.x , this.b.y   , this.b.z );              
        GL11.glVertex3f(  this.c.x , this.c.y   , this.c.z ); 
        GL11.glVertex3f(  this.d.x , this.d.y   , this.d.z ); 

        GL11.glEnd();        
    } 
    
    public void setColor( float r , float g , float b )
    {
        this.color.x = r;
        this.color.y = g;
        this.color.z = b;
    }
    

}
