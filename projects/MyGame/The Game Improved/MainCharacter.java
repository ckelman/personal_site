import java.util.*;
import java.applet.*;
import java.awt.*;
public class MainCharacter extends Person
{
    private int maxJump, count;
    private boolean isJumping, isFalling,canJump,isCrouching;
    private int state;

    public MainCharacter(int x, int y, int w, int h, int health,Gun g)
    {
        super(x,y,w,h,health,g);
        maxJump  = 22;
        isJumping = false;
        isFalling = false;
        canJump = true;
        count = 0;
        isCrouching = false;
        state = 0;


    }

    public void setIsCrouching(boolean b)
    {
        isCrouching = b;
    }
    
    public boolean getIsCrouching()
    {
        return isCrouching;
    }
    
    public void crouch()
    {
        setHeight(25);

        if(state==0)
            state = 4;
            
          else 
            state =5; 
    }
    
        public void uncrouch()
    {
        setHeight(50);
        setY(getY()-25);
         if(state==4)
            state = 0;
             else 
            state =1; 
    }

    public void setState(int s)
    {
        state = s;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int c)
    {
        count = c;
    }

    public boolean getCanJump()
    {
        return canJump;
    }

    public void jump(ArrayList<Platform> p)
    {
     setForce(-6.5);


    }

