import java.util.*;
import java.applet.*;
import java.awt.*;
public class MeeleeEnemy extends Person
{
    private boolean isright;
    private int state;
    public MeeleeEnemy(int x, int y)
    {

        super(x,y,30,42,200,null);
        int state = 0;
        boolean isright = true;
    }

    public void attack(MainCharacter main, ArrayList<Platform> g )
    {
//         Platform horizfield = new Platform((int)(getX()-70),(int)(getY()+50),140+getWidth(),100);
//     //    Platform vertifield = new Platform((int)(getX()-10),(int)(getY()+100),50,300);
//         if(main.intersects(horizfield))
//         {
    if(!getIsFrozen())
    {
            if(!isright)
            {
                Platform lefthit = new Platform((int)(getX()-30),(int)(getY()),30+getWidth(),getHeight());
                if(lefthit.intersects(main))
                {
                    main.setHealth(main.getHealth()-15);
                    if(!main.isPlatformLeft(g))
                        main.setX(main.getX()-2);
                    if(!main.isPlatformLeft(g))
                        main.setX(main.getX()-2);
                    if(!main.isPlatformLeft(g))
                        main.setX(main.getX()-2);
                    if(!main.isPlatformLeft(g))
                        main.setX(main.getX()-2);
                    if(!main.isPlatformLeft(g))
                        main.setX(main.getX()-2);

                    main.setY(main.getY()-10);
                }
            }
           else
            {
                Platform righthit = new Platform((int)(getX()),(int)(getY()),30+getWidth(),getHeight());
                if(righthit.intersects(main))
                {
                    main.setHealth(main.getHealth()-15);
                    if(!main.isPlatformRight(g))
                        main.setX(main.getX()+2);
                    if(!main.isPlatformRight(g))
                        main.setX(main.getX()+2);
                    if(!main.isPlatformRight(g))
                        main.setX(main.getX()+2);
                    if(!main.isPlatformRight(g))
                        main.setX(main.getX()+2);
                    if(!main.isPlatformRight(g))
                        main.setX(main.getX()+2);

                    main.setY(main.getY()-10);
                }
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
                Person testwalker = new Person((int)(getX())+2,(int)(getY()),getWidth(),getHeight(),1,null);
                if(testwalker.isPlatformBelow(ground)&&!isPlatformRight(ground))
                {
                    setX(getX()+2);
                }
                else
                {
                    isright = false;
                    state = 1;

                }
            }
            if(!isright)
            {
                Person testwalker = new Person((int)(getX())-2,(int)(getY()),getWidth(),getHeight(),1,null);
                if(testwalker.isPlatformBelow(ground)&&!isPlatformLeft(ground))
                {
                    setX(getX()-2);
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

        //State 0 StandRight, 1 StandLeft, 2 SwingRight, 3SwingLeft

        int x = getXInt();
        int y = getYInt();

        g2.setColor(Color.red);   
        g2.fillRect(getXInt(),getYInt()-8,(int)(getHealth()/200.0*getWidth()),5);
        g2.setColor(Color.black);
        g2.drawRect(getXInt(),getYInt()-8,(int)(getHealth()/200.0*getWidth()),5);

        //State 0 StandRight, 1 StandLeft, 2 SwingRight, 3SwingLeft

        //Size multiplier
        int s = 3;

        //Color of mustache
        Color c = new Color(141, 76, 6);

        if(state == 0)
        {
            //Body
            g2.setColor(Color.GREEN);
            g2.fillRect(x+0*s, y+4*s, 7*s, 4*s);
            g2.fillRect(x+0*s, y+8*s, 7*s, 3*s);
            g2.fillRect(x+1*s, y+11*s, 5*s, s);

            //Eyes
            g2.setColor(Color.WHITE);
            g2.fillRect(x+3*s, y+6*s, s, 2*s);
            g2.fillRect(x+5*s, y+6*s, s, 2*s);
            g2.setColor(Color.BLACK);
            g2.drawRect(x+3*s, y+6*s, s, 2*s);
            g2.drawRect(x+5*s, y+6*s, s, 2*s);

            //Mustache
            g2.setColor(c);
            g2.fillRect(x+3*s, y+9*s, 3*s, s);
            g2.fillRect(x+3*s, y+10*s, s, s);
            g2.fillRect(x+5*s, y+10*s, s, s);

            //Horns
            g2.setColor(Color.WHITE);
            g2.fillRect(x+2*s, y, s, 4*s);
            g2.fillRect(x+3*s, y+3*s, s, s);
            g2.fillRect(x+5*s, y+3*s, s, s);
            g2.fillRect(x+6*s, y, s, 4*s);

            //Legs
            g2.setColor(Color.BLACK);
            g2.fillRect(x+1*s, y+13*s, 2*s, s);
            g2.fillRect(x+4*s, y+13*s, 2*s, s);

            //Arm and Sword
            g2.setColor(Color.WHITE);
            g2.fillRect(x+8*s, y+6*s, s, 3*s);
            g2.fillRect(x+7*s, y+8*s, 3*s, s);
            g2.setColor(Color.BLACK);
            g2.fillRect(x+8*s, y+9*s, s, s);
            g2.drawRect(x+8*s, y+9*s, s, s);
            g2.drawLine(x+8*s, y+9*s, x+7*s, y+9*s);
            g2.drawLine(x+7*s, y+9*s, x+7*s, y+8*s);
            g2.drawLine(x+7*s, y+8*s, x+8*s, y+8*s);
            g2.drawLine(x+8*s, y+8*s, x+8*s, y+6*s);
            g2.drawLine(x+8*s, y+6*s, x+9*s, y+6*s);
            g2.drawLine(x+9*s, y+6*s, x+9*s, y+8*s);
            g2.drawLine(x+9*s, y+8*s, x+10*s, y+8*s);
            g2.drawLine(x+10*s, y+8*s, x+10*s, y+9*s); 
            g2.drawLine(x+10*s, y+9*s, x+9*s, y+9*s);

            //Outline of Body
            g2.drawLine(x+0*s, y+4*s, x+7*s, y+4*s);
            g2.drawLine(x+7*s, y+4*s, x+7*s, y+11*s);
            g2.drawLine(x+7*s, y+11*s, x+6*s, y+11*s);
            g2.drawLine(x+6*s, y+11*s, x+6*s, y+12*s);
            g2.drawLine(x+6*s, y+12*s, x+1*s, y+12*s);
            g2.drawLine(x+1*s, y+12*s, x+1*s, y+11*s);
            g2.drawLine(x+1*s, y+11*s, x+0*s, y+11*s);
            g2.drawLine(x+0*s, y+11*s, x+0*s, y+4*s);

            //Outline of Horn
            g2.drawLine(x+2*s, y+4*s, x+2*s, y);
            g2.drawLine(x+2*s, y, x+3*s, y);
            g2.drawLine(x+3*s, y, x+3*s, y+3*s);
            g2.drawLine(x+3*s, y+3*s, x+4*s, y+3*s);
            g2.drawLine(x+4*s, y+3*s, x+4*s, y+4*s);
            g2.drawLine(x+5*s, y+4*s, x+5*s, y+3*s);
            g2.drawLine(x+5*s, y+3*s, x+6*s, y+3*s);
            g2.drawLine(x+6*s, y+3*s, x+6*s, y);
            g2.drawLine(x+6*s, y, x+7*s, y);
            g2.drawLine(x+7*s, y, x+7*s, y+4*s);
        }

        if(state == 1)
        {
            //Body
            g2.setColor(Color.GREEN);
            g2.fillRect(x+3*s, y+4*s, 7*s, 4*s);
            g2.fillRect(x+3*s, y+8*s, 7*s, 3*s);
            g2.fillRect(x+4*s, y+11*s, 5*s, s);

            //Eyes
            g2.setColor(Color.WHITE);
            g2.fillRect(x+6*s, y+6*s, s, 2*s);
            g2.fillRect(x+4*s, y+6*s, s, 2*s);
            g2.setColor(Color.BLACK);
            g2.drawRect(x+6*s, y+6*s, s, 2*s);
            g2.drawRect(x+4*s, y+6*s, s, 2*s);

            //Mustache
            g2.setColor(c);
            g2.fillRect(x+4*s, y+9*s, 3*s, s);
            g2.fillRect(x+6*s, y+10*s, s, s);
            g2.fillRect(x+4*s, y+10*s, s, s);

            //Horns
            g2.setColor(Color.WHITE);
            g2.fillRect(x+7*s, y, s, 4*s);
            g2.fillRect(x+6*s, y+3*s, s, s);
            g2.fillRect(x+4*s, y+3*s, s, s);
            g2.fillRect(x+3*s, y, s, 4*s);

            //Legs
            g2.setColor(Color.BLACK);
            g2.fillRect(x+7*s, y+13*s, 2*s, s);
            g2.fillRect(x+4*s, y+13*s, 2*s, s);

            //Arm and Sword
            g2.setColor(Color.WHITE);
            g2.fillRect(x+1*s, y+6*s, s, 3*s);
            g2.fillRect(x+0*s, y+8*s, 3*s, s);
            g2.setColor(Color.BLACK);
            g2.fillRect(x+1*s, y+9*s, s, s);
            g2.drawRect(x+1*s, y+9*s, s, s);
            g2.drawLine(x+2*s, y+9*s, x+3*s, y+9*s);
            g2.drawLine(x+3*s, y+9*s, x+3*s, y+8*s);
            g2.drawLine(x+3*s, y+8*s, x+2*s, y+8*s);
            g2.drawLine(x+2*s, y+8*s, x+2*s, y+6*s);
            g2.drawLine(x+2*s, y+6*s, x+1*s, y+6*s);
            g2.drawLine(x+1*s, y+6*s, x+1*s, y+8*s);
            g2.drawLine(x+1*s, y+8*s, x+0*s, y+8*s);
            g2.drawLine(x+0*s, y+8*s, x+0*s, y+9*s); 
            g2.drawLine(x+0*s, y+9*s, x+1*s, y+9*s);

            //Outline of Body
            g2.drawLine(x+10*s, y+4*s, x+3*s, y+4*s);
            g2.drawLine(x+3*s, y+4*s, x+3*s, y+11*s);
            g2.drawLine(x+3*s, y+11*s, x+4*s, y+11*s);
            g2.drawLine(x+4*s, y+11*s, x+4*s, y+12*s);
            g2.drawLine(x+4*s, y+12*s, x+9*s, y+12*s);
            g2.drawLine(x+9*s, y+12*s, x+9*s, y+11*s);
            g2.drawLine(x+9*s, y+11*s, x+10*s, y+11*s);
            g2.drawLine(x+10*s, y+11*s, x+10*s, y+4*s);

            //Outline of Horn
            g2.drawLine(x+8*s, y+4*s, x+8*s, y);
            g2.drawLine(x+8*s, y, x+7*s, y);
            g2.drawLine(x+7*s, y, x+7*s, y+3*s);
            g2.drawLine(x+7*s, y+3*s, x+6*s, y+3*s);
            g2.drawLine(x+6*s, y+3*s, x+6*s, y+4*s);
            g2.drawLine(x+5*s, y+4*s, x+5*s, y+3*s);
            g2.drawLine(x+5*s, y+3*s, x+4*s, y+3*s);
            g2.drawLine(x+4*s, y+3*s, x+4*s, y);
            g2.drawLine(x+4*s, y, x+3*s, y);
            g2.drawLine(x+3*s, y, x+3*s, y+4*s);
        }
    }
}

