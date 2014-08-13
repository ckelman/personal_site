import java.util.*;
import java.applet.*;
import java.awt.*;
public class SniperEnemy extends Person
{
    private boolean isright;
    private int state;
    private Bullet b;
    private Gun g;
    public SniperEnemy(int x, int y)
    {
        super(x,y,36,45,150,null);
        boolean isright = true;
        b = new Bullet(getXInt(),getYInt(),10,10,10,100,8,false);
        g = new Gun(getXInt(),getYInt(),getHeight(),getWidth(),10,b,100,1);
        state = 0;
        setGun(g);
    }


    public void attack(MainCharacter main, ArrayList<Platform> g)
    {
        if(!getIsFrozen())
        {
        b = new Bullet(getXInt(),getYInt(),10,10,10,100,3,false);
        getGun().setBullet(b);
        if(!isright)
        {
            Platform fieldovisionr = new Platform((int)(getX()-400),(int)(getY()),400,getHeight());
            if(main.intersects(fieldovisionr))
            {
                getGun().setIsShooting(true);
            }
            else
                getGun().setIsShooting(false);
        }
        if(isright)
        {
            Platform fieldovisionl = new Platform((int)(getX()+getWidth()),(int)(getY()),400,getHeight());
            if(main.intersects(fieldovisionl))
            {
                getGun().setIsShooting(true);
            }
            else
                getGun().setIsShooting(false);
        }
    }

    }


    public void pace(ArrayList<Platform> ground)
    {
        if(!getIsFrozen())
        {

        if (getHealth()>0)
        {
            if(isright)
            {
                setIsFacingRight(true);
                Person testwalker = new Person((int)(getX())+2,(int)(getY()),getWidth(),getHeight(),1,null);
                if(testwalker.isPlatformBelow(ground)&&!isPlatformRight(ground))
                {
                    setX(getX()+2);
                }
                else
                {
                    isright = false;
                    setIsFacingRight(false);
                    state = 1;
                }
            }
            if(!isright)
            {
                setIsFacingRight(false);
                Person testwalker = new Person((int)(getX())-2,(int)(getY()),getWidth(),getHeight(),1,null);
                if(testwalker.isPlatformBelow(ground)&&!isPlatformLeft(ground))
                {
                    setX(getX()-2);
                }
                else
                {
                    isright = true;
                    setIsFacingRight(true);
                    state = 0;
                }
            }   
        }
    }
    }


