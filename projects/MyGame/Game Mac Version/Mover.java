import java.util.*;
import java.applet.*;
import java.awt.*;
public abstract class Mover
{
    private double x;
    private double y;
    
    private int height;
    private int width;
    
    private boolean isMovingRight, isMovingLeft, isFacingRight;
    
    public Mover(double xLoc,double yLoc, int w, int h)
    {
        
        x = xLoc;
        y = yLoc;
        height = h;
        width = w;
        isMovingLeft = false;
        isMovingRight =false;
        isFacingRight = true;
    }
    
    public void setIsFacingRight(boolean b)
    {
        isFacingRight = b;
    }
    
    public boolean getIsFacingRight()
    {
        return isFacingRight;
    }
    
     public boolean getIsMovingRight()
    {
        return isMovingRight;
    }


    public void setIsMovingRight(boolean b)
    {
        isMovingRight = b;
    }


    public void setIsMovingLeft(boolean b)
    {
        isMovingLeft = b;
    }

    public boolean getIsMovingLeft()
    {
        return isMovingLeft;
    }
    
    public void move()
    {
        
    }
    
    public double getX()
    {
        return x;
    }
    
    public int getYInt()
    {
        return (int)y;
    }
        public int getXInt()
    {
        return (int)x;
    }
    public double getY()
    {
        return y;
    }
    public void setX(double xx)
    {
        x=xx;
    }
    public void setY( double yy)
    {
        y=yy;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public void setHeight(int i)
    {
        height = i;
    }
    
    public int getWidth()
    {
        return width;
    }
    public void setWidth(int i)
    {
        width = i;
    }
    public boolean intersects(Mover m)
    {
        if((x+width >= m.getXInt()&& x<= m.getXInt()+m.getWidth()) && (y+height >= m.getYInt() && y <= m.getYInt()+m.getHeight()))
        {
            return true;
        }
        return false;
    }
    public void draw(Graphics2D g2)
    {
        
    }
    
}