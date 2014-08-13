
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.*;
public class Turret extends Mover
{
    private Gun g;
    private boolean isIn;
    public Turret(int x, int y, int w, int h)
    {
        super(x,y,w,h);
       isIn = false;

    }

    public void isInTurret(MainCharacter m)
    {
        if (m.intersects(this))
        {
            isIn = true;
            

        }

        
    }

    public void activateTurret(MainCharacter m)
    {
     
            if(!isIn && m.intersects(this))
        {
            g =  m.getGun();
            Bullet b = new Bullet(m.getXInt(),m.getYInt(),10,10,15,100,10,false);
            m.setGun(new Gun(m.getXInt(),m.getYInt(),m.getHeight(),m.getWidth(),1,b,10000,6));
        }
        
    }

    public void deactivateTurret(MainCharacter m)
    {
            if(isIn &&!m.intersects(this))
        {
            m.setGun(g);
            isIn = false;
            m.getGun().setIsShooting(false);
        }
        
    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.green);
        g2.fillRect(getXInt(),getYInt(),getHeight(),getWidth());
    }

}