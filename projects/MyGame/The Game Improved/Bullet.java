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

    private boolean isF, isUp,isDown,isPLeft,isPRight;

    public Bullet
    (int xLoc, int yLoc, int h, int w,int dam, int dis, int s, boolean isFlameThrower )
    {
        super(xLoc,yLoc,h,w);
        damage = dam;
        distance = dis;
        speed = s;

        isF = isFlameThrower;
        isUp = false;
        isPRight = false;
        isPLeft = false;

        isDown = false;


    }

    public void move()
    {
        if(distanceCount<distance)
        {
            if(getIsFacingRight()&&!isUp&&!isDown || ((isUp||isDown) && isPRight))
            {
                setX(getX()+speed);
                distanceCount ++;
            }
             else if(!isUp&&!isDown ||((isUp||isDown) && isPLeft))
            {
                setX(getX()-speed);
                distanceCount++;
            }

             if(isUp)
            {
                setY(getY()-speed);
                distanceCount ++;
            }

           

             if(isDown)
            {
                setY(getY()+speed);
                distanceCount ++;
            }

            


        }

    }
    public void setIsPRight(boolean b)
    {
        isPRight = b;
    }
        public void setIsPLeft(boolean b)
    {
        isPLeft = b;
    }
    public void setIsUp(boolean b)
    {
        isUp = b;
    }
        public void setIsDown(boolean b)
    {
        isDown = b;
    }
    
    public boolean getIsPRight()
    {
        return isPRight;
    }
        public boolean getIsPLeft()
    {
        return isPLeft;
    }
        public boolean getIsUp()
    {
        return isUp;
    }
        public boolean getIsDown()
    {
        return isDown;
    }




    public int getDistanceCount()
    {
        return distanceCount;
    }
    
    public void setDistanceCount(int i)
    {
        distanceCount = i;
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