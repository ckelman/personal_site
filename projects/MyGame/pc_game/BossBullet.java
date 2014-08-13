import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.*;

public class BossBullet extends Bullet
{
    public BossBullet(int x,int y)
    {
        super(x,y,5,5,3,70,5,true);
    }

    public void move()
    {
        int i = (int) (Math.random()*27-13);
        int j = (int) (Math.random()*27-13);
        
        

             setX(getXInt()+i);
             setY(getYInt()+j);
             
             if(getIsPLeft())
             setX(getX()-getSpeed());
             if(getIsPRight())
             setX(getX()+getSpeed());
            if(getIsUp())
             setY(getY()-getSpeed());
                         if(getIsDown())
             setY(getY()+getSpeed());
        

//         if(getIsFacingRight()&&!getIsUp()&&!getIsDown())
//         {
//             setX(getXInt()+10-Math.abs(i));
//             setY(getYInt()+i);
// 
//         }
// 
//         else if(!getIsUp()&&!getIsDown())
//         {
//             setX(getXInt()+-1*(10-Math.abs(i)));
//             setY(getYInt()+i);
//         } 
// 
//         if(getIsUp()&&!getIsPRight()&&!getIsPLeft())
//         {
//             setY(getY()-getSpeed());
//             setX(getXInt()+i);
// 
//         }
// 
//         if(getIsDown()&!getIsPRight()&&!getIsPLeft())
//         {
//             setY(getY()+getSpeed());
//             setX(getXInt()+i);
// 
//         }
// 
//         if(getIsUp()&&getIsPRight())
//         {
//             setX(getXInt()+(10-Math.abs(i))/2);
//             setY(getYInt()-(10-Math.abs(j))/2);
//         }
// 
//         if(getIsUp()&&getIsPLeft())
//         {
//             setX(getXInt()-(10-Math.abs(i))/2);
//             setY(getYInt()-(10-Math.abs(j))/2);
//         }
// 
//         if(getIsDown()&&getIsPLeft())
//         {
//             setX(getXInt()-(10-Math.abs(i))/2);
//             setY(getYInt()+(10-Math.abs(j))/2);
//         }
//         if(getIsDown()&&getIsPRight())
//         {
//             setX(getXInt()+(10-Math.abs(i))/2);
//             setY(getYInt()+(10-Math.abs(j))/2);
//         }

        setDistanceCount(getDistanceCount()+1);

    }

    public void draw(Graphics2D g2)
    {
        int i = (int)(Math.random()*2);
        if (i==0)
            g2.setColor(Color.red);
        else if(i==1)
            g2.setColor(Color.yellow);

        g2.fillOval(getXInt(),getYInt(),getHeight(),getWidth());

        g2.setColor(Color.black);
        g2.drawOval(getXInt(),getYInt(),getHeight(),getWidth());

    }

}