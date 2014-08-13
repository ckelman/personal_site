import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.*;

public class Game extends Applet implements ActionListener, KeyListener, Runnable
{
    private ArrayList<Platform> platforms;
    private ArrayList<Platform> platforms1;
    private ArrayList<Platform> platforms2;
    private ArrayList<Platform> platforms3;
    private ArrayList<Platform> platforms7;
    private ArrayList<Platform> platforms5;
    private ArrayList<Platform> platforms6;
    private ArrayList<Platform>[] levels;
    private MainCharacter hero;
    private int currentLevel;
    private Gun gun;
    private Bullet bullet;
    private ArrayList<Bullet> myBullets;
    private int timeCount;
    private ArrayList<Bullet> enemyBullets;
    private ArrayList<Person> enemies;
    private ArrayList<Person> enemies1;
    private ArrayList<Person> enemies2;
    private ArrayList<Person> enemies3;
    private ArrayList<Person> enemies7;
    private ArrayList<Person> enemies5;
    private ArrayList<Person> enemies6;
 
    private int lives;
    private int score;
    private String gunString;

    private ArrayList<Person>[] enemyLevel;

    public void init()
    {
        score = 10000;
        enemyBullets = new ArrayList<Bullet>();
        timeCount = 0;
        myBullets = new ArrayList<Bullet>();
        enemies = new ArrayList<Person>();
        enemies1 = new ArrayList<Person>();
        enemies2 = new ArrayList<Person>();
        enemies3 = new ArrayList<Person>();
        enemies7 = new ArrayList<Person>();
        enemies5 = new ArrayList<Person>();
        enemies6 = new ArrayList<Person>();

        enemyLevel = new ArrayList[7];

        lives = 3;

        hero = new MainCharacter(0,400,30,50,100,gun);

        bullet = new Bullet(hero.getXInt(),hero.getYInt(),10,10,15,100,3,true);
        gun = new Gun(hero.getXInt(),hero.getYInt(),hero.getHeight(),hero.getWidth(),4,bullet,100,1);
        hero.setGun(gun);

        levels = new ArrayList[7];

        //first Level
        platforms = new ArrayList<Platform>();
        platforms.add(new Platform(0,450,154,200));
        platforms.add(new Platform(154,420,88,500));
        //mystery platform
        platforms.add(new MysteryPlatform(50,300,40,40));
        platforms.add(new Platform(242,390,88,500));
        platforms.add(new Platform(330,350,22,500));
        platforms.add(new Platform(352,320,88,500));
        platforms.add(new Platform(440,360,44,500));
        platforms.add(new Platform(484,410,22,500));
        platforms.add(new Platform(506,430,22,500));
        platforms.add(new Platform(528,450,44,500));
        platforms.add(new Platform(568,470,110,500));
        platforms.add(new Platform(726,470,8,500));
        platforms.add(new Platform(770,470,8,500));
        platforms.add(new Platform(814,470,8,500));
        platforms.add(new Platform(860,470,200,500));
        platforms.add(new Platform(-20,0,20,700));
        platforms.add(new Platform(1000,0,20,700));

        //Second level
        platforms1 = new ArrayList<Platform>();

        platforms1.add(new Platform(0, 450, 154, 200));
        platforms1.add(new MysteryPlatform(80,280,40,40));
        platforms1.add(new Platform(180, 380, 10, 13));
        platforms1.add(new Platform(220, 310, 10, 13));
        platforms1.add(new Platform(280, 260, 120, 400));
        platforms1.add(new Platform(440, 310, 10, 13));
        platforms1.add(new Platform(480, 380, 10, 13));
        platforms1.add(new Platform(520, 450, 154, 200));
        platforms1.add(new Platform(710, 380, 10, 13));
        platforms1.add(new Platform(770, 470, 300, 200));
        platforms1.add(new Platform(-20,0,10,700));
        platforms1.add(new Platform(1000,0,10,700));

        enemies1.add(new MeeleeEnemy(185,300,30,42,200));
        enemies1.add(new SuicideEnemy(300,200,36,48,100));
        enemies1.add(new SniperEnemy(600,300,36,45,150));

        //3rd level

        platforms2 = new ArrayList<Platform>();

        platforms2 = new ArrayList<Platform>();
        platforms2.add(new MysteryPlatform(155,350,40,40));
        platforms2.add(new Platform(0,470,230,1000));
        platforms2.add(new Platform(200, 100, 30, 400));    
        platforms2.add(new Platform(200,100, 160, 30));
        platforms2.add(new Platform(50, 420, 13, 10));
        platforms2.add(new Platform(130, 360, 13, 10));
        platforms2.add(new Platform(50, 300, 13, 10));
        platforms2.add(new Platform(130, 240, 13, 10));
        platforms2.add(new Platform(50, 180, 13, 10));
        platforms2.add(new Platform(130, 120, 13, 10));
        platforms2.add(new Platform(270, 250, 140, 30));
        platforms2.add(new Platform(200, 400, 90, 30));
        platforms2.add(new Platform(275, 500, 13, 10));
        platforms2.add(new Platform(360, 470,100,1000));
        platforms2.add(new Platform(400, 00, 30, 360));
        platforms2.add(new Platform(700, 470,400,1000));
        platforms2.add(new Platform(700, 100, 30, 400));
        platforms2.add(new Platform(520, 420, 18, 10));
        platforms2.add(new Platform(600, 360, 18, 10));
        platforms2.add(new Platform(520, 300, 18, 10));
        platforms2.add(new Platform(400, 250, 58, 10));
        platforms2.add(new Platform(520, 190, 18, 10));
        platforms2.add(new Platform(600, 130, 18, 10));
        platforms2.add(new Platform(700, 100, 230, 30));
        platforms2.add(new Platform(800, 300, 260, 30));
        platforms2.add(new Platform(1000,0,20,700));
        platforms2.add(new Platform(-20,-100,20,800));

        enemies2.add(new MeeleeEnemy(400,400,30,42,200));
        enemies2.add(new SniperEnemy(300,150,36,45,150));
        enemies2.add(new SniperEnemy(300,10,36,45,150));
        enemies2.add(new SuicideEnemy(450,150,36,48,100));
        enemies2.add(new SniperEnemy(700,10,36,45,150));
        enemies2.add(new SniperEnemy(800,150,36,45,150));

        //4th level

        platforms3 = new ArrayList<Platform>();
        //steps/top platform
        platforms3.add(new Platform(0,450,200,500));
        platforms3.add(new Platform(150,390,30,10));
        platforms3.add(new Platform(75,330,30,10));
        platforms3.add(new Platform(0,270,30,10));
        platforms3.add(new Platform(75,210,30,10));
        platforms3.add(new Platform(150,150,30,10));
        platforms3.add(new Platform(180,90,30,500));
        //first fall
        platforms3.add(new Platform(180,90,250,25));
        platforms3.add(new Platform(470,0,25,420));
        platforms3.add(new Platform(250,240,230,15));
        platforms3.add(new Platform(200,480,900,500));
        platforms3.add(new Platform(200,370,230,15));
        platforms3.add(new Platform(750,-100,20,520));
        platforms3.add(new Platform(600,90,20,420));
        //ladder
        platforms3.add(new Platform(580,420,20,10));
        platforms3.add(new Platform(495,360,20,10));
        platforms3.add(new Platform(580,300,20,10));
        platforms3.add(new Platform(495,240,20,10));
        platforms3.add(new Platform(580,180,20,10));
        platforms3.add(new Platform(495,120,20,10));
        //final fall
        platforms3.add(new Platform(660,380,90,10));
        platforms3.add(new Platform(620,300,90,10));
        platforms3.add(new Platform(660,220,90,10));
        platforms3.add(new Platform(620,130,90,10));

        platforms3.add(new Platform(-20,-100,20,800));
        platforms3.add(new Platform(1000,0,20,700));
        platforms3.add(new MysteryPlatform(0,150,30,30));
        platforms3.add(new MysteryPlatform(210,0,30,30));
        platforms3.add(new MysteryPlatform(220,390,30,30));

        enemies3.add(new MeeleeEnemy(250,140,30,42,200));
        enemies3.add(new MeeleeEnemy(320,140,30,42,200));
        enemies3.add(new SuicideEnemy(200,40,36,48,100));
        enemies3.add(new SniperEnemy(450,420,36,45,150));
        enemies3.add(new SniperEnemy(250,400,36,45,150));
        enemies3.add(new MeeleeEnemy(700,100,30,42,200));
        enemies3.add(new SniperEnemy(700,400,36,45,150));

//         platforms4 = new ArrayList<Platform>();
// 
//         platforms4.add(new Platform(0,470,1000,1000));
//         platforms4.add(new Platform(10,400,60,5));
//         platforms4.add(new Platform(120,400,60,5));
//         platforms4.add(new Platform(70,330,50,5));
//         platforms4.add(new Platform(10,270,60,5));
//         platforms4.add(new Platform(120,270,60,5));
//         platforms4.add(new Platform(70,200,50,5));
//         platforms4.add(new Platform(10,130,60,5));
//         platforms4.add(new Platform(120,130,60,5));
//         platforms4.add(new MysteryPlatform(200,375,30,30));
//         platforms4.add(new Platform(230,100,20,325));
// 
//         platforms4.add(new Platform(250,300,200,25));
//         platforms4.add(new Platform(485,300,215,25));
//         platforms4.add(new Platform(850,470,100,10));
//         platforms4.add(new Platform(575,300,20,1000));
// 
//         enemies4.add(new MeeleeEnemy(400,200,33,55,200));
//         enemies4.add(new SuicideEnemy(350,200,36,48,100));
//         enemies4.add(new SniperEnemy(300,200,20,50,100));
//         enemies4.add(new MeeleeEnemy(500,200,33,55,200));
//         enemies4.add(new SuicideEnemy(450,200,36,48,100));
//         enemies4.add(new SniperEnemy(550,200,20,50,100));

        platforms5 = new ArrayList<Platform>();
        //ground
        platforms5.add(new Platform(0, 470, 75, 20));
        platforms5.add(new Platform(280, 470, 75, 20));
        platforms5.add(new Platform(440, 470, 75, 20));
        platforms5.add(new Platform(580, 470, 75, 20));
        platforms5.add(new Platform(720, 470, 75, 20));
        platforms5.add(new Platform(860, 470, 200, 200));
        //
        platforms5.add(new Platform(140, 415, 75, 20));
        platforms5.add(new Platform(0, 370, 75, 20));
        platforms5.add(new Platform(140, 320, 75, 20));
        platforms5.add(new Platform(420, 360, 75, 20));
        platforms5.add(new Platform(420, 200, 10, 10));
        platforms5.add(new Platform(495, 125, 10, 10));
        platforms5.add(new Platform(615, 125, 10, 10));
        platforms5.add(new Platform(735, 125, 10, 10));
        platforms5.add(new Platform(280, 275, 75, 20));
        platforms5.add(new Platform(560, 300, 75, 20));
        platforms5.add(new Platform(700, 360, 165, 20));
        platforms5.add(new Platform(775, 100, 150, 10));
        platforms5.add(new Platform(775, 100, 10, 180));
        platforms5.add(new Platform(860, 170, 10, 400));
        platforms5.add(new Platform(850, 340, 10, 10));
        platforms5.add(new Platform(785, 270, 10, 10));
        platforms5.add(new Platform(850, 195, 10, 10));
        platforms5.add(new Platform(-20,-100,20,800));
        platforms5.add(new Platform(1000,0,20,700));

        platforms5.add(new MysteryPlatform(0,250,30,30));

        enemies5.add(new SuicideEnemy(420,60,36,48,100)); 
        enemies5.add(new SuicideEnemy(495,60,36,48,100));
        enemies5.add(new SuicideEnemy(615,60,36,48,100));
        enemies5.add(new SuicideEnemy(735,60,36,48,100));
        enemies5.add(new MeeleeEnemy(420,300,30,42,200));
        enemies5.add(new MeeleeEnemy(560,400,30,42,200));
        enemies5.add(new SniperEnemy(560,240,36,45,150));
        enemies5.add(new MeeleeEnemy(420,400,30,42,200));
        enemies5.add(new MeeleeEnemy(300,400,30,42,200));
        
           platforms6 = new ArrayList<Platform>();
        platforms6.add(new MysteryPlatform(0,350,20,20));
        platforms6.add(new Platform(0, 480, 1000, 20));
        platforms6.add(new Platform(0,470, 30,100));
        platforms6.add(new Platform(150, 410, 15, 10)); 
        platforms6.add(new Platform(300, 410, 15, 10));
        platforms6.add(new Platform(450, 410, 15, 10));
        platforms6.add(new Platform(600, 425, 15, 10));
        platforms6.add(new Platform(750, 410, 15, 10));
        platforms6.add(new Platform(900, 425, 15, 10));
                platforms6.add(new Platform(-20,-100,20,800));
        platforms6.add(new Platform(1000,0,20,700));
        
        enemies6.add(new MeeleeEnemy(75,400,30,42,200));
        enemies6.add(new MeeleeEnemy(325,400,30,42,200));
        enemies6.add(new MeeleeEnemy(845,400,30,42,200));
//         enemies6.add(new MeeleeEnemy(525,400,30,42,200));
//         enemies6.add(new MeeleeEnemy(325,400,30,42,200));
       enemies6.add(new MeeleeEnemy(555,400,30,42,200));
//         enemies6.add(new MeeleeEnemy(725,400,
        enemies6.add(new MeeleeEnemy(875,400,30,42,200));
        enemies6.add(new MeeleeEnemy(975,430,30,42,200)); 
        enemies6.add(new MeeleeEnemy(625,430,30,42,200));
        enemies6.add(new SniperEnemy(675,430,36,45,150)); 
        enemies6.add(new SniperEnemy(875,430,36,45,150));    
        
        platforms7 = new ArrayList<Platform>();
        platforms7.add(new Platform(0,470,230,1000));
        platforms7.add(new Platform(10,400,60,5));
        platforms7.add(new Platform(120,400,60,5));
        platforms7.add(new Platform(75,330,50,5));
        platforms7.add(new Platform(10,270,60,5));
        platforms7.add(new Platform(125,270,60,5));
        platforms7.add(new Platform(75,200,50,5));
        platforms7.add(new Platform(10,130,60,5));
        platforms7.add(new Platform(125,130,60,5));
        platforms7.add(new MysteryPlatform(200,10,30,30));
        platforms7.add(new Platform(850,470,100,10));
        platforms7.add(new Platform(325,330,20,10));
        platforms7.add(new Platform(330,200,50,5));
        platforms7.add(new Platform(260,130,60,5));
        platforms7.add(new Platform(380,130,60,5));
        platforms7.add(new Platform(510,400,60,5));
        platforms7.add(new Platform(660,420,60,5));
        platforms7.add(new Platform(585,330,50,5));
        platforms7.add(new Platform(510,270,60,5));
        platforms7.add(new Platform(620,270,60,5));
        platforms7.add(new Platform(585,200,50,5));
        platforms7.add(new Platform(510,130,60,5));
        platforms7.add(new Platform(635,130,60,5));
        platforms7.add(new Platform(740,0,12,300));
        
        enemies7.add(new MeeleeEnemy(600,200,30,42,200));
        enemies7.add(new SuicideEnemy(350,100,36,48,100));
        enemies7.add(new SniperEnemy(325,200,36,45,150)); 
        enemies7.add(new MeeleeEnemy(500,200,30,42,200));
        enemies7.add(new SuicideEnemy(500,50,36,48,100));
        enemies7.add(new SniperEnemy(50,100,36,45,150)); 



        enemyLevel[0] = enemies;
        enemyLevel[1] = enemies1;
        enemyLevel[2] = enemies2;
        enemyLevel[5] = enemies3;
        enemyLevel[4] = enemies5;
        enemyLevel[6] = enemies7;
        enemyLevel[3] = enemies6;

        gunString = "Machine Gun";

        Timer t = new Timer (13,this);
        t.start();

        addKeyListener(this);

        levels[0] = platforms;
        levels[1] = platforms1;
        levels[2] = platforms2;
        levels[5] = platforms3;
        levels[4] = platforms5;
        levels[6] = platforms7;
        levels[3] = platforms6;

        resize(1000,500);
    }