    public int getMaxJump()
    {
        return maxJump;
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

    public boolean getIsJumping()
    {
        return isJumping;
    }

    public void setIsJumping(boolean b)
    {
        isJumping = b;
    }

    public boolean getIsFalling()
    {
        return isFalling;
    }

    public void setIsFalling(boolean b)
    {
        isFalling = b;
    }

    public void draw(Graphics2D g2)
    {
        int x =  getXInt();
        int y = getYInt();
        //Body height and Plume start
        int p = 0;
        int hB = 0;

        //Plume height and width
        int hP = 0;
        int wP = 0;

        //Size multiplier
        int s = 3;

        Color c = new Color(200, 109, 172);

        //StandRight
        if(state == 0)
        {
            g2.setColor(c);
            g2.fillRect(x+2*s, y+0, 2*s, 1*s);
            g2.fillRect(x+1*s, y+1*s, 3*s, 2*s);
            g2.fillRect(x+3*s, y+2*s, 2*s, 2*s);
            g2.fillRect(x+4*s, y+4*s, 1*s, 1*s);

            //Legs
            g2.setColor(Color.BLACK);
            g2.fillRect(x+2*s, y+15*s, 2*s, 2*s);
            g2.fillRect(x+5*s, y+15*s, 2*s, 2*s);

            //Hands
            g2.fillRect(x+9*s, y+9*s, 2*s, 2*s);

            //Body
            g2.setColor(Color.WHITE);
            g2.fillRect(x+0, y+5*s, 8*s, 5*s);
            g2.fillRect(x+1*s, y+10*s, 7*s, 2*s);
            g2.fillRect(x+2*s, y+12*s, 6*s, 1*s);
            g2.fillRect(x+2*s, y+13*s, 5*s, 1*s);

            //Helmet
            g2.setColor(Color.lightGray);
            g2.fillRect(x+0, y+5*s, 8*s, 5*s);
            g2.fillRect(x+1*s, y+10*s, 7*s, 1*s);
            g2.fillRect(x+3*s, y+11*s, 4*s, 1*s);
            g2.fillRect(x+4*s, y+12*s, 2*s, 1*s);

            //Eyes
            g2.setColor(Color.BLACK);
            g2.fillRect(x+2*s, y+8*s, 3*s, 1*s);
            g2.fillRect(x+4*s, y+9*s, 1*s, 1*s);
            g2.fillRect(x+6*s, y+8*s, 2*s, 1*s);
            g2.fillRect(x+6*s, y+9*s, 1*s, 1*s);

            //Eyebrows
            g2.fillRect(x+4*s, y+6*s, 1*s, 1*s);
            g2.fillRect(x+6*s, y+6*s, 1*s, 1*s);

            //Outline of Body
            g2.drawLine(x+0, y+5*s, x+8*s, y+5*s);
            g2.drawLine(x+8*s, y+5*s, x+8*s, y+13*s);
            g2.drawLine(x+8*s, y+13*s, x+7*s, y+13*s);
            g2.drawLine(x+7*s, y+13*s, x+7*s, y+14*s);
            g2.drawLine(x+7*s, y+14*s, x+2*s, y+14*s);
            g2.drawLine(x+2*s, y+14*s, x+2*s, y+12*s);
            g2.drawLine(x+2*s, y+12*s, x+1*s, y+12*s);
            g2.drawLine(x+1*s, y+12*s, x+1*s, y+10*s);
            g2.drawLine(x+1*s, y+10*s, x+0, y+10*s);
            g2.drawLine(x+0, y+10*s, x+0, y+5*s);

            //Outline of Helmet
            g2.drawLine(x+1*s, y+11*s, x+3*s, y+11*s);
            g2.drawLine(x+3*s, y+11*s, x+3*s, y+12*s);
            g2.drawLine(x+3*s, y+12*s, x+4*s, y+12*s);
            g2.drawLine(x+4*s, y+12*s, x+4*s, y+13*s);
            g2.drawLine(x+4*s, y+13*s, x+6*s, y+13*s);
            g2.drawLine(x+6*s, y+13*s, x+6*s, y+12*s);
            g2.drawLine(x+6*s, y+12*s, x+7*s, y+12*s);
            g2.drawLine(x+7*s, y+12*s, x+7*s, y+11*s);
            g2.drawLine(x+7*s, y+11*s, x+8*s, y+11*s);

            //Outline of Plume
            g2.drawLine(x+2*s, y, x+4*s, y);
            g2.drawLine(x+4*s, y, x+4*s, y+2*s);
            g2.drawLine(x+4*s, y+2*s, x+5*s, y+2*s);
            g2.drawLine(x+5*s, y+2*s, x+5*s, y+5*s);
            g2.drawLine(x+4*s, y+5*s, x+4*s, y+4*s);
            g2.drawLine(x+4*s, y+4*s, x+3*s, y+4*s);
            g2.drawLine(x+3*s, y+4*s, x+3*s, y+3*s);
            g2.drawLine(x+3*s, y+3*s, x+1*s, y+3*s);
            g2.drawLine(x+1*s, y+3*s, x+1*s, y+1*s);
            g2.drawLine(x+1*s, y+1*s, x+2*s, y+1*s);
            g2.drawLine(x+2*s, y+1*s, x+2*s, y);
        }

        //StandLeft
        if(state == 1)
        {
            //Plume
            g2.setColor(c);
            g2.fillRect(x+7*s, y+0, 2*s, 1*s);
            g2.fillRect(x+7*s, y+1*s, 3*s, 2*s);
            g2.fillRect(x+6*s, y+2*s, 2*s, 2*s);
            g2.fillRect(x+6*s, y+4*s, 1*s, 1*s);

            //Legs
            g2.setColor(Color.BLACK);
            g2.fillRect(x+7*s, y+15*s, 2*s, 2*s);
            g2.fillRect(x+4*s, y+15*s, 2*s, 2*s);

            //Hands
            g2.fillRect(x+0*s, y+9*s, 2*s, 2*s);

            //Body
            g2.setColor(Color.WHITE);
            g2.fillRect(x+3*s, y+5*s, 8*s, 5*s);
            g2.fillRect(x+3*s, y+10*s, 7*s, 2*s);
            g2.fillRect(x+3*s, y+12*s, 6*s, 1*s);
            g2.fillRect(x+4*s, y+13*s, 5*s, 1*s);

            //Helmet
            g2.setColor(Color.lightGray);
            g2.fillRect(x+3*s, y+5*s, 8*s, 5*s);
            g2.fillRect(x+3*s, y+10*s, 7*s, 1*s);
            g2.fillRect(x+4*s, y+11*s, 4*s, 1*s);
            g2.fillRect(x+5*s, y+12*s, 2*s, 1*s);

            //Eyes
            g2.setColor(Color.BLACK);
            g2.fillRect(x+6*s, y+8*s, 3*s, 1*s);
            g2.fillRect(x+6*s, y+9*s, 1*s, 1*s);
            g2.fillRect(x+3*s, y+8*s, 2*s, 1*s);
            g2.fillRect(x+4*s, y+9*s, 1*s, 1*s);

            //Eyebrows
            g2.fillRect(x+6*s, y+6*s, 1*s, 1*s);
            g2.fillRect(x+4*s, y+6*s, 1*s, 1*s);

            //Outline of Body
            g2.drawLine(x+11*s, y+5*s, x+3*s, y+5*s);
            g2.drawLine(x+3*s, y+5*s, x+3*s, y+13*s);
            g2.drawLine(x+3*s, y+13*s, x+4*s, y+13*s);
            g2.drawLine(x+4*s, y+13*s, x+4*s, y+14*s);
            g2.drawLine(x+4*s, y+14*s, x+9*s, y+14*s);
            g2.drawLine(x+9*s, y+14*s, x+9*s, y+12*s);
            g2.drawLine(x+9*s, y+12*s, x+10*s, y+12*s);
            g2.drawLine(x+10*s, y+12*s, x+10*s, y+10*s);
            g2.drawLine(x+10*s, y+10*s, x+11*s, y+10*s);
            g2.drawLine(x+11*s, y+10*s, x+11*s, y+5*s);

            //Outline of Helmet
            g2.drawLine(x+10*s, y+11*s, x+8*s, y+11*s);
            g2.drawLine(x+8*s, y+11*s, x+8*s, y+12*s);
            g2.drawLine(x+8*s, y+12*s, x+7*s, y+12*s);
            g2.drawLine(x+7*s, y+12*s, x+7*s, y+13*s);
            g2.drawLine(x+7*s, y+13*s, x+5*s, y+13*s);
            g2.drawLine(x+5*s, y+13*s, x+5*s, y+12*s);
            g2.drawLine(x+5*s, y+12*s, x+4*s, y+12*s);
            g2.drawLine(x+4*s, y+12*s, x+4*s, y+11*s);
            g2.drawLine(x+4*s, y+11*s, x+3*s, y+11*s);

            //Outline of Plume
            g2.drawLine(x+9*s, y, x+7*s, y);
            g2.drawLine(x+7*s, y, x+7*s, y+2*s);
            g2.drawLine(x+7*s, y+2*s, x+6*s, y+2*s);
            g2.drawLine(x+6*s, y+2*s, x+6*s, y+5*s);
            g2.drawLine(x+7*s, y+5*s, x+7*s, y+4*s);
            g2.drawLine(x+7*s, y+4*s, x+8*s, y+4*s);
            g2.drawLine(x+8*s, y+4*s, x+8*s, y+3*s);
            g2.drawLine(x+8*s, y+3*s, x+10*s, y+3*s);
            g2.drawLine(x+10*s, y+3*s, x+10*s, y+1*s);
            g2.drawLine(x+10*s, y+1*s, x+9*s, y+1*s);
            g2.drawLine(x+9*s, y+1*s, x+9*s, y);
        }

        //JumpRight
        if(state == 2)
        {
            //Plume
            g2.setColor(c);
            for(int i = 0; i < 3; i++)
                g2.fillRect(x+i*s, y+i*s, 4*s, 1*s);

            //Legs
            g2.setColor(Color.BLACK);
            g2.fillRect(x+3*s, y+12*s, 1*s, 2*s);
            g2.fillRect(x+5*s, y+12*s, 1*s, 2*s);

            //Hand
            g2.fillRect(x+8*s, y+7*s, 2*s, 2*s);
            g2.fillRect(x+9*s, y+9*s, 1*s, 1*s);

            //Body
            g2.setColor(Color.WHITE);
            g2.fillRect(x+0, y+3*s, 8*s, 5*s);
            g2.fillRect(x+1*s, y+8*s, 7*s, 2*s);
            g2.fillRect(x+2*s, y+10*s, 6*s, 1*s);
            g2.fillRect(x+2*s, y+11*s, 5*s, 1*s);

            //Helmet
            g2.setColor(Color.lightGray);
            g2.fillRect(x+0, y+3*s, 8*s, 5*s);
            g2.fillRect(x+1*s, y+8*s, 7*s, 1*s);
            g2.fillRect(x+3*s, y+9*s, 4*s, 1*s);
            g2.fillRect(x+4*s, y+10*s, 2*s, 1*s);

            //Eyes
            g2.setColor(Color.BLACK);
            g2.fillRect(x+2*s, y+6*s, 6*s, 1*s);
            g2.fillRect(x+4*s, y+7*s, 2*s, 1*s);

            //Eyebrows
            g2.fillRect(x+2*s, y+4*s, 2*s, 1*s);
            g2.fillRect(x+5*s, y+4*s, 2*s, 1*s);

            //Outline of Body
            g2.drawLine(x+0, y+3*s, x+8*s, y+3*s);
            g2.drawLine(x+8*s, y+3*s, x+8*s, y+11*s);
            g2.drawLine(x+8*s, y+11*s, x+7*s, y+11*s);
            g2.drawLine(x+7*s, y+11*s, x+7*s, y+12*s);
            g2.drawLine(x+7*s, y+12*s, x+2*s, y+12*s);
            g2.drawLine(x+2*s, y+12*s, x+2*s, y+10*s);
            g2.drawLine(x+2*s, y+10*s, x+1*s, y+10*s);
            g2.drawLine(x+1*s, y+10*s, x+1*s, y+8*s);
            g2.drawLine(x+1*s, y+8*s, x+0, y+8*s);
            g2.drawLine(x+0, y+8*s, x+0, y+3*s);

            //Outline of Helmet
            g2.drawLine(x+1*s, y+9*s, x+3*s, y+9*s);
            g2.drawLine(x+3*s, y+9*s, x+3*s, y+10*s);
            g2.drawLine(x+3*s, y+10*s, x+4*s, y+10*s);
            g2.drawLine(x+4*s, y+10*s, x+4*s, y+11*s);
            g2.drawLine(x+4*s, y+11*s, x+6*s, y+11*s);
            g2.drawLine(x+6*s, y+11*s, x+6*s, y+10*s);
            g2.drawLine(x+6*s, y+10*s, x+7*s, y+10*s);
            g2.drawLine(x+7*s, y+10*s, x+7*s, y+9*s);
            g2.drawLine(x+7*s, y+9*s, x+8*s, y+9*s);

            //Outline of Plume
            g2.drawLine(x+0*s, y, x+4*s, y);
            g2.drawLine(x+4*s, y, x+4*s, y+1*s);
            g2.drawLine(x+4*s, y+1*s, x+5*s, y+1*s);
            g2.drawLine(x+5*s, y+1*s, x+5*s, y+2*s);
            g2.drawLine(x+5*s, y+2*s, x+6*s, y+2*s);
            g2.drawLine(x+6*s, y+2*s, x+6*s, y+3*s);
            g2.drawLine(x+2*s, y+3*s, x+2*s, y+2*s);
            g2.drawLine(x+2*s, y+2*s, x+1*s, y+2*s);
            g2.drawLine(x+1*s, y+2*s, x+1*s, y+1*s);
            g2.drawLine(x+1*s, y+1*s, x, y+1*s);
            g2.drawLine(x, y+1*s, x, y);
        }

        //JumpLeft
        if(state == 3)
        {
            //Plume
            g2.setColor(c);
            for(int i = 0; i < 3;i++)
                g2.fillRect(x+s*(6-i), y+i*s, 4*s, 1*s);

            //Legs
            g2.setColor(Color.BLACK);
            g2.fillRect(x+6*s, y+12*s, 1*s, 2*s);
            g2.fillRect(x+4*s, y+12*s, 1*s, 2*s);

            //Hand
            g2.fillRect(x+0*s, y+7*s, 2*s, 2*s);
            g2.fillRect(x+0*s, y+9*s, 1*s, 1*s);

            //Body
            g2.setColor(Color.WHITE);
            g2.fillRect(x+2*s, y+3*s, 8*s, 5*s);
            g2.fillRect(x+2*s, y+8*s, 7*s, 2*s);
            g2.fillRect(x+2*s, y+10*s, 6*s, 1*s);
            g2.fillRect(x+3*s, y+11*s, 5*s, 1*s);

            //Helmet
            g2.setColor(Color.lightGray);
            g2.fillRect(x+2*s, y+3*s, 8*s, 5*s);
            g2.fillRect(x+2*s, y+8*s, 7*s, 1*s);
            g2.fillRect(x+3*s, y+9*s, 4*s, 1*s);
            g2.fillRect(x+4*s, y+10*s, 2*s, 1*s);

            //Eyes
            g2.setColor(Color.BLACK);
            g2.fillRect(x+2*s, y+6*s, 6*s, 1*s);
            g2.fillRect(x+4*s, y+7*s, 2*s, 1*s);

            //Eyebrows
            g2.fillRect(x+6*s, y+4*s, 2*s, 1*s);
            g2.fillRect(x+3*s, y+4*s, 2*s, 1*s);

            //Outline of Body
            g2.drawLine(x+10*s, y+3*s, x+2*s, y+3*s);
            g2.drawLine(x+2*s, y+3*s, x+2*s, y+11*s);
            g2.drawLine(x+2*s, y+11*s, x+3*s, y+11*s);
            g2.drawLine(x+3*s, y+11*s, x+3*s, y+12*s);
            g2.drawLine(x+3*s, y+12*s, x+8*s, y+12*s);
            g2.drawLine(x+8*s, y+12*s, x+8*s, y+10*s);
            g2.drawLine(x+8*s, y+10*s, x+9*s, y+10*s);
            g2.drawLine(x+9*s, y+10*s, x+9*s, y+8*s);
            g2.drawLine(x+9*s, y+8*s, x+10*s, y+8*s);
            g2.drawLine(x+10*s, y+8*s, x+10*s, y+3*s);

            //Outline of Helmet
            g2.drawLine(x+9*s, y+9*s, x+7*s, y+9*s);
            g2.drawLine(x+7*s, y+9*s, x+7*s, y+10*s);
            g2.drawLine(x+7*s, y+10*s, x+6*s, y+10*s);
            g2.drawLine(x+6*s, y+10*s, x+6*s, y+11*s);
            g2.drawLine(x+6*s, y+11*s, x+4*s, y+11*s);
            g2.drawLine(x+4*s, y+11*s, x+4*s, y+10*s);
            g2.drawLine(x+4*s, y+10*s, x+3*s, y+10*s);
            g2.drawLine(x+3*s, y+10*s, x+3*s, y+9*s);
            g2.drawLine(x+3*s, y+9*s, x+2*s, y+9*s);

            //Outline of Plume
            g2.drawLine(x+10*s, y, x+6*s, y);
            g2.drawLine(x+6*s, y, x+6*s, y+1*s);
            g2.drawLine(x+6*s, y+1*s, x+5*s, y+1*s);
            g2.drawLine(x+5*s, y+1*s, x+5*s, y+2*s);
            g2.drawLine(x+5*s, y+2*s, x+4*s, y+2*s);
            g2.drawLine(x+4*s, y+2*s, x+4*s, y+3*s);
            g2.drawLine(x+8*s, y+3*s, x+8*s, y+2*s);
            g2.drawLine(x+8*s, y+2*s, x+9*s, y+2*s);
            g2.drawLine(x+9*s, y+2*s, x+9*s, y+1*s);
            g2.drawLine(x+9*s, y+1*s, x+10*s, y+1*s);
            g2.drawLine(x+10*s, y+1*s, x+10*s, y);
        }

        //CrouchRight
        if(state == 4)
        {

            //Plume
            g2.setColor(c);
            g2.fillRect(x+2*s, y+0, 6*s, 1*s);
            g2.fillRect(x+3*s, y+1*s, 4*s, 1*s);
            g2.fillRect(x+4*s, y+2*s, 2*s, 1*s);

            //Legs
            g2.setColor(Color.BLACK);
            g2.fillRect(x+2*s, y+12*s, 2*s, 1*s);
            g2.fillRect(x+5*s, y+12*s, 2*s, 1*s);

            //Hands
            g2.fillRect(x+9*s, y+8*s, 1*s, 1*s);
            g2.fillRect(x+8*s, y+9*s, 2*s, 2*s);

            //Body
            g2.setColor(Color.WHITE);
            g2.fillRect(x+0, y+3*s, 8*s, 5*s);
            g2.fillRect(x+1*s, y+8*s, 7*s, 2*s);
            g2.fillRect(x+2*s, y+10*s, 6*s, 1*s);
            g2.fillRect(x+2*s, y+11*s, 5*s, 1*s);

            //Helmet
            g2.setColor(Color.lightGray);
            g2.fillRect(x+0, y+3*s, 8*s, 5*s);
            g2.fillRect(x+1*s, y+8*s, 7*s, 1*s);
            g2.fillRect(x+3*s, y+9*s, 4*s, 1*s);
            g2.fillRect(x+4*s, y+10*s, 2*s, 1*s);

            //Eyes
            g2.setColor(Color.BLACK);
            g2.fillRect(x+4*s, y+7*s, 1*s, 1*s);
            g2.fillRect(x+2*s, y+6*s, 3*s, 1*s);
            g2.fillRect(x+6*s, y+7*s, 1*s, 1*s);
            g2.fillRect(x+6*s, y+6*s, 2*s, 1*s);

            //Eyebrows
            g2.fillRect(x+4*s, y+4*s, 1*s, 1*s);
            g2.fillRect(x+6*s, y+4*s, 1*s, 1*s);
            
            //Outline of Body
            g2.drawLine(x+0, y+3*s, x+8*s, y+3*s);
            g2.drawLine(x+8*s, y+3*s, x+8*s, y+11*s);
            g2.drawLine(x+8*s, y+11*s, x+7*s, y+11*s);
            g2.drawLine(x+7*s, y+11*s, x+7*s, y+12*s);
            g2.drawLine(x+7*s, y+12*s, x+2*s, y+12*s);
            g2.drawLine(x+2*s, y+12*s, x+2*s, y+10*s);
            g2.drawLine(x+2*s, y+10*s, x+1*s, y+10*s);
            g2.drawLine(x+1*s, y+10*s, x+1*s, y+8*s);
            g2.drawLine(x+1*s, y+8*s, x+0, y+8*s);
            g2.drawLine(x+0, y+8*s, x+0, y+3*s);

            //Outline of Helmet
            g2.drawLine(x+1*s, y+9*s, x+3*s, y+9*s);
            g2.drawLine(x+3*s, y+9*s, x+3*s, y+10*s);
            g2.drawLine(x+3*s, y+10*s, x+4*s, y+10*s);
            g2.drawLine(x+4*s, y+10*s, x+4*s, y+11*s);
            g2.drawLine(x+4*s, y+11*s, x+6*s, y+11*s);
            g2.drawLine(x+6*s, y+11*s, x+6*s, y+10*s);
            g2.drawLine(x+6*s, y+10*s, x+7*s, y+10*s);
            g2.drawLine(x+7*s, y+10*s, x+7*s, y+9*s);
            g2.drawLine(x+7*s, y+9*s, x+8*s, y+9*s);

            //Outline of Plume
            g2.drawLine(x+2*s, y, x+8*s, y);
            g2.drawLine(x+8*s, y, x+8*s, y+1*s);
            g2.drawLine(x+8*s, y+1*s, x+7*s, y+1*s);
            g2.drawLine(x+7*s, y+1*s, x+7*s, y+2*s);
            g2.drawLine(x+7*s, y+2*s, x+6*s, y+2*s);
            g2.drawLine(x+6*s, y+2*s, x+6*s, y+3*s);
            g2.drawLine(x+6*s, y+3*s, x+4*s, y+3*s);
            g2.drawLine(x+4*s, y+3*s, x+4*s, y+2*s);
            g2.drawLine(x+4*s, y+2*s, x+3*s, y+2*s);
            g2.drawLine(x+3*s, y+2*s, x+3*s, y+1*s);
            g2.drawLine(x+3*s, y+1*s, x+2*s, y+1*s);
            g2.drawLine(x+2*s, y+1*s, x+2*s, y);
        }

        //CrouchLeft
        if(state == 5)
        {

            //Plume
            g2.setColor(c);
            g2.fillRect(x+2*s, y+0, 6*s, 1*s);
            g2.fillRect(x+3*s, y+1*s, 4*s, 1*s);
            g2.fillRect(x+4*s, y+2*s, 2*s, 1*s);

            //Legs
            g2.setColor(Color.BLACK);
            g2.fillRect(x+6*s, y+12*s, 2*s, 1*s);
            g2.fillRect(x+3*s, y+12*s, 2*s, 1*s);

            //Hands
            g2.fillRect(x+0*s, y+8*s, 1*s, 1*s);
            g2.fillRect(x+0*s, y+9*s, 2*s, 2*s);

            //Body
            g2.setColor(Color.WHITE);
            g2.fillRect(x+2*s, y+3*s, 8*s, 5*s);
            g2.fillRect(x+2*s, y+8*s, 7*s, 2*s);
            g2.fillRect(x+2*s, y+10*s, 6*s, 1*s);
            g2.fillRect(x+3*s, y+11*s, 5*s, 1*s);

            //Helmet
            g2.setColor(Color.lightGray);
            g2.fillRect(x+2*s, y+3*s, 8*s, 5*s);
            g2.fillRect(x+2*s, y+8*s, 7*s, 1*s);
            g2.fillRect(x+3*s, y+9*s, 4*s, 1*s);
            g2.fillRect(x+4*s, y+10*s, 2*s, 1*s);

                        //Eyes
            g2.setColor(Color.BLACK);
            g2.fillRect(x+5*s, y+7*s, 1*s, 1*s);
            g2.fillRect(x+5*s, y+6*s, 3*s, 1*s);
            g2.fillRect(x+3*s, y+7*s, 1*s, 1*s);
            g2.fillRect(x+2*s, y+6*s, 2*s, 1*s);

            //Eyebrows
            g2.fillRect(x+5*s, y+4*s, 1*s, 1*s);
            g2.fillRect(x+3*s, y+4*s, 1*s, 1*s);

            //Outline of Body
            g2.drawLine(x+10*s, y+3*s, x+2*s, y+3*s);
            g2.drawLine(x+2*s, y+3*s, x+2*s, y+11*s);
            g2.drawLine(x+2*s, y+11*s, x+3*s, y+11*s);
            g2.drawLine(x+3*s, y+11*s, x+3*s, y+12*s);
            g2.drawLine(x+3*s, y+12*s, x+8*s, y+12*s);
            g2.drawLine(x+8*s, y+12*s, x+8*s, y+10*s);
            g2.drawLine(x+8*s, y+10*s, x+9*s, y+10*s);
            g2.drawLine(x+9*s, y+10*s, x+9*s, y+8*s);
            g2.drawLine(x+9*s, y+8*s, x+10*s, y+8*s);
            g2.drawLine(x+10*s, y+8*s, x+10*s, y+3*s);

            //Outline of Helmet
            g2.drawLine(x+9*s, y+9*s, x+7*s, y+9*s);
            g2.drawLine(x+7*s, y+9*s, x+7*s, y+10*s);
            g2.drawLine(x+7*s, y+10*s, x+6*s, y+10*s);
            g2.drawLine(x+6*s, y+10*s, x+6*s, y+11*s);
            g2.drawLine(x+6*s, y+11*s, x+4*s, y+11*s);
            g2.drawLine(x+4*s, y+11*s, x+4*s, y+10*s);
            g2.drawLine(x+4*s, y+10*s, x+3*s, y+10*s);
            g2.drawLine(x+3*s, y+10*s, x+3*s, y+9*s);
            g2.drawLine(x+3*s, y+9*s, x+2*s, y+9*s);

            //Outline of Plume
            g2.drawLine(x+8*s, y, x+2*s, y);
            g2.drawLine(x+2*s, y, x+2*s, y+1*s);
            g2.drawLine(x+2*s, y+1*s, x+3*s, y+1*s);
            g2.drawLine(x+3*s, y+1*s, x+3*s, y+2*s);
            g2.drawLine(x+3*s, y+2*s, x+4*s, y+2*s);
            g2.drawLine(x+4*s, y+2*s, x+4*s, y+3*s);
            g2.drawLine(x+4*s, y+3*s, x+6*s, y+3*s);
            g2.drawLine(x+6*s, y+3*s, x+6*s, y+2*s);
            g2.drawLine(x+6*s, y+2*s, x+7*s, y+2*s);
            g2.drawLine(x+7*s, y+2*s, x+7*s, y+1*s);
            g2.drawLine(x+7*s, y+1*s, x+8*s, y+1*s);
            g2.drawLine(x+8*s, y+1*s, x+8*s, y);
        }
    }
}