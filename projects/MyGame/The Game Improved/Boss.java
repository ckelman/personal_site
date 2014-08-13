import java.util.*;
import java.applet.*;
import java.awt.*;

public class Boss extends Person
{
private int bossAttack;
private int bossTimer;
private int state;

    public Boss(int x, int y)
    {
        super(x,y,100,100,1000,null);
        bossAttack = 0;
        bossTimer = 200;
        state = 0;

    }

    public void attack1(MainCharacter m, ArrayList<Bullet> bullets)
    {
        if(bossAttack<200)
        {
        int mx = m.getXInt();
        int my = m.getYInt();

        if(getGun()instanceof BossGun)
        {
            BossBullet b = getGun().shootb();
            if(mx<400)
            {
                b.setIsPLeft(true);
                state = 0;
            }
            else
                b.setIsPLeft(false);

            if(mx>550)
            {
                b.setIsPRight(true);
                state = 1;
            }
            else
                b.setIsPRight(false);

            if(my<150)
                b.setIsUp(true);
            else
                b.setIsUp(false);

            if(my>300)
                b.setIsDown(true);
            else
                b.setIsDown(false);
                
                bossAttack++;

            bullets.add(b);
            
        }
    }
    }
    
    public int getBossAttack()
    {
        return bossAttack;
    }
    
    public int getBossTimer()
    {
        return bossTimer;
    }
    
    public void setBossAttack(int i)
    {
        bossAttack = i;
    }
    
    public void setBossTimer(int i)
    {
        bossTimer = i;
    }


    public void pace(ArrayList<Platform> ground)
    {
        if(bossTimer <=0)
        {
            bossAttack = 0;
            bossTimer = 200;
        }
        
        
        if(bossAttack>=200)
            bossTimer--;
            
            
    }

