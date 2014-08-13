import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.*;

public class SniperBullet extends Bullet
{
    public SniperBullet(int x, int y)
    {
        super(x,y,5,10,100,1000,15,false);
    }
    
    public void draw(Graphics2D g2)
    {
        
        g2.setColor(Color.black);
        g2.fillOval(getXInt(),getYInt(),getHeight(),getWidth());

        g2.setColor(Color.black);
        g2.drawOval(getXInt(),getYInt(),getHeight(),getWidth());
    }
}