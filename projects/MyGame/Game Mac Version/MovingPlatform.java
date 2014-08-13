import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.*;
public class MovingPlatform extends Platform
{
    private int dX,dY,maxD,distanceChange;
    private boolean isMovingForward;
    public MovingPlatform(int x, int y, int w, int h,int dxx,int dyy,int md)
    {
        super(x,y,w,h);
        dX = dxx;
        dY = dyy;
        maxD = md;

        isMovingForward = true;
        distanceChange = 0;
    }

    public int getDX()
    {
        return dX;
    }


    public int getDY()
    {
        return dY;
    }


    public void move()
    {
        if(distanceChange >=maxD)
            isMovingForward = false;
        else if(distanceChange<=0)
            isMovingForward = true;

        if(isMovingForward)
        {
            setX(getX()+dX);
            setY(getY()-dY);
            distanceChange++;
        }
        else
        {
            setX(getX()-dX);
            setY(getY()+dY);
            distanceChange--;
        }
    }


    public void moveEnemies(ArrayList<Person> enemies, ArrayList<Platform> ps)
    {
        ArrayList<Platform> p = new ArrayList<Platform>();
        p.add(this);

        for(Person m: enemies)
        {
            if(m.isPlatformBelow(p))
        {
            if(isMovingForward)
            {
                if(!((m.isPlatformRight(ps) && dX>0) || (m.isPlatformLeft(ps)&&dX<0)))
                m.setX(m.getX()+dX);
                
                if(dY>0)
                m.setY(m.getY()-dY);
                

                


            }
            else
            {
                if(!((m.isPlatformRight(ps) && dX>0) || (m.isPlatformLeft(ps)&&dX<0)))
                m.setX(m.getX()-dX);
                
                if(dY<0)
                m.setY(m.getY()+dY);
                



            }

        }
        
                  if((dX<0 ||(dX>0&&!isMovingForward)) && m.isPlatformRight(p)&&!m.isPlatformLeft(ps))
                {
                    m.setX(m.getXInt() - dX);
                }
                   if((dX>0 || (dX<0 &&! isMovingForward)) && m.isPlatformLeft(p)&& !m.isPlatformRight(ps))
                {
                    m.setX(m.getXInt()+dX);
                }
        }
    }

    public void moveMe(MainCharacter m, ArrayList<Platform>ps)
    {
        ArrayList<Platform> p = new ArrayList<Platform>();
        p.add(this);


                
        if(m.isPlatformBelow(p))
        {
            if(isMovingForward)
            {
              if(!((m.isPlatformRight(ps) && dX>0) || (m.isPlatformLeft(ps)&&dX<0)))
                m.setX(m.getX()+dX);
                
                if(dY>0)
                m.setY(m.getY()-dY);
                

                


            }
            
            else
            {
                if(!((m.isPlatformRight(ps) && dX<0) || (m.isPlatformLeft(ps)&&dX>0)))
                m.setX(m.getX()-dX);
                
                if(dY<0)
                m.setY(m.getY()+dY);
                



            }

        }
        
             
                  if((dX<0 ||(dX>0&&!isMovingForward)) && m.isPlatformRight(p)&&!m.isPlatformLeft(ps))
                {
                    m.setX(m.getXInt() - dX);
                }
                   if((dX>0 || (dX<0 &&! isMovingForward)) && m.isPlatformLeft(p)&& !m.isPlatformRight(ps))
                {
                    m.setX(m.getXInt()+dX);
                }



    }

}