    public void draw(Graphics2D g2)
    {
        int x = getXInt();
        int y = getYInt();
        int s = 4;
        
        
            if(state == 0)
            {
            //Top Head Color
            g2.setColor(Color.RED);
            g2.fillRect(x+6*s, y+1*s, s*10, s);
            g2.fillRect(x+6*s, y+2*s, s*11, s);
            g2.fillRect(x+6*s, y+3*s, s*8, s*3);
            g2.fillRect(x+4*s, y+4*s, s*10, s*2);
            g2.fillRect(x+1*s, y+5*s, s*9, s*2);
            g2.fillRect(x+0*s, y+6*s, s*8, s*2);

            //Jaw
            g2.fillRect(x+1*s, y+11*s, s*7, s);
            g2.fillRect(x+7*s, y+10*s, s*4, s);
            g2.fillRect(x+9*s, y+9*s, s*3, s);
            g2.fillRect(x+11*s, y+8*s, s, s);

            //Neck and Body
            g2.fillRect(x+12*s, y+1*s, s*2, s*15);
            g2.fillRect(x+11*s, y+13*s, s, s);
            g2.fillRect(x+11*s, y+16*s, s*4, s*6);
            g2.fillRect(x+11*s, y+22*s, s, s*2);
            g2.fillRect(x+14*s, y+22*s, s, s*2);
            g2.setColor(Color.PINK);
            g2.fillRect(x+12*s, y+18*s, s*2, s*3);

            //Teeth!
            g2.setColor(Color.WHITE);            
            g2.fillRect(x+0*s, y+8*s, s, s);
            g2.fillRect(x+5*s, y+8*s, s, s);
            g2.fillRect(x+1*s, y+10*s, s, s);
            g2.fillRect(x+5*s, y+10*s, s, s);

            //Eye Color
            g2.fillRect(x+6*s, y+1*s, s*3, s*3);
            g2.fillRect(x+9*s, y+0*s, s*3, s*4);
            g2.setColor(Color.BLACK);
            g2.fillRect(x+7*s, y+2*s, s*2, s*2);
            g2.fillRect(x+10*s, y+1*s, s*2, s*3);

            //Wing Color
            //Wing Color
            g2.setColor(Color.RED);
            g2.fillRect(x+0*s, y+15*s, s, s*8);
            g2.fillRect(x+1*s, y+16*s, s*4, s*5);
            g2.fillRect(x+5*s, y+15*s, s, s*7);
            g2.fillRect(x+6*s, y+16*s, s*2, s*3);
            g2.fillRect(x+8*s, y+15*s, s, s*5);
            g2.fillRect(x+9*s, y+16*s, s*2, s);
            g2.fillRect(x+15*s, y+16*s, s*2, s);
            g2.fillRect(x+17*s, y+15*s, s, s*5);
            g2.fillRect(x+18*s, y+16*s, s*2, s*3);
            g2.fillRect(x+20*s, y+15*s, s, s*7);
            g2.fillRect(x+21*s, y+16*s, s*4, s*5);
            g2.fillRect(x+25*s, y+15*s, s, s*8);

            //From Right side of Eye to end of Right side of Neck
            g2.setColor(Color.BLACK);
            g2.drawLine(x+12*s, y+1*s, x+16*s, y+1*s);
            g2.drawLine(x+16*s, y+1*s, x+16*s, y+2*s);
            g2.drawLine(x+14*s, y+2*s, x+17*s, y+2*s);
            g2.drawLine(x+17*s, y+2*s, x+17*s, y+3*s);
            g2.drawLine(x+17*s, y+3*s, x+14*s, y+3*s);
            g2.drawLine(x+14*s, y+3*s, x+14*s, y+16*s);

            //Right Wing Outline
            g2.drawLine(x+14*s, y+16*s, x+17*s, y+16*s);
            g2.drawLine(x+17*s, y+16*s, x+17*s, y+15*s);
            g2.drawLine(x+17*s, y+15*s, x+18*s, y+15*s);
            g2.drawLine(x+18*s, y+15*s, x+18*s, y+16*s);
            g2.drawLine(x+18*s, y+16*s, x+20*s, y+16*s);
            g2.drawLine(x+20*s, y+16*s, x+20*s, y+15*s);
            g2.drawLine(x+20*s, y+15*s, x+21*s, y+15*s);
            g2.drawLine(x+21*s, y+15*s, x+21*s, y+16*s);
            g2.drawLine(x+21*s, y+16*s, x+25*s, y+16*s);
            g2.drawLine(x+25*s, y+16*s, x+25*s, y+15*s);
            g2.drawLine(x+25*s, y+15*s, x+26*s, y+15*s);
            g2.drawLine(x+26*s, y+15*s, x+26*s, y+23*s);
            g2.drawLine(x+26*s, y+23*s, x+25*s, y+23*s);
            g2.drawLine(x+25*s, y+23*s, x+25*s, y+21*s);
            g2.drawLine(x+25*s, y+21*s, x+21*s, y+21*s);
            g2.drawLine(x+21*s, y+21*s, x+21*s, y+22*s);
            g2.drawLine(x+21*s, y+22*s, x+20*s, y+22*s);
            g2.drawLine(x+20*s, y+22*s, x+20*s, y+19*s);
            g2.drawLine(x+20*s, y+19*s, x+18*s, y+19*s);
            g2.drawLine(x+18*s, y+19*s, x+18*s, y+20*s);
            g2.drawLine(x+18*s, y+20*s, x+17*s, y+20*s);
            g2.drawLine(x+17*s, y+20*s, x+17*s, y+17*s);
            g2.drawLine(x+17*s, y+17*s, x+15*s, y+17*s);

            //Body Outline
            g2.drawLine(x+15*s, y+17*s, x+15*s, y+24*s);
            g2.drawLine(x+15*s, y+24*s, x+14*s, y+24*s);
            g2.drawLine(x+14*s, y+24*s, x+14*s, y+22*s);
            g2.drawLine(x+14*s, y+22*s, x+12*s, y+22*s);
            g2.drawLine(x+12*s, y+22*s, x+12*s, y+24*s);   
            g2.drawLine(x+12*s, y+24*s, x+11*s, y+24*s);
            g2.drawLine(x+11*s, y+24*s, x+11*s, y+17*s);

            //Left Wing Outline
            g2.drawLine(x+11*s, y+17*s, x+9*s, y+17*s);
            g2.drawLine(x+9*s, y+17*s, x+9*s, y+20*s);
            g2.drawLine(x+9*s, y+20*s, x+8*s, y+20*s);
            g2.drawLine(x+8*s, y+20*s, x+8*s, y+19*s);
            g2.drawLine(x+8*s, y+19*s, x+6*s, y+19*s);
            g2.drawLine(x+6*s, y+19*s, x+6*s, y+22*s);
            g2.drawLine(x+6*s, y+22*s, x+5*s, y+22*s);
            g2.drawLine(x+5*s, y+22*s, x+5*s, y+21*s);
            g2.drawLine(x+5*s, y+21*s, x+1*s, y+21*s);
            g2.drawLine(x+1*s, y+21*s, x+1*s, y+23*s);
            g2.drawLine(x+1*s, y+23*s, x+0*s, y+23*s);
            g2.drawLine(x+0*s, y+23*s, x+0*s, y+15*s);
            g2.drawLine(x+0*s, y+15*s, x+1*s, y+15*s);
            g2.drawLine(x+1*s, y+15*s, x+1*s, y+16*s);
            g2.drawLine(x+1*s, y+16*s, x+5*s, y+16*s);
            g2.drawLine(x+5*s, y+16*s, x+5*s, y+15*s);
            g2.drawLine(x+5*s, y+15*s, x+6*s, y+15*s);
            g2.drawLine(x+6*s, y+15*s, x+6*s, y+16*s);
            g2.drawLine(x+6*s, y+16*s, x+8*s, y+16*s);
            g2.drawLine(x+8*s, y+16*s, x+8*s, y+15*s);
            g2.drawLine(x+8*s, y+15*s, x+9*s, y+15*s);
            g2.drawLine(x+9*s, y+15*s, x+9*s, y+16*s);
            g2.drawLine(x+9*s, y+16*s, x+12*s, y+16*s);

            //Left side of Neck Outline
            g2.drawLine(x+12*s, y+16*s, x+12*s, y+14*s);
            g2.drawLine(x+12*s, y+14*s, x+11*s, y+14*s);
            g2.drawLine(x+11*s, y+14*s, x+11*s, y+13*s);
            g2.drawLine(x+11*s, y+13*s, x+12*s, y+13*s);
            g2.drawLine(x+12*s, y+13*s, x+12*s, y+10*s);

            //Outlining Teeth (if already not done)
            g2.drawRect(x+1*s, y+10*s, s, s);
            g2.drawRect(x+5*s, y+10*s, s, s);
            g2.drawRect(x+0*s, y+8*s, s, s);
            g2.drawRect(x+5*s, y+8*s, s, s);

            //Head Outline
            g2.drawLine(x+12*s, y+10*s, x+11*s, y+10*s);
            g2.drawLine(x+11*s, y+10*s, x+11*s, y+11*s);
            g2.drawLine(x+11*s, y+11*s, x+8*s, y+11*s);
            g2.drawLine(x+8*s, y+11*s, x+8*s, y+12*s);
            g2.drawLine(x+8*s, y+12*s, x+1*s, y+12*s);
            g2.drawLine(x+1*s, y+12*s, x+1*s, y+11*s);
            g2.drawLine(x+1*s, y+11*s, x+7*s, y+11*s);
            g2.drawLine(x+7*s, y+11*s, x+7*s, y+10*s);
            g2.drawLine(x+7*s, y+10*s, x+9*s, y+10*s);
            g2.drawLine(x+9*s, y+10*s, x+9*s, y+9*s);
            g2.drawLine(x+9*s, y+9*s, x+11*s, y+9*s);
            g2.drawLine(x+11*s, y+9*s, x+11*s, y+8*s);
            g2.drawLine(x+11*s, y+8*s, x+12*s, y+8*s);
            g2.drawLine(x+12*s, y+8*s, x+12*s, y+6*s);
            g2.drawLine(x+12*s, y+6*s, x+10*s, y+6*s);
            g2.drawLine(x+10*s, y+6*s, x+10*s, y+7*s);
            g2.drawLine(x+10*s, y+7*s, x+8*s, y+7*s);
            g2.drawLine(x+8*s, y+7*s, x+8*s, y+8*s);
            g2.drawLine(x+8*s, y+8*s, x+0*s, y+8*s);
            g2.drawLine(x+0*s, y+8*s, x+0*s, y+6*s);
            g2.drawLine(x+0*s, y+6*s, x+1*s, y+6*s);
            g2.drawLine(x+1*s, y+6*s, x+1*s, y+5*s);
            g2.drawLine(x+1*s, y+5*s, x+4*s, y+5*s);
            g2.drawLine(x+4*s, y+5*s, x+4*s, y+4*s);
            g2.drawLine(x+4*s, y+4*s, x+6*s, y+4*s);
            
            //NOSTRILS!
            g2.drawRect(x+0*s, y+6*s, 2*s, 2*s);
            g2.drawRect(x+4*s, y+6*s, 2*s, 2*s);
            g2.drawLine(x+1*s, y+7*s, x+1*s, y+8*s);
            g2.drawLine(x+5*s, y+7*s, x+5*s, y+8*s);
            
            //Eye Outline
            g2.drawRect(x+6*s, y+1*s, 3*s, 3*s);
            g2.drawRect(x+9*s, y, 3*s, 4*s);
            
            //Belly Outline
            g2.drawRect(x+12*s, y+18*s, 2*s, 3*s);
        }
        

        
        
        
        if(state == 1)
        {
            //Top Head Color
            g2.setColor(Color.RED);
            g2.fillRect(x+10*s, y+1*s, s*10, s);
            g2.fillRect(x+9*s, y+2*s, s*11, s);
            g2.fillRect(x+12*s, y+3*s, s*8, s*3);
            g2.fillRect(x+12*s, y+4*s, s*10, s*2);
            g2.fillRect(x+16*s, y+5*s, s*9, s*2);
            g2.fillRect(x+18*s, y+6*s, s*8, s*2);

            //Jaw
            g2.fillRect(x+18*s, y+11*s, s*7, s);
            g2.fillRect(x+15*s, y+10*s, s*4, s);
            g2.fillRect(x+14*s, y+9*s, s*3, s);
            g2.fillRect(x+14*s, y+8*s, s, s);

            //Neck and Body
            g2.fillRect(x+12*s, y+1*s, s*2, s*15);
            g2.fillRect(x+14*s, y+13*s, s, s);
            g2.fillRect(x+11*s, y+16*s, s*4, s*6);
            g2.fillRect(x+11*s, y+22*s, s, s*2);
            g2.fillRect(x+14*s, y+22*s, s, s*2);
            g2.setColor(Color.PINK);
            g2.fillRect(x+12*s, y+18*s, s*2, s*3);

            //Teeth!
            g2.setColor(Color.WHITE);            
            g2.fillRect(x+25*s, y+8*s, s, s);
            g2.fillRect(x+20*s, y+8*s, s, s);
            g2.fillRect(x+24*s, y+10*s, s, s);
            g2.fillRect(x+20*s, y+10*s, s, s);

            //Eye Color
            g2.fillRect(x+17*s, y+1*s, s*3, s*3);
            g2.fillRect(x+14*s, y+0*s, s*3, s*4);
            g2.setColor(Color.BLACK);
            g2.fillRect(x+17*s, y+2*s, s*2, s*2);
            g2.fillRect(x+14*s, y+1*s, s*2, s*3);

            //Wing Color
            g2.setColor(Color.RED);
            g2.fillRect(x+0*s, y+15*s, s, s*8);
            g2.fillRect(x+1*s, y+16*s, s*4, s*5);
            g2.fillRect(x+5*s, y+15*s, s, s*7);
            g2.fillRect(x+6*s, y+16*s, s*2, s*3);
            g2.fillRect(x+8*s, y+15*s, s, s*5);
            g2.fillRect(x+9*s, y+16*s, s*2, s);
            g2.fillRect(x+15*s, y+16*s, s*2, s);
            g2.fillRect(x+17*s, y+15*s, s, s*5);
            g2.fillRect(x+18*s, y+16*s, s*2, s*3);
            g2.fillRect(x+20*s, y+15*s, s, s*7);
            g2.fillRect(x+21*s, y+16*s, s*4, s*5);
            g2.fillRect(x+25*s, y+15*s, s, s*8);

            //From Right side of Eye to end of Right side of Neck
            g2.setColor(Color.BLACK);
            g2.drawLine(x+14*s, y+1*s, x+10*s, y+1*s);
            g2.drawLine(x+10*s, y+1*s, x+10*s, y+2*s);
            g2.drawLine(x+12*s, y+2*s, x+9*s, y+2*s);
            g2.drawLine(x+9*s, y+2*s, x+9*s, y+3*s);
            g2.drawLine(x+9*s, y+3*s, x+12*s, y+3*s);
            g2.drawLine(x+12*s, y+3*s, x+12*s, y+16*s);

            //Right Wing Outline
            g2.drawLine(x+14*s, y+16*s, x+17*s, y+16*s);
            g2.drawLine(x+17*s, y+16*s, x+17*s, y+15*s);
            g2.drawLine(x+17*s, y+15*s, x+18*s, y+15*s);
            g2.drawLine(x+18*s, y+15*s, x+18*s, y+16*s);
            g2.drawLine(x+18*s, y+16*s, x+20*s, y+16*s);
            g2.drawLine(x+20*s, y+16*s, x+20*s, y+15*s);
            g2.drawLine(x+20*s, y+15*s, x+21*s, y+15*s);
            g2.drawLine(x+21*s, y+15*s, x+21*s, y+16*s);
            g2.drawLine(x+21*s, y+16*s, x+25*s, y+16*s);
            g2.drawLine(x+25*s, y+16*s, x+25*s, y+15*s);
            g2.drawLine(x+25*s, y+15*s, x+26*s, y+15*s);
            g2.drawLine(x+26*s, y+15*s, x+26*s, y+23*s);
            g2.drawLine(x+26*s, y+23*s, x+25*s, y+23*s);
            g2.drawLine(x+25*s, y+23*s, x+25*s, y+21*s);
            g2.drawLine(x+25*s, y+21*s, x+21*s, y+21*s);
            g2.drawLine(x+21*s, y+21*s, x+21*s, y+22*s);
            g2.drawLine(x+21*s, y+22*s, x+20*s, y+22*s);
            g2.drawLine(x+20*s, y+22*s, x+20*s, y+19*s);
            g2.drawLine(x+20*s, y+19*s, x+18*s, y+19*s);
            g2.drawLine(x+18*s, y+19*s, x+18*s, y+20*s);
            g2.drawLine(x+18*s, y+20*s, x+17*s, y+20*s);
            g2.drawLine(x+17*s, y+20*s, x+17*s, y+17*s);
            g2.drawLine(x+17*s, y+17*s, x+15*s, y+17*s);

            //Body Outline
            g2.drawLine(x+15*s, y+17*s, x+15*s, y+24*s);
            g2.drawLine(x+15*s, y+24*s, x+14*s, y+24*s);
            g2.drawLine(x+14*s, y+24*s, x+14*s, y+22*s);
            g2.drawLine(x+14*s, y+22*s, x+12*s, y+22*s);
            g2.drawLine(x+12*s, y+22*s, x+12*s, y+24*s);
            g2.drawLine(x+12*s, y+24*s, x+11*s, y+24*s);
            g2.drawLine(x+11*s, y+24*s, x+11*s, y+17*s);

            //Left Wing Outline
            g2.drawLine(x+11*s, y+17*s, x+9*s, y+17*s);
            g2.drawLine(x+9*s, y+17*s, x+9*s, y+20*s);
            g2.drawLine(x+9*s, y+20*s, x+8*s, y+20*s);
            g2.drawLine(x+8*s, y+20*s, x+8*s, y+19*s);
            g2.drawLine(x+8*s, y+19*s, x+6*s, y+19*s);
            g2.drawLine(x+6*s, y+19*s, x+6*s, y+22*s);
            g2.drawLine(x+6*s, y+22*s, x+5*s, y+22*s);
            g2.drawLine(x+5*s, y+22*s, x+5*s, y+21*s);
            g2.drawLine(x+5*s, y+21*s, x+1*s, y+21*s);
            g2.drawLine(x+1*s, y+21*s, x+1*s, y+23*s);
            g2.drawLine(x+1*s, y+23*s, x+0*s, y+23*s);
            g2.drawLine(x+0*s, y+23*s, x+0*s, y+15*s);
            g2.drawLine(x+0*s, y+15*s, x+1*s, y+15*s);
            g2.drawLine(x+1*s, y+15*s, x+1*s, y+16*s);
            g2.drawLine(x+1*s, y+16*s, x+5*s, y+16*s);
            g2.drawLine(x+5*s, y+16*s, x+5*s, y+15*s);
            g2.drawLine(x+5*s, y+15*s, x+6*s, y+15*s);
            g2.drawLine(x+6*s, y+15*s, x+6*s, y+16*s);
            g2.drawLine(x+6*s, y+16*s, x+8*s, y+16*s);
            g2.drawLine(x+8*s, y+16*s, x+8*s, y+15*s);
            g2.drawLine(x+8*s, y+15*s, x+9*s, y+15*s);
            g2.drawLine(x+9*s, y+15*s, x+9*s, y+16*s);
            g2.drawLine(x+9*s, y+16*s, x+12*s, y+16*s);

            //Left side of Neck Outline
            g2.drawLine(x+14*s, y+16*s, x+14*s, y+14*s);
            g2.drawLine(x+14*s, y+14*s, x+15*s, y+14*s);
            g2.drawLine(x+15*s, y+14*s, x+15*s, y+13*s);
            g2.drawLine(x+15*s, y+13*s, x+14*s, y+13*s);
            g2.drawLine(x+14*s, y+13*s, x+14*s, y+10*s);

            //Outlining Teeth (if already not done)
            g2.drawRect(x+24*s, y+10*s, s, s);
            g2.drawRect(x+20*s, y+10*s, s, s);
            g2.drawRect(x+25*s, y+8*s, s, s);
            g2.drawRect(x+20*s, y+8*s, s, s);

            //Head Outline
            g2.drawLine(x+14*s, y+10*s, x+15*s, y+10*s);
            g2.drawLine(x+15*s, y+10*s, x+15*s, y+11*s);
            g2.drawLine(x+15*s, y+11*s, x+18*s, y+11*s);
            g2.drawLine(x+18*s, y+11*s, x+18*s, y+12*s);
            g2.drawLine(x+18*s, y+12*s, x+25*s, y+12*s);
            g2.drawLine(x+25*s, y+12*s, x+25*s, y+11*s);
            g2.drawLine(x+25*s, y+11*s, x+19*s, y+11*s);
            g2.drawLine(x+19*s, y+11*s, x+19*s, y+10*s);
            g2.drawLine(x+19*s, y+10*s, x+17*s, y+10*s);
            g2.drawLine(x+17*s, y+10*s, x+17*s, y+9*s);
            g2.drawLine(x+17*s, y+9*s, x+15*s, y+9*s);
            g2.drawLine(x+15*s, y+9*s, x+15*s, y+8*s);
            g2.drawLine(x+15*s, y+8*s, x+14*s, y+8*s);
            g2.drawLine(x+14*s, y+8*s, x+14*s, y+6*s);
            g2.drawLine(x+14*s, y+6*s, x+16*s, y+6*s);
            g2.drawLine(x+16*s, y+6*s, x+16*s, y+7*s);
            g2.drawLine(x+16*s, y+7*s, x+18*s, y+7*s);
            g2.drawLine(x+18*s, y+7*s, x+18*s, y+8*s);
            g2.drawLine(x+18*s, y+8*s, x+26*s, y+8*s);
            g2.drawLine(x+26*s, y+8*s, x+26*s, y+6*s);
            g2.drawLine(x+26*s, y+6*s, x+25*s, y+6*s);
            g2.drawLine(x+25*s, y+6*s, x+25*s, y+5*s);
            g2.drawLine(x+25*s, y+5*s, x+22*s, y+5*s);
            g2.drawLine(x+22*s, y+5*s, x+22*s, y+4*s);
            g2.drawLine(x+22*s, y+4*s, x+20*s, y+4*s);
            
            //NOSTRILS!
            g2.drawRect(x+24*s, y+6*s, 2*s, 2*s);
            g2.drawRect(x+20*s, y+6*s, 2*s, 2*s);
            g2.drawLine(x+25*s, y+7*s, x+25*s, y+8*s);
            g2.drawLine(x+21*s, y+7*s, x+21*s, y+8*s);
            
            //Eye Outline
            g2.drawRect(x+17*s, y+1*s, 3*s, 3*s);
            g2.drawRect(x+14*s, y, 3*s, 4*s);
            
            //Belly Outline
            g2.drawRect(x+12*s, y+18*s, 2*s, 3*s);

        }

        
                g2.setColor(Color.red);   
        g2.fillRect(getXInt(),getYInt()-8,(int)(getHealth()/1000.0*getWidth()),5);
        g2.setColor(Color.black);
        g2.drawRect(getXInt(),getYInt()-8,(int)(getHealth()/1000.0*getWidth()),5);
    }

}