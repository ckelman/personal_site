import java.util.*;
public class Person extends Mover
{
    private int health,freezeTimer;
    private Gun gun;
    private boolean isFrozen;
    private double force;

    public Person(int x, int y, int w, int h, int heal, Gun g)
    {
        super(x,y,w,h);
        health = heal;
        gun =  g;
        isFrozen = false;
        freezeTimer = 0;
        force = 0;
    }
        public double getForce()
    {
        return force;
    }
    public void setForce(double i)
    {
        force = i;
    }
    
    public void setFreezeTimer(int i)
    {
        freezeTimer = i;
    }
    public int getFreezeTimer()
    {
        return freezeTimer;
    }
    public void setIsFrozen(boolean b)
    {
        isFrozen = b;
    }
    public boolean getIsFrozen()
    {
        return isFrozen;
    }
    
public void fall(ArrayList<Platform> p)
    {

        setY(getY()+1);
            if(!isPlatformBelow(p))
            setY(getY()+1);
                        if(!isPlatformBelow(p))
            setY(getY()+1);
                        if(!isPlatformBelow(p))
            setY(getY()+1);
    }
    
    public void heroFall(ArrayList<Platform> p)
    {

        setY(getY()+1);
            if(!isPlatformBelow(p))
            setY(getY()+1);
//                         if(!isPlatformBelow(p))
//              setY(getY()+1);
//                         if(!isPlatformBelow(p))
//             setY(getY()+1);
    }
    
    public void setHealth(int h)
    {
        health=h;
    }
    


    public boolean isPlatformAbove(ArrayList<Platform> plats)
    {
        int xLoc = getXInt();
        int yLoc = getYInt();
        int width = getWidth();
        int height = getHeight();
        for(Platform p: plats)
        {
            int platX = p.getXInt();
            int platY = p.getYInt();
            int platH = p.getHeight();
            int platW = p.getWidth();
            if((xLoc+width >= platX && xLoc <= platX+platW) && Math.abs(yLoc - (platY+platH))<=3 )
                return true;
        }
        return false;
    }

    public boolean isPlatformBelow(ArrayList<Platform> plats)
    {
        int xLoc = getXInt();
        int yLoc = getYInt();
        int width = getWidth();
        int height = getHeight();
        for(Platform p: plats)
        {
            int platX = p.getXInt();
            int platY = p.getYInt();
            int platH = p.getHeight();
            int platW = p.getWidth();
            if((xLoc+width >= platX && xLoc <= platX+platW) && Math.abs(yLoc+height - platY)<=3)
                return true;
        }
        return false;
    }
    
        public boolean isPlatformRight(ArrayList<Platform> plats)
    {
        int xLoc = getXInt();
        int yLoc =  getYInt();
        int width = getWidth();
        int height = getHeight();
        for(Platform p: plats)
        {
            int platX = p.getXInt();
            int platY = p.getYInt();
            int platH = p.getHeight();
            int platW = p.getWidth();
                                               //change the 2 to the character's speed
            if((xLoc+width >= platX && xLoc <= platX+platW-4) && (yLoc+height-4>platY && yLoc<platY+platH))
                return true;
        }
        return false;
    }
    
        public boolean isPlatformLeft(ArrayList<Platform> plats)
    {
        int xLoc = getXInt();
        int yLoc =  getYInt();
        int width = getWidth();
        int height = getHeight();
        for(Platform p: plats)
        {
            int platX = p.getXInt();
            int platY = p.getYInt();
            int platH = p.getHeight();
            int platW = p.getWidth();
            //change the 2 to the character's speed
            if((xLoc >= platX+4 && xLoc <= platX+platW) && (yLoc+height-4>platY && yLoc<platY+platH))
                return true;
        }
        return false;
    }
    
    public Gun getGun()
    {
        return gun;
    }
    public void setGun(Gun as)
    {
        gun = as;
    }
    public int getHealth()
    {
        return health;
    }
    public void pace(ArrayList<Platform> ground)
    {
    }
    public void attack(MainCharacter main, ArrayList<Platform> g)
    {
    }
    public void attack1(MainCharacter m, ArrayList<Bullet> bullets)
    {
    }

    
}