    public void draw(Graphics2D g2)
    {


    //State 0 StandRight, 1 StandLeft
    

        int x = getXInt();
        int y = getYInt();
        
        //Size multiplier
        int s = 3;

        
        Color c = new Color(141, 76, 6);
        
        if(state == 0)
        {
            //Plume
            g2.setColor(Color.lightGray);
            g2.fillRect(x+1*s, y, s, 3*s);
            g2.fillRect(x+2*s, y, 2*s, 2*s);
            g2.fillRect(x+3*s, y+s, 2*s, 2*s);
            g2.fillRect(x+4*s, y+3*s, 2*s, s);
            g2.fillRect(x+5*s, y+4*s, s, s);
            
            //Helmet
            g2.setColor(Color.BLACK);
            g2.fillRect(x+0*s, y+5*s, 8*s, 4*s);
            g2.fillRect(x+1*s, y+9*s, 7*s, s);
            g2.fillRect(x+3*s, y+10*s, 5*s, s);
            g2.fillRect(x+4*s, y+11*s, 4*s, s);
            
            //Face
            g2.setColor(Color.WHITE);
            g2.fillRect(x+1*s, y+10*s, 2*s, s);
            g2.fillRect(x+2*s, y+11*s, 2*s, s);
            g2.fillRect(x+2*s, y+12*s, 6*s, s);
            
            //Eye sockets
            g2.fillRect(x+3*s, y+6*s, 2*s, 2*s);
            g2.fillRect(x+4*s, y+7*s, 2*s, 2*s);
            g2.fillRect(x+5*s, y+8*s, 3*s, 2*s);
            g2.fillRect(x+7*s, y+10*s, s, s);
            
            //Gun
            g2.setColor(Color.BLACK);
            g2.fillRect(x+9*s, y+10*s, 3*s, s);
            g2.fillRect(x+9*s, y+11*s, s, s);
            
            //Legs
            g2.fillRect(x+3*s, y+14*s, 2*s, s);
            g2.fillRect(x+6*s, y+14*s, 2*s, s);
            
            //Outline of Plume
            g2.drawLine(x+1*s, y, x+4*s, y);
            g2.drawLine(x+4*s, y, x+4*s, y+1*s);
            g2.drawLine(x+4*s, y+1*s, x+5*s, y+1*s);
            g2.drawLine(x+5*s, y+1*s, x+5*s, y+3*s);
            g2.drawLine(x+5*s, y+3*s, x+6*s, y+3*s);
            g2.drawLine(x+6*s, y+3*s, x+6*s, y+5*s);
            g2.drawLine(x+5*s, y+5*s, x+5*s, y+4*s);
            g2.drawLine(x+5*s, y+4*s, x+4*s, y+4*s);
            g2.drawLine(x+4*s, y+4*s, x+4*s, y+3*s);
            g2.drawLine(x+4*s, y+3*s, x+3*s, y+3*s);
            g2.drawLine(x+3*s, y+3*s, x+3*s, y+2*s);
            g2.drawLine(x+3*s, y+2*s, x+2*s, y+2*s);
            g2.drawLine(x+2*s, y+2*s, x+2*s, y+3*s);
            g2.drawLine(x+2*s, y+3*s, x+1*s, y+3*s);
            g2.drawLine(x+1*s, y+3*s, x+1*s, y);
            
            //Outline of Eyes
            g2.drawRect(x+3*s, y+6*s, s, 2*s);
            g2.drawRect(x+4*s, y+6*s, s, 3*s);
            g2.drawRect(x+5*s, y+7*s, s, 3*s);
            g2.drawRect(x+6*s, y+8*s, s, 2*s);
            g2.drawRect(x+7*s, y+8*s, s, 3*s);
            
            //Outline of Helmet
            g2.drawLine(x+8*s, y+5*s, x+8*s, y+13*s);
            g2.drawLine(x+8*s, y+13*s, x+2*s, y+13*s);
            g2.drawLine(x+2*s, y+13*s, x+2*s, y+11*s);
            g2.drawLine(x+2*s, y+11*s, x+1*s, y+11*s);
            g2.drawLine(x+1*s, y+11*s, x+1*s, y+10*s);
            g2.drawLine(x+1*s, y+10*s, x+3*s, y+10*s);
            g2.drawLine(x+3*s, y+10*s, x+3*s, y+11*s);
            g2.drawLine(x+3*s, y+11*s, x+4*s, y+11*s);
            g2.drawLine(x+4*s, y+11*s, x+4*s, y+12*s);
            g2.drawLine(x+4*s, y+12*s, x+8*s, y+12*s);
        }
        
        if(state == 1)
        {
            //Plume
            g2.setColor(Color.lightGray);
            g2.fillRect(x+10*s, y, s, 3*s);
            g2.fillRect(x+8*s, y, 2*s, 2*s);
            g2.fillRect(x+7*s, y+s, 2*s, 2*s);
            g2.fillRect(x+6*s, y+3*s, 2*s, s);
            g2.fillRect(x+6*s, y+4*s, s, s);
            
            //Helmet
            g2.setColor(Color.BLACK);
            g2.fillRect(x+4*s, y+5*s, 8*s, 4*s);
            g2.fillRect(x+4*s, y+9*s, 7*s, s);
            g2.fillRect(x+4*s, y+10*s, 5*s, s);
            g2.fillRect(x+4*s, y+11*s, 4*s, s);
            
            //Face
            g2.setColor(Color.WHITE);
            g2.fillRect(x+9*s, y+10*s, 2*s, s);
            g2.fillRect(x+8*s, y+11*s, 2*s, s);
            g2.fillRect(x+4*s, y+12*s, 6*s, s);
            
            //Eye sockets
            g2.fillRect(x+7*s, y+6*s, 2*s, 2*s);
            g2.fillRect(x+6*s, y+7*s, 2*s, 2*s);
            g2.fillRect(x+4*s, y+8*s, 3*s, 2*s);
            g2.fillRect(x+4*s, y+10*s, s, s);
            
            //Gun
            g2.setColor(Color.BLACK);
            g2.fillRect(x+0*s, y+10*s, 3*s, s);
            g2.fillRect(x+2*s, y+11*s, s, s);
            
            //Legs
            g2.fillRect(x+7*s, y+14*s, 2*s, s);
            g2.fillRect(x+4*s, y+14*s, 2*s, s);
            
            //Outline of Plume
            g2.drawLine(x+11*s, y, x+8*s, y);
            g2.drawLine(x+8*s, y, x+8*s, y+1*s);
            g2.drawLine(x+8*s, y+1*s, x+7*s, y+1*s);
            g2.drawLine(x+7*s, y+1*s, x+7*s, y+3*s);
            g2.drawLine(x+7*s, y+3*s, x+6*s, y+3*s);
            g2.drawLine(x+6*s, y+3*s, x+6*s, y+5*s);
            g2.drawLine(x+7*s, y+5*s, x+7*s, y+4*s);
            g2.drawLine(x+7*s, y+4*s, x+8*s, y+4*s);
            g2.drawLine(x+8*s, y+4*s, x+8*s, y+3*s);
            g2.drawLine(x+8*s, y+3*s, x+9*s, y+3*s);
            g2.drawLine(x+9*s, y+3*s, x+9*s, y+2*s);
            g2.drawLine(x+9*s, y+2*s, x+10*s, y+2*s);
            g2.drawLine(x+10*s, y+2*s, x+10*s, y+3*s);
            g2.drawLine(x+10*s, y+3*s, x+11*s, y+3*s);
            g2.drawLine(x+11*s, y+3*s, x+11*s, y);
            
            //Outline of Eyes
            g2.drawRect(x+8*s, y+6*s, s, 2*s);
            g2.drawRect(x+7*s, y+6*s, s, 3*s);
            g2.drawRect(x+6*s, y+7*s, s, 3*s);
            g2.drawRect(x+5*s, y+8*s, s, 2*s);
            g2.drawRect(x+4*s, y+8*s, s, 3*s);
            
            //Outline of Helmet
            g2.drawLine(x+4*s, y+5*s, x+4*s, y+13*s);
            g2.drawLine(x+4*s, y+13*s, x+10*s, y+13*s);
            g2.drawLine(x+10*s, y+13*s, x+10*s, y+11*s);
            g2.drawLine(x+10*s, y+11*s, x+11*s, y+11*s);
            g2.drawLine(x+11*s, y+11*s, x+11*s, y+10*s);
            g2.drawLine(x+11*s, y+10*s, x+9*s, y+10*s);
            g2.drawLine(x+9*s, y+10*s, x+9*s, y+11*s);
            g2.drawLine(x+9*s, y+11*s, x+8*s, y+11*s);
            g2.drawLine(x+8*s, y+11*s, x+8*s, y+12*s);
            g2.drawLine(x+8*s, y+12*s, x+4*s, y+12*s);
        }
    
 

        g2.setColor(Color.red);   
        g2.fillRect(getXInt(),getYInt()-8,(int)(getHealth()/150.0*getWidth()),5);
        g2.setColor(Color.black);
        g2.drawRect(getXInt(),getYInt()-8,(int)(getHealth()/150.0*getWidth()),5);
        //         g2.drawString(""+getHealth(),getXInt(),getYInt()-5);
    }
}
 
