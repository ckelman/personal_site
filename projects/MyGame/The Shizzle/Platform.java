import java.util.*;
import java.applet.*;
import java.awt.*;
public class Platform extends Mover
{
    private int platX,platY,platW,platH;
    
    public Platform (int x,int y,int w,int h)
    {
        super(x,y,w,h);
        platX = x;
        platY = y;
        platW = w;
        platH = h;
    }
    
         public void setCanUse(boolean b)
     {
         
     }
     
     public void setUseTimer(int i)
     {
        
        }
        
        public int getUseTimer()
        {
            return -1;
        }
        
        public boolean getCanUse()
        {
            return true;
        }
    
    public int getPlatX()
    {
        return platX;
    }
    
    public int getPlatY()
    {
        return platY;
    }
    
    public int getPlatW()
    {
        return platW;
    }
    
    public int getPlatH()
    {
        return platH;
    }
    
    public boolean isbumped(MainCharacter subject)
    {
        return false;
    }
    
    public void produceRandompowerup(MainCharacter m)
    {
    }
    public void draw(Graphics2D g2)
    {
        g2.setColor(new Color(65,67,66));
        g2.fillRect(platX,platY,platW,platH);

        

    }
}