    public void paint (Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        //background
        g2.setColor(new Color(166,230,229));
        g2.fillRect(0,0,1000,500);

        g2.setColor(Color.white);
        g2.fillRect(100,150,200,100);
        g2.fillRect(150,120,75,30);
        g2.fillRect(175,250,75,30);

        g2.fillRect(600,100,200,100);
        g2.fillRect(650,70,75,30);
        g2.fillRect(675,200,75,30);

        g2.setColor(Color.yellow);
        //         g2.fillRect(900,-100,200,200);
        g2.fillRect(840,30,100,100);

        g2.setColor(Color.black);
        g2.drawString("Score: "+score,920,20);

        if(lives>0&&currentLevel<levels.length)
        {
            for(Person e:enemyLevel[currentLevel])
                e.draw(g2);
            //DISPLAYS YOUR INFO

            g2.setColor(Color.black);
            g2.drawString("Lives:  "+lives,0,50);
            g2.drawString("Health:  ",0,30);
            g2.setColor(Color.red);
            g2.fillRect(40,20,hero.getHealth(),10);
            g2.setColor(Color.black);
            g2.drawRect(40,20,hero.getHealth(),10);
            g2.drawString("Ammo:  "+hero.getGun().getAmmo(),0,90);
            g2.drawString("Gun:  "+gunString,0,70);

            if(currentLevel==0)
            {
                g2.drawString("WELCOME TO THE MOST MAGICAL ADVENTURE EVER!",370,80);
                g2.drawString("PRESS A OR LEFT TOMOVE LEFT, AND D OR RIGHT TO MOVE RIGHT!",300,120);
                g2.drawString("PRESS W OR UP TO FLY!!!!*",300,140);
                g2.drawString("PRESS O OR SPACE TO CREATE MAGICAL SPEEDING METAL PROJECTILES!",300,160);
                g2.drawString("GET TO THE FLAG TO WIN AN AMAZING PRIZE!!!",300,180);
                g2.drawString("MIGHTY WARRIOR NOW GO BE THE WINNING!!!!",370,220);
                g2.drawString("*limit of 75 pixels per flight",700,400);
                g2.drawString("JUMP INTO THE BOX TO BECOME EVEN MORE MIGHTY!!",0,275);
            }

            if(currentLevel==1)
            {
                g2.drawString("EVIL GREEN MINION WILL PUNCH THE MIGHTY HERO!",50,250);
                g2.drawString("EVIL PINK MINION WILL EXPLODE IF YOU GET TOO CLOSE!",300,150);
                g2.drawString("EVIL BLACK KNIGHT CAN SHOOT YOU!",500,350);
            }

            //draws flag at target location 

            g2.setColor(new Color(96,70,17));

            g2.fillRect(900,400,20,80);

            g2.setColor(new Color(192,9,9));
            g2.fillRect(880,400,40,25);

            hero.draw(g2);

            for (Platform p: levels[currentLevel])
            {

                p.draw(g2);
            }

            for (Bullet b: enemyBullets)
            {
                b.draw(g2);
            }

            for(Bullet b: myBullets)
            {

                b.draw(g2);
            }
        }

        else if(lives <= 0)
        {
            g2.setColor(Color.black);
            g2.drawString("YOU LOSE",450,250);

        }
        else if(currentLevel>=levels.length)
        {
            g2.drawString("CONGRATUMALATIONS!!!!!!!!!!!!!",325,120);
            g2.drawString("YOU DID IT! YOU ARE THE MIGHTIEST MIGHTY WARRIOR TO EVER BE CALLED MIGHTY!!!!!!!!!!!!!",250,150);
            g2.drawString("YOU HAVE WON A NICE PAT ON THE BACK!!!!!!!!!!!!",275,180);
            g2.drawString("TREASURE THIS FOREVER!!!!!!!!!!!!",325,200);
            g2.drawString("FINAL SCORE:  "+score,325,240);
        }

        //         g2.drawLine(0,50,50,50);
        //         g2.drawLine(50,0,50,50);
        // g2.drawString(10,10,"Ammo:");
        //g2.drawString(25,25
    }

