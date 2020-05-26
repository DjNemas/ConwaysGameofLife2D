package LOGIK.GEOMETRY;

public class Punkt 
{
    public float x;
    public float y;
    public float z;
    
    public Punkt( float in_x , float in_y )
    {
        this.x = in_x;
        this.y = in_y;
        this.z = 0;
    }
    
    public Punkt( float in_x , float in_y , float in_z )
    {
        this.x = in_x;
        this.y = in_y;
        this.z = in_z;
    }  
    
    public void set2( float in_x , float in_y )
    {
        this.x = in_x;
        this.y = in_y;
    }  
    
    public void set3( float in_x , float in_y , float in_z )
    {
        this.x = in_x;
        this.y = in_y;
        this.z = in_z;
    }     
}
