import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.*;

public class ShotgunBullet extends Bullet
{
    public ShotgunBullet(int x, int y)
    {
        super(x,y,7,7,30,14,7,false);
    }
    
    public void draw(Graphics2D g2)
    {
        
        g2.setColor(new Color(255,255,255));
        g2.fillOval(getXInt(),getYInt(),getHeight(),getWidth());

        g2.setColor(Color.black);
        g2.drawOval(getXInt(),getYInt(),getHeight(),getWidth());
    }
}