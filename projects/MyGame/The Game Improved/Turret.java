
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
        //turret 50 by 50
        //g2.setColor(new Color(105,40,8));
        g2.setColor(Color.black); 
        int x = getXInt();
        int y = getYInt();
        int h = getHeight();
        int w = getWidth();
        
       
        
        g2.fillRect(x+10,y+45,35,5);
        g2.setColor(Color.black); 
        g2.drawRect(x+10,y+45,35,5);
        //g2.setColor(new Color(105,40,8));
        g2.fillRect(x+25,y+10,5,45);        
        g2.setColor(Color.black);
        g2.drawRect(x+25,y+10,5,45);
        
        g2.setColor(new Color(135,130,137));
        g2.fillRect(x+25,y+10,25,4);
        g2.setColor(Color.black);
        g2.drawRect(x+25,y+10,25,4);
        
        //g2.setColor(new Color(135,130,137));
        g2.fillOval(x+50,y+10,2,4);
        g2.setColor(Color.black);
        g2.drawOval(x+50,y+10,2,4);
        
        
        
        g2.setColor(new Color(135,130,137));
        g2.fillRect(x+25,y+10+4,25,4);
        
        g2.setColor(Color.black);
        g2.drawRect(x+25,y+10+4,25,4);
        
        //g2.setColor(new Color(135,130,137));
        g2.fillOval(x+50,y+10+4,2,4);
        g2.setColor(Color.black);
        g2.drawOval(x+50,y+10+4,2,4);
        
        
        
        g2.setColor(new Color(135,130,137));
        g2.fillRect(x+25,y+10+8,25,4);
        
        g2.setColor(Color.black);
        g2.drawRect(x+25,y+10+8,25,4);
        
        //g2.setColor(new Color(135,130,137));
        g2.fillOval(x+50,y+10+8,2,4);
        g2.setColor(Color.black);
        g2.drawOval(x+50,y+10+8,2,4);

        
        
        g2.setColor(new Color(135,130,137));
        g2.fillRect(x+25,y+10+12,25,4);
        
        g2.setColor(Color.black);
        g2.drawRect(x+25,y+10+12,25,4);
        
        //g2.setColor(new Color(135,130,137));
        g2.fillOval(x+50,y+10+12,2,4);
        g2.setColor(Color.black);
        g2.drawOval(x+50,y+10+12,2,4);
        
        
        //g2.setColor(new Color(105,40,8));
        g2.setColor(Color.black); 
        g2.fillRect(x+12,y+28,18,3);
        g2.setColor(Color.black);
        g2.drawRect(x+12,y+28,18,3);
        
        g2.fillRect(x+12,y+23,3,12);

    }

}