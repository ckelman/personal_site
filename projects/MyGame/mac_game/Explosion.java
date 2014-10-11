import java.util.*;
import java.applet.*;
import java.awt.*;
public class Explosion extends Mover
{
    public Explosion(int x,int y)
    {
        super(x,y,2,2);
    }
    
    public void explode(MainCharacter m, ArrayList<Platform> p)
    {
        setX(getX()-4);
        setY(getY()-4);
        setWidth(getWidth()+8);
        setHeight(getHeight()+8);
        
        if (m.intersects(this))
        {
            m.setHealth(m.getHealth()-50);
            
            for(int i = 0; i<10;i++)
       {
            if(!m.isPlatformAbove(p))
            m.setHeight(m.getHeight()-2);
        }
        setHeight(76);
        }
    }
    
    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.yellow);
        g2.fillRect(getXInt(),getYInt(),getWidth(),getHeight());
    }
        
    }