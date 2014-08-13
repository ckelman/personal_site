import java.util.*;

import java.applet.*;

import java.awt.*;

public class MysteryPlatform extends Platform
{
    private boolean canUse;
    private int useTimer;

    public MysteryPlatform(int x, int y, int width, int height)
    {

        super(x,y,width,height);

        canUse = true;
    }


    public boolean isbumped(MainCharacter subject)
    {
        int xLoc = getXInt();
        int yLoc = getYInt();
        int width = getWidth();
        int height = getHeight();
        int plaX = subject.getXInt();
        int plaY = subject.getYInt();
        int plaH = subject.getHeight();
        int plaW = subject.getWidth();

        if((xLoc+width >= plaX && xLoc <= plaX+plaW) && Math.abs(yLoc+height - plaY)<=5)
            return true;

        return false;

    }

    public void setCanUse(boolean b)
    {
        canUse = b;
    }

    public void setUseTimer(int i)
    {
        useTimer =i;
    }

    public int getUseTimer()
    {
        return useTimer;
    }

    public boolean getCanUse()
    {
        return canUse;
    }

    public void produceRandompowerup(MainCharacter m)
    {

        if(canUse)
        {
            int whatProduced = (int)(Math.random()*18);
            //1% sniper rifle gun
            //not coded yet but will work when coded
//             if (0<=whatProduced &&whatProduced<=2)
//             {
//                 if(m.getGun().getType()==1)
//                 m.getGun().setAmmo(m.getGun().getAmmo() + 100);
//                 else if(m.getGun().getType()==2)
//                 m.getGun().setAmmo(m.getGun().getAmmo() + 20);
//                 else if(m.getGun().getType()==3)
//                 m.getGun().setAmmo(m.getGun().getAmmo() + 20);
//                                 else if(m.getGun().getType()==4)
//                 m.getGun().setAmmo(m.getGun().getAmmo() + 200);
//                                                 else if(m.getGun().getType()==5)
//                 m.getGun().setAmmo(m.getGun().getAmmo() + 200);
//             }
           if(0<=whatProduced&&whatProduced<=2)
            {
                //MainKnight.changeGun(AK 47);
                Bullet b = new Bullet(m.getXInt(),m.getYInt(),10,10,15,100,5,false);
                Gun gun = new Gun(m.getXInt(),m.getYInt(),m.getHeight(),m.getWidth(),4,b,100,1);
                m.setGun(gun);

            } 
            else if(whatProduced>=3 && whatProduced<=5)
            {
                    if(m.getHealth()<200)
                    m.setHealth(m.getHealth()+50);
            }
           else if(6<=whatProduced&&whatProduced<=8)
            {
                ShotgunBullet b = new ShotgunBullet(m.getXInt(),m.getYInt());
                m.setGun(new Shotgun(m.getXInt(), m.getYInt(),m.getHeight(),m.getWidth(),b));
            }
            else if(9<=whatProduced&&whatProduced<=11)
            {
                SniperBullet b = new SniperBullet(m.getXInt(),m.getYInt());
                Sniper gun = new Sniper(m.getXInt(),m.getYInt(),m.getHeight(),m.getWidth(),b);
                m.setGun(gun);
            }
             else if(12<=whatProduced&&whatProduced<=14)
            {
                 FlameThrowerBullet b = new FlameThrowerBullet(m.getXInt(),m.getYInt());
                FlameThrower gun = new FlameThrower(m.getXInt(),m.getYInt(),m.getHeight(),m.getWidth(),b);
                m.setGun(gun);
                
            }
              else
            {
                 FreezeBullet b = new FreezeBullet(m.getXInt(),m.getYInt());
                FreezeRay gun = new FreezeRay(m.getXInt(),m.getYInt(),m.getHeight(),m.getWidth(),b);
                m.setGun(gun);
                
            }
            
            canUse = false;
            useTimer = 1000;
        }
    }

    public void draw(Graphics2D g2)
    {
        if (canUse)
            g2.setColor(Color.green);
        else
            g2.setColor(Color.black);
        g2.fillRect(getXInt(),getYInt(),getWidth(),getHeight());
        
        g2.setColor(Color.black);
        g2.drawRect(getXInt(),getYInt(),getWidth(),getHeight());
    }
    }