    public void actionPerformed (ActionEvent e)
    {
        if(lives>0&&currentLevel<levels.length)
        {
            if(hero.getGun().getType()==1)
            {
                gunString = "Machine Gun";
            }

            if(hero.getGun().getType()==2)
            {
                gunString = "Shotgun";
            }

            if(hero.getGun().getType()==3)
            {
                gunString = "Sniper";
            }

            if(timeCount%5==0 && lives>0)
            {
                score--;
            }

            if(hero.getGun().getShootTimer()>0)
                hero.getGun().setShootTimer(hero.getGun().getShootTimer()-1);

            for (int i = 0; i<enemyBullets.size();i++)
            {
                Bullet b = enemyBullets.get(i);
                if (b.intersects(hero))
                {
                    hero.setHealth(hero.getHealth()-b.getDamage());
                    enemyBullets.remove(i);
                    i--;
                }
            }

            for(Platform p:levels[currentLevel])
            {
                if (p instanceof MysteryPlatform)
                {
                    if(p.isbumped(hero))
                        p.produceRandompowerup(hero);

                    if(p.getUseTimer()>0)
                        p.setUseTimer(p.getUseTimer()-1);

                    if(p.getUseTimer()==0)
                        p.setCanUse(true);
                }
            }

            //checks if bullets hit enemy then proceeds accordingly
            for(int i = 0; i<enemyLevel[currentLevel].size();i++)
            {
                Person p = enemyLevel[currentLevel].get(i);
                for(int j =0;j<myBullets.size();j++)
                {
                    Bullet bul = myBullets.get(j);
                    if(p.intersects(bul))
                    {
                        p.setHealth(p.getHealth()-bul.getDamage());
                        myBullets.remove(j);
                        j--;
                    }
                }
            }
            //sets the character's state
            if(hero.getIsFacingRight())
            {
                hero.setState(0);

                if (hero.getIsJumping())
                    hero.setState(2);
            }

            if (!hero.getIsFacingRight())
            {
                hero.setState(1);

                if(hero.getIsJumping())
                    hero.setState(3);
            }
            //kills you if you fall
            if(hero.getY()>=550 || hero.getHealth()<=0)
            {
                lives--;
                hero.setX(0);
                hero.setY(400);

                if (hero.getGun().getType()==1)
                    hero.getGun().setAmmo(100);

                if (hero.getGun().getType()==2)
                    hero.getGun().setAmmo(20);

                if (hero.getGun().getType()==3)
                    hero.getGun().setAmmo(20);

                hero.setHealth(100);
                score-=1000;
            }

            //kills enemies if their health is 0
            for(int i = 0;i<enemyLevel[currentLevel].size();i++)
            {
                Person p = enemyLevel[currentLevel].get(i);
                if (p.getHealth()<=0)
                {
                    enemyLevel[currentLevel].remove(i);
                    score+=500;
                }
            }
            //removes bullets if they have  gone too far
            for(int i = 0; i<myBullets.size(); i++)
            {
                Bullet b = myBullets.get(i);
                if(b.getDistanceCount()>=b.getDistance())
                {
                    myBullets.remove(i);
                }
            }

            for(int i = 0; i<enemyBullets.size(); i++)
            {
                Bullet b = enemyBullets.get(i);
                if(b.getDistanceCount()>=b.getDistance())
                {
                    enemyBullets.remove(i);
                }
            }

            //removes bullets if they hit a platform;
            for(Platform p : levels[currentLevel])
            {
                for(int i = 0; i<myBullets.size(); i++)
                {
                    Bullet b = myBullets.get(i);

                    if(b.intersects(p))
                    {
                        myBullets.remove(i);
                        i--;
                    }
                }
            }
            for(Platform p : levels[currentLevel])
            {
                for(int i = 0; i<enemyBullets.size(); i++)
                {
                    Bullet b = enemyBullets.get(i);

                    if(b.intersects(p))
                    {
                        enemyBullets.remove(i);
                        i--;
                    }
                }
            }
            //shoots a bullet
            if(hero.getGun().getIsShooting()&& hero.getGun().getAmmo()>0 && hero.getGun().getShootTimer()==0)
            {
                Bullet bull = hero.getGun().shoot();
                bull.setIsFacingRight(hero.getIsFacingRight());
                bull.setX(hero.getX()+24);
                bull.setY(hero.getY()+20);
                if(bull != null)
                    myBullets.add(bull);

                if(hero.getGun().getType()==2)
                {
                    Bullet b2 = 
                        new Bullet(bull.getXInt(),bull.getYInt()+5,bull.getHeight(),bull.getWidth(),bull.getDamage(),bull.getDistance(),bull.getSpeed(),true);
                    b2.setIsFacingRight(hero.getIsFacingRight());
                    Bullet b3 = 
                        new Bullet(bull.getXInt(),bull.getYInt()+10,bull.getHeight(),bull.getWidth(),bull.getDamage(),bull.getDistance(),bull.getSpeed(),true);
                    b3.setIsFacingRight(hero.getIsFacingRight());
                    Bullet b4 = 
                        new Bullet(bull.getXInt(),bull.getYInt()-5,bull.getHeight(),bull.getWidth(),bull.getDamage(),bull.getDistance(),bull.getSpeed(),true);
                    b4.setIsFacingRight(hero.getIsFacingRight());
                    Bullet b5 = 
                        new Bullet(bull.getXInt(),bull.getYInt()-10,bull.getHeight(),bull.getWidth(),bull.getDamage(),bull.getDistance(),bull.getSpeed(),true);
                    b5.setIsFacingRight(hero.getIsFacingRight());
                    myBullets.add(b2);
                    myBullets.add(b3);
                    myBullets.add(b4);
                    myBullets.add(b5);
                }

                hero.getGun().setShootTimer(hero.getGun().getRateOfFire());

            }
            //stops you if a platform is above you
            if(hero.isPlatformAbove(levels[currentLevel]))
                hero.setIsJumping(false);
            //resets jump
            if (hero.isPlatformBelow(levels[currentLevel])&&!hero.getIsJumping())
                hero.setCount(0);
            //enemy actions
            for(Person p: enemyLevel[currentLevel])
            {
                if(!p.isPlatformBelow(levels[currentLevel]))
                    p.fall();

                p.pace(levels[currentLevel]);

                if(p instanceof MeeleeEnemy && timeCount%20==0)
                    p.attack(hero,levels[currentLevel]);

                else if(p instanceof SuicideEnemy)
                    p.attack(hero,levels[currentLevel]);

                else if(p instanceof SniperEnemy)
                {
                    p.attack(hero,levels[currentLevel]);
                    if(p.getGun().getIsShooting() && timeCount%p.getGun().getRateOfFire()==0)
                    {
                        Bullet bull = p.getGun().shoot();
                        bull.setIsFacingRight(p.getIsFacingRight());
                        enemyBullets.add(bull);
                    }
                }
            }

            //falling
            if(!hero.isPlatformBelow(levels[currentLevel])&&!hero.getIsJumping())
            {
                hero.fall();
            }
            //jump
            if (hero.getIsJumping())
            {
                hero.jump();

            }
            //moves right
            if(hero.getIsMovingRight()&&!hero.isPlatformRight(levels[currentLevel]))
                hero.setX(hero.getX()+2);
            //move left
            if(hero.getIsMovingLeft()&&!hero.isPlatformLeft(levels[currentLevel]))
                hero.setX(hero.getX()-2);

            //changes level  
            if((hero.getX()>870 && hero.getX()<1000) && hero.getY()+hero.getHeight()>=460 &&  hero.getY()+hero.getHeight()<=550)
            {  currentLevel++;
                hero.setX(10);
                hero.setY(400);
                score+=1000;

            }

            //moves the bullets
            for (Bullet b : myBullets)

                b.move();

            for (Bullet b : enemyBullets)

                b.move();
        }

        //repaints
        repaint();
        timeCount++;
    }

