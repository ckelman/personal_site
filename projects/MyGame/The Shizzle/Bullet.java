import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.*;

public class Bullet extends Mover
{

    private int damage;
    private int distance;
    private int speed;
    private int distanceCount;

    private boolean isF;

    public Bullet
    (int xLoc, int yLoc, int h, int w,int dam, int dis, int s, boolean isFriendly )
    {
        super(xLoc,yLoc,h,w);
        damage = dam;
        distance = dis;
        speed = s;

        isF = isFriendly;
    }

    public void move()
    {
        if(distanceCount<distance)
        {
            if(getIsFacingRight())
            {
                setX(getX()+speed);
                distanceCount ++;
            }

            else
            {
                setX(getX()-speed);
                distanceCount++;
            }
        }
        
        

    }
    
    public int getDistanceCount()
    {
        return distanceCount;
    }

    public boolean getIsFriendly()
    {
        return isF;
    }

    public int getDamage()
    {
        return damage;

    }


    public int getDistance()
    {
        return distance;

    }


    public int getSpeed()
    {
        return speed;
    }

    public void draw(Graphics2D g2)
    {

        
        g2.setColor(Color.yellow);
        g2.fillOval(getXInt(),getYInt(),getHeight(),getWidth());
        
        g2.setColor(Color.black);
        g2.drawOval(getXInt(),getYInt(),getHeight(),getWidth());
        
    }
}