import java.util.*;
import java.applet.*;
import java.awt.*;
public class SuicideEnemy extends Person
{
private boolean isright;
private int state;
    public SuicideEnemy(int x, int y)
    {
        
        super(x,y,36,48,100,null);
        boolean isright = true;
        state = 0;
    }
    public boolean willExplode(MainCharacter m)
    {

        Platform senseRadii = new Platform((int)(getX()-25),(int)(getY()),getWidth()+50,getHeight()-10);
        if (m.intersects(senseRadii))
            return true;
            
            
        return false;
        
    }
    public void attack(MainCharacter main, ArrayList<Platform> g)
    {
        if(!getIsFrozen())
        {
        Platform senseRadii = new Platform((int)(getX()-25),(int)(getY()),getWidth()+50,getHeight()-10);
        if(main.intersects(senseRadii))
        {
            
            setHealth(-10);

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
                Person testwalker = new Person((int)(getX())+3,(int)(getY()),getWidth(),getHeight(),1,null);
                if(testwalker.isPlatformBelow(ground)&&!isPlatformRight(ground))
                {
                    setX(getX()+3);
                }
                else
                {
                    isright = false;
                    state = 1;
                }
            }
            if(!isright)
            {
                Person testwalker = new Person((int)(getX())-3,(int)(getY()),getWidth(),getHeight(),1,null);
                if(testwalker.isPlatformBelow(ground)&&!isPlatformLeft(ground))
                {
                    setX(getX()-3);
                }
                else
                {
                    isright = true;
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
        int s = 4;
 
        Color c = new Color(218, 110, 194);
 

 
        if(state == 0)
        {
            //Hat
            g2.setColor(Color.white);
            g2.fillRect(x+0*s, y, s, s);
            g2.fillRect(x+0*s, y+1*s, 2*s, s);
            g2.fillRect(x+0*s, y+2*s, 3*s, s);
            g2.fillRect(x+0*s, y+3*s, 4*s, s);
            g2.fillRect(x+0*s, y+4*s, 5*s, s);
 
            //Face
            g2.setColor(c);
            g2.fillRect(x+0*s, y+5*s, 6*s, 5*s);
 
            //Eyes and Mouth
            g2.setColor(Color.BLACK);
            g2.fillRect(x+2*s, y+6*s, s, s);
            g2.fillRect(x+4*s, y+6*s, s, s);
            g2.fillRect(x+3*s, y+8*s, s, s);
 
            //Hands
            g2.fillRect(x+7*s, y+7*s, s, 2*s);
            g2.drawRect(x+7*s, y+7*s, s, 2*s);
            g2.drawLine(x+7*s, y+6*s, x+7*s, y+7*s);
 
            //Legs
            g2.fillRect(x+1*s, y+11*s, 2*s, s);
            g2.fillRect(x+4*s, y+11*s, 2*s, s);
 
            //Outlining
            g2.drawRect(x+0*s, y, s, s);
            g2.drawRect(x+0*s, y+1*s, 2*s, s);
            g2.drawRect(x+0*s, y+2*s, 3*s, s);
            g2.drawRect(x+0*s, y+3*s, 4*s, s);
            g2.drawRect(x+0*s, y+4*s, 5*s, s);
            g2.drawRect(x+0*s, y+5*s, 6*s, 5*s);
        }
 
        if(state == 1)
        {
            //Hat
            g2.setColor(Color.white);
            g2.fillRect(x+7*s, y, s, s);
            g2.fillRect(x+6*s, y+1*s, 2*s, s);
            g2.fillRect(x+5*s, y+2*s, 3*s, s);
            g2.fillRect(x+4*s, y+3*s, 4*s, s);
            g2.fillRect(x+3*s, y+4*s, 5*s, s);
 
            //Face
            g2.setColor(c);
            g2.fillRect(x+2*s, y+5*s, 6*s, 5*s);
 
            //Eyes and Mouth
            g2.setColor(Color.BLACK);
            g2.fillRect(x+5*s, y+6*s, s, s);
            g2.fillRect(x+3*s, y+6*s, s, s);
            g2.fillRect(x+4*s, y+8*s, s, s);
 
            //Hands
            g2.fillRect(x+0*s, y+7*s, s, 2*s);
            g2.drawRect(x+0*s, y+7*s, s, 2*s);
            g2.drawLine(x+1*s, y+6*s, x+1*s, y+7*s);
 
            //Legs
            g2.fillRect(x+5*s, y+11*s, 2*s, s);
            g2.fillRect(x+2*s, y+11*s, 2*s, s);
 
            //Outlining
            g2.drawRect(x+7*s, y, s, s);
            g2.drawRect(x+6*s, y+1*s, 2*s, s);
            g2.drawRect(x+5*s, y+2*s, 3*s, s);
            g2.drawRect(x+4*s, y+3*s, 4*s, s);
            g2.drawRect(x+3*s, y+4*s, 5*s, s);
            g2.drawRect(x+2*s, y+5*s, 6*s, 5*s);
        }
        
        g2.setColor(Color.red);   
        g2.fillRect(getXInt(),getYInt()-8,(int)(getHealth()/100.0*getWidth()),5);
        g2.setColor(Color.black);
        g2.drawRect(getXInt(),getYInt()-8,(int)(getHealth()/100.0*getWidth()),5);
//         g2.drawString(""+getHealth(),getXInt(),getYInt()-5);
    }
}

