import java.util.*;
public class Person extends Mover
{
    private int health;
    private Gun gun;

    public Person(int x, int y, int w, int h, int heal, Gun g)
    {
        super(x,y,w,h);
        health = heal;
        gun =  g;
       
    }
    
        public void fall()
    {
        setY(getY()+3);
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
            int platX = p.getPlatX();
            int platY = p.getPlatY();
            int platH = p.getPlatH();
            int platW = p.getPlatW();
            if((xLoc+width >= platX && xLoc <= platX+platW) && Math.abs(yLoc - (platY+platH))<=1 )
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
            int platX = p.getPlatX();
            int platY = p.getPlatY();
            int platH = p.getPlatH();
            int platW = p.getPlatW();
            if((xLoc+width >= platX && xLoc <= platX+platW) && Math.abs(yLoc+height - platY)<=2)
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
            int platX = p.getPlatX();
            int platY = p.getPlatY();
            int platH = p.getPlatH();
            int platW = p.getPlatW();
                                               //change the 2 to the character's speed
            if((xLoc+width >= platX && xLoc <= platX+platW-3) && (yLoc+height>platY && yLoc<platY+platH))
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
            int platX = p.getPlatX();
            int platY = p.getPlatY();
            int platH = p.getPlatH();
            int platW = p.getPlatW();
            //change the 2 to the character's speed
            if((xLoc >= platX+3 && xLoc <= platX+platW) && (yLoc+height>platY && yLoc<platY+platH))
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
    
}