    public void keyPressed(KeyEvent e)
    {

        if((e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) && hero.isPlatformBelow(levels[currentLevel]))
        {
            if(!hero.isPlatformAbove(platforms))
                hero.setIsJumping(true);

        }

        //number = speed
        if(e.getKeyCode() == KeyEvent.VK_D|| e.getKeyCode() == KeyEvent.VK_RIGHT && !hero.isPlatformRight(levels[currentLevel]))
        {
            hero.setIsMovingRight(true);
            hero.setIsFacingRight(true);

        }

        //number = speed
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT && !hero.isPlatformLeft(levels[currentLevel]))
        {
            hero.setIsMovingLeft(true);
            hero.setIsFacingRight(false);

        }

        if(e.getKeyCode() == KeyEvent.VK_O|| e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            hero.getGun().setIsShooting(true);
        }
    }

    public void keyReleased(KeyEvent e)  
    {
        if(e.getKeyCode() == KeyEvent.VK_O|| e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            hero.getGun().setIsShooting(false);
        }

        if(e.getKeyCode() == KeyEvent.VK_W|| e.getKeyCode() == KeyEvent.VK_UP)
        {
            hero.setIsJumping(false);
        }

        if(e.getKeyCode() == KeyEvent.VK_D|| e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            hero.setIsMovingRight(false);
        }

        if(e.getKeyCode() == KeyEvent.VK_A|| e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            hero.setIsMovingLeft(false);
        }
    }

    public void keyTyped(KeyEvent e) 
    {

    }

    //Buffering stuff
    public void start()
    {

        Thread t = new Thread(this);
        t.start();
    }

    public void run()
    { 
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        while (true)
        {
            repaint();
            try
            {   // Stop thread for 20 milliseconds
                Thread.sleep (20);  //throws an InterruptedException, so has be be in a try...
            }
            catch (InterruptedException ex){}
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        } 
    }

    public void update (Graphics g)
    {
        if (dbImage == null)
        {
            dbImage = createImage (this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics ();

        }
        // clear screen in background
        dbg.setColor (getBackground ());
        dbg.fillRect (0, 0, this.getSize().width, this.getSize().height);

        // draw elements in background
        dbg.setColor (getForeground());
        paint (dbg);

        // draw image on the screen
        g.drawImage (dbImage, 0, 0, this);

    }

    private Image dbImage;
    private Graphics dbg;

}

