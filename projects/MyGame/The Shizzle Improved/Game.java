import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.*;

public class Game extends Applet implements ActionListener, KeyListener, Runnable
{
    private ArrayList<Turret>[] turrets;
    private ArrayList<Turret> t1;
    private ArrayList<Turret> t2;
    private ArrayList<Turret> t3;
    private ArrayList<Turret> t4;
    private ArrayList<Turret> t5;
    private ArrayList<Turret> t6;
    private ArrayList<Turret> t7;
    private ArrayList<Turret> t8;
    private ArrayList<Turret> t9;
    private ArrayList<Turret> t10;
    private ArrayList<Turret> t11;
    private ArrayList<Turret> t12;
    private ArrayList<Explosion> explosions;
    private boolean isUp,isDown,isPRight,isPLeft;
    private ArrayList<Platform> platforms;
    private ArrayList<Platform> platforms1;
    private ArrayList<Platform> platforms2;
    private ArrayList<Platform> platforms3;
    private ArrayList<Platform> platforms7;
    private ArrayList<Platform> platforms5;
    private ArrayList<Platform> platforms6;
    private ArrayList<Platform> platforms8;
    private ArrayList<Platform> platforms9;
    private ArrayList<Platform> platforms10;
    private ArrayList<Platform> platforms11;
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
    private ArrayList<Person> enemies8;
    private ArrayList<Person> enemies9;
    private ArrayList<Person> enemies10;
    private ArrayList<Person> enemies11;

    private int lives;
    private int score;
    private String gunString;

    private ArrayList<Person>[] enemyLevel;

    public void init()
    {
        turrets = new ArrayList[11];
        t1 = new ArrayList<Turret>();
        //t1.add(new Turret(300,300,100,100));
        t2 = new ArrayList<Turret>();
        t3 = new ArrayList<Turret>();     
        t4 = new ArrayList<Turret>();   
        t4.add(new Turret(75,420,50,50));
        t5 = new ArrayList<Turret>();
        t6 = new ArrayList<Turret>();
        t7 = new ArrayList<Turret>();
        t8 = new ArrayList<Turret>();
        t8.add(new Turret(430,250,40,30));
        t9 = new ArrayList<Turret>();
        t10 = new ArrayList<Turret>();
        t11 = new ArrayList<Turret>();

        turrets[0] = t1;
        turrets[1] = t2;
        turrets[2] = t3;
        turrets[3] = t4;
        turrets[4] = t5;
        turrets[5] = t6;
        turrets[6] = t7;
        turrets[7] = t8;
        turrets[8] = t9;
        turrets[9] = t10;
        turrets[10] = t11;

        isUp = false;

        isDown = false;
        isPLeft = false;
        isPRight = false;

        score = 10000;
        explosions = new ArrayList<Explosion>();
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
        enemies8 = new ArrayList<Person>();
        enemies9 = new ArrayList<Person>();
        enemies10 = new ArrayList<Person>();
        enemies11 = new ArrayList<Person>();

        enemyLevel = new ArrayList[11];

        lives = 3;

        hero = new MainCharacter(0,400,30,50,100,gun);

        bullet = new Bullet(hero.getXInt(),hero.getYInt(),10,10,15,100,5,false);
        gun = new Gun(hero.getXInt(),hero.getYInt(),hero.getHeight(),hero.getWidth(),4,bullet,100,1);
        hero.setGun(gun);

        levels = new ArrayList[11];

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

        enemies1.add(new MeeleeEnemy(185,300));
        enemies1.add(new SuicideEnemy(300,200));
        enemies1.add(new SniperEnemy(600,300));

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

        enemies2.add(new MeeleeEnemy(400,400));
        enemies2.add(new SniperEnemy(300,150));
        enemies2.add(new SniperEnemy(300,10));
        enemies2.add(new SuicideEnemy(450,150));
        enemies2.add(new SniperEnemy(700,10));
        enemies2.add(new SniperEnemy(800,150));

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

        enemies3.add(new MeeleeEnemy(250,140));
        enemies3.add(new MeeleeEnemy(320,140));
        enemies3.add(new SuicideEnemy(200,40));
        enemies3.add(new SniperEnemy(450,420));
        enemies3.add(new SniperEnemy(250,400));
        enemies3.add(new MeeleeEnemy(700,100));
        enemies3.add(new SniperEnemy(700,400));

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
        platforms5.add(new Platform(0, 470, 75, 10));
        platforms5.add(new Platform(280, 470, 75, 10));
        platforms5.add(new Platform(440, 480, 75, 10));
        platforms5.add(new Platform(580, 470, 75, 10));
        platforms5.add(new Platform(720, 470, 75, 10));
        platforms5.add(new Platform(860, 470, 200, 200));
        //
        platforms5.add(new Platform(140, 415, 75, 5));
        platforms5.add(new Platform(0, 370, 75, 5));
        platforms5.add(new Platform(140, 320, 75, 5));
        platforms5.add(new Platform(420, 350, 75, 5));
        platforms5.add(new Platform(410, 200, 20, 10));
        platforms5.add(new Platform(485, 125, 20, 10));
        platforms5.add(new Platform(605, 125, 20, 10));
        platforms5.add(new Platform(725, 125, 20, 10));
        platforms5.add(new Platform(280, 275, 75, 5));
        platforms5.add(new Platform(560, 300, 75, 5));
        platforms5.add(new Platform(700, 360, 165, 5));
        platforms5.add(new Platform(775, 100, 150, 10));
        platforms5.add(new Platform(775, 100, 10, 180));
        platforms5.add(new Platform(860, 170, 10, 400));
        platforms5.add(new Platform(850, 340, 10, 10));
        platforms5.add(new Platform(785, 270, 10, 10));
        platforms5.add(new Platform(850, 195, 10, 10));
        platforms5.add(new Platform(-20,-100,20,800));
        platforms5.add(new Platform(1000,0,20,700));

        platforms5.add(new MysteryPlatform(0,250,30,30));

        enemies5.add(new SuicideEnemy(420,60)); 
        enemies5.add(new SuicideEnemy(495,60));
        enemies5.add(new SuicideEnemy(615,60));
        enemies5.add(new SuicideEnemy(735,60));
        enemies5.add(new MeeleeEnemy(420,300));
        enemies5.add(new MeeleeEnemy(560,400));
        enemies5.add(new SniperEnemy(560,240));
        enemies5.add(new MeeleeEnemy(420,400));
        enemies5.add(new MeeleeEnemy(300,400));

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

        enemies6.add(new MeeleeEnemy(75,400));
        enemies6.add(new MeeleeEnemy(325,400));
        enemies6.add(new MeeleeEnemy(845,400));
        //         enemies6.add(new MeeleeEnemy(525,400,30,42,200));
        //         enemies6.add(new MeeleeEnemy(325,400,30,42,200));
        enemies6.add(new MeeleeEnemy(555,400));
        //         enemies6.add(new MeeleeEnemy(725,400,
        enemies6.add(new MeeleeEnemy(875,400));
        enemies6.add(new MeeleeEnemy(975,430)); 
        enemies6.add(new MeeleeEnemy(625,430));
        enemies6.add(new SniperEnemy(675,430)); 
        enemies6.add(new SniperEnemy(875,430));    

        platforms7 = new ArrayList<Platform>();
        platforms7.add(new Platform(0,470,230,1000));
        platforms7.add(new Platform(10,400,60,5));
        platforms7.add(new Platform(120,400,60,5));
        platforms7.add(new Platform(75,330,50,5));
        platforms7.add(new Platform(10,270,60,5));
        platforms7.add(new Platform(125,270,60,5));
        platforms7.add(new Platform(75,200,50,5));
        platforms7.add(new Platform(10,130,60,5));
        platforms7.add(new Platform(125,130,220,5));
        platforms7.add(new MysteryPlatform(200,10,30,30));
        platforms7.add(new Platform(820,470,200,10));
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
        platforms7.add(new Platform(750,0,12,300));
        platforms7.add(new Platform(-20,-100,20,800));
        platforms7.add(new Platform(1000,0,20,700));

        enemies7.add(new MeeleeEnemy(600,200));
        enemies7.add(new SuicideEnemy(350,100));
        enemies7.add(new SniperEnemy(325,200)); 
        enemies7.add(new MeeleeEnemy(500,200));
        enemies7.add(new SuicideEnemy(500,50));
        enemies7.add(new SniperEnemy(50,100)); 

        platforms8 = new ArrayList<Platform>();

        platforms8.add(new Platform(0,480,50,300));
        platforms8.add (new MovingPlatform(50,470,50,20,0,2,200));
        platforms8.add(new Platform(140,100,50,10));
        platforms8.add(new Platform(200,160,50,10));
        platforms8.add(new Platform(260,220,50,10));
        platforms8.add(new Platform(320,280,50,10));
        platforms8.add(new Platform(375,290,100,10));
        
        platforms8.add (new MovingPlatform(650,250,20,60,0,4,40));
        platforms8.add (new MovingPlatform(650,120,20,60,0,4,40));
        platforms8.add (new MovingPlatform(650,380,20,60,0,4,40));
        platforms8.add (new MovingPlatform(800,300,30,10,0,3,100));
        platforms8.add (new MovingPlatform(800,200,30,10,0,3,100));
        platforms8.add (new MovingPlatform(800,400,30,10,0,3,100));
        platforms8.add (new MovingPlatform(500,470,50,10,2,0,200));
        platforms8.add(new Platform(-20,-100,20,800));
        platforms8.add(new Platform(1000,0,20,700));

        enemies8.add(new SuicideEnemy(800,30));
        enemies8.add(new SuicideEnemy(800,200));
        enemies8.add(new SuicideEnemy(800,300));

        platforms9 = new ArrayList<Platform>();
        platforms9.add(new Platform(0,470,50,50));
        platforms9.add (new MovingPlatform(50,470,60,500,0,3,80));
        platforms9.add (new MovingPlatform(110,200,60,500,0,-2,100));
        platforms9.add (new MovingPlatform(170,200,60,500,0,-3,50));
        platforms9.add (new MovingPlatform(230,470,60,500,0,3,70));
        platforms9.add (new MovingPlatform(290,250,60,500,0,-2,80));
        platforms9.add (new MovingPlatform(350,470,60,500,0,3,80));
        platforms9.add (new MovingPlatform(410,400,60,500,0,2,70));
        platforms9.add (new MovingPlatform(470,200,60,500,0,-3,50));
        platforms9.add (new MovingPlatform(530,470,60,500,0,3,70));
        platforms9.add (new MovingPlatform(590,220,60,500,0,-3,80));
        platforms9.add (new MovingPlatform(650,400,60,500,0,2,100));
        platforms9.add (new MovingPlatform(710,260,60,500,0,-3,70));
        platforms9.add (new MovingPlatform(770,470,60,500,0,3,60));
        platforms9.add (new MovingPlatform(830,470,60,500,0,2,80));
        platforms9.add (new MovingPlatform(890,470,60,500,0,3,70));
        platforms9.add (new MovingPlatform(950,470,60,500,0,3,90));
        platforms9.add(new MysteryPlatform(0,350,30,30));
        platforms9.add(new Platform(-20,-100,20,800));
        platforms9.add(new Platform(1000,0,20,700));

        enemies9.add(new SuicideEnemy(200,30));
        enemies9.add(new SuicideEnemy(400,30));
        enemies9.add(new SuicideEnemy(600,30));
        enemies9.add(new MeeleeEnemy(300,200));
        enemies9.add(new MeeleeEnemy(500,200));
        enemies9.add(new MeeleeEnemy(700,200));

        platforms10 = new ArrayList<Platform>();
        platforms10.add(new Platform(0,470,1500,50));
        platforms10.add(new Platform(700,200,150,270));
        platforms10.add (new MovingPlatform(100,430,500,40,3,0,70));
        platforms10.add (new MovingPlatform(250,390,400,40,2,0,90));
        platforms10.add (new MovingPlatform(300,350,300,40,3,0,105));
        platforms10.add (new MovingPlatform(400,310,250,40,2,0,105));
        platforms10.add (new MovingPlatform(480,270,200,40,3,0,70));
        platforms10.add(new MysteryPlatform(0,350,30,30));
        platforms10.add(new Platform(-20,-100,20,800));
        platforms10.add(new Platform(1000,0,20,700));

        enemies10.add(new MeeleeEnemy(500,100));
        enemies10.add(new MeeleeEnemy(700,100));
        
        platforms11 = new ArrayList<Platform>();
        platforms11.add(new Platform(0,470,1500,50));
        platforms11.add(new Platform(-20,-100,20,800));
        platforms11.add(new Platform(1000,0,20,700));
        platforms11.add(new Platform(850,100,20,700));
        platforms11.add(new MysteryPlatform(0,350,30,30));
        platforms11.add (new MovingPlatform(100,405,50,10,0,2,60));
        platforms11.add (new MovingPlatform(150,300,50,10,3,0,65));
        platforms11.add (new MovingPlatform(400,180,50,10,0,-2,60));
        platforms11.add (new MovingPlatform(50,200,50,10,3,0,100));
        platforms11.add (new MovingPlatform(0,200,50,10,0,2,70));
        platforms11.add (new MovingPlatform(80,60,50,10,3,0,125));
        platforms11.add(new Platform(450,80,20,220));
        platforms11.add(new Platform(470,225,50,10));
        platforms11.add (new MovingPlatform(550,350,50,10,2,0,100));
        platforms11.add (new MovingPlatform(800,350,50,10,0,3,80));
        
        enemies11.add(new MeeleeEnemy(80,10));
        enemies11.add(new SniperEnemy(400,130));
        enemies11.add(new SuicideEnemy(0,150));
        enemies11.add(new SniperEnemy(800,300));

        enemyLevel[0] = enemies;
        enemyLevel[1] = enemies1;
        enemyLevel[2] = enemies2;
        enemyLevel[5] = enemies3;
        enemyLevel[4] = enemies5;
        enemyLevel[6] = enemies7;
        enemyLevel[3] = enemies6;
        enemyLevel[7] = enemies8;
        enemyLevel[8] = enemies9;
        enemyLevel[9] = enemies10;
        enemyLevel[10] = enemies11;

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
        levels[7] = platforms8;
        levels[8] = platforms9;
        levels[9] = platforms10;
        levels[10] = platforms11;

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

            for(Turret t : turrets[currentLevel])
            {
                t.draw(g2);
            }
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
                g2.drawString("Use the Arrow Keys to move",300,120);
                g2.drawString("Press Up to fly!!!!*",300,140);
                g2.drawString("PRESS Space to shoot!",300,160);
                g2.drawString("Use W,A,S,D to controll the direction you shoot (ex. W+D to shoot up to the right)",300,180);
                g2.drawString("GET TO THE FLAG TO WIN AN AMAZING PRIZE!!!",300,200);
                //                 g2.drawString("MIGHTY WARRIOR NOW GO BE THE WINNING!!!!",370,220);
                g2.drawString("*limit of 75 pixels per flight",700,400);
                g2.drawString("Jump into the box for a new gun or power up!!",0,275);
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
            g2.setColor(Color.black);
            g2.drawRect(900,400,20,80);

            g2.setColor(new Color(192,9,9));
            g2.fillRect(880,400,40,25);
            g2.setColor(Color.black);
            g2.drawRect(880,400,40,25);

            hero.draw(g2);

            for (int i = levels[currentLevel].size()-1;i>=0;i--)
            {

                levels[currentLevel].get(i).draw(g2);
            }

            for (Bullet b: enemyBullets)
            {
                b.draw(g2);
            }

            for(Bullet b: myBullets)
            {

                b.draw(g2);
            }
            for(Explosion e: explosions)
            {
                e.draw(g2);
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

            if(hero.getGun().getType()==4)
            {
                gunString = "FlameThrower";
            }
            if(hero.getGun().getType()==5)
            {
                gunString = "Freeze Ray";
            }
            if(hero.getGun().getType()==6)
            {
                gunString = "Turret";
            }
            if(timeCount%5==0 && lives>0)
            {
                score--;
            }

            //freezes enemies
            for (Person p:enemyLevel[currentLevel])
            {
                if(p.getFreezeTimer()>0)
                {
                    p.setIsFrozen(true);
                    p.setFreezeTimer(p.getFreezeTimer()-1);

                    if(p instanceof SniperEnemy)
                    {
                        p.getGun().setIsShooting(false);
                    }
                }
                else
                    p.setIsFrozen(false);
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
            for(Turret t : turrets[currentLevel])
            {

                t.activateTurret(hero);

                t.deactivateTurret(hero);
                t.isInTurret(hero);

            }
            //jump
            if (hero.getIsJumping())
            {
                hero.jump(levels[currentLevel]);

            }
            //stops you if a platform is above you
            if(hero.isPlatformAbove(levels[currentLevel]))
                hero.setIsJumping(false);

            if (hero.isPlatformBelow(levels[currentLevel])&&!hero.getIsJumping())
            {
                hero.setCount(0);
                hero.setIsFalling(false);
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

                else if(p instanceof MovingPlatform)
                {

                    p.moveEnemies(enemyLevel[currentLevel],levels[currentLevel]);
                    p.moveMe(hero,levels[currentLevel]);
                    p.move();

                }

            }

            for (int i = 0;i<explosions.size();i++)
            {
                Explosion ex = explosions.get(i);
                if(ex.getHeight()>75||ex.intersects(hero))
                {
                    explosions.remove(i);
                    i--;
                }
                else 
                    ex.explode(hero,levels[currentLevel]);

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
                        if(bul instanceof FreezeBullet)
                        {
                            p.setFreezeTimer(p.getFreezeTimer()+8);
                        }
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

            if(hero.getIsCrouching())
            {
                hero.crouch();   
            }

            if(hero.getHeight()<50&&!hero.getIsCrouching())
            {
                hero.uncrouch();
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

                if (hero.getGun().getType()==4)
                    hero.getGun().setAmmo(200);
                if (hero.getGun().getType()==5)
                    hero.getGun().setAmmo(200);
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
                bull.setIsUp(isUp);
                bull.setIsDown(isDown);
                bull.setIsPRight(isPRight);
                bull.setIsPLeft(isPLeft);
                if(hero.getIsFacingRight())
                    bull.setX(hero.getX()+24);
                else
                    bull.setX(hero.getX());
                bull.setY(hero.getY()+20);

                if(bull != null)
                    myBullets.add(bull);

                if(hero.getGun().getType()==2)
                {
                    ShotgunBullet b2 = 
                        new ShotgunBullet(bull.getXInt(),bull.getYInt()+5);
                    b2.setIsFacingRight(hero.getIsFacingRight());
                    b2.setIsUp(isUp);
                    b2.setIsDown(isDown);
                    b2.setIsPRight(isPRight);
                    b2.setIsPLeft(isPLeft);

                    ShotgunBullet b3 = 
                        new ShotgunBullet(bull.getXInt(),bull.getYInt()+10);
                    b3.setIsFacingRight(hero.getIsFacingRight());
                    b3.setIsUp(isUp);
                    b3.setIsDown(isDown);
                    b3.setIsPRight(isPRight);
                    b3.setIsPLeft(isPLeft);

                    ShotgunBullet b4 = 
                        new ShotgunBullet(bull.getXInt(),bull.getYInt()-5);
                    b4.setIsFacingRight(hero.getIsFacingRight());
                    b4.setIsUp(isUp);
                    b4.setIsDown(isDown);
                    b4.setIsPRight(isPRight);
                    b4.setIsPLeft(isPLeft);

                    ShotgunBullet b5 = 
                        new ShotgunBullet(bull.getXInt(),bull.getYInt()-10);
                    b5.setIsFacingRight(hero.getIsFacingRight());
                    b5.setIsUp(isUp);
                    b5.setIsDown(isDown);
                    b5.setIsPRight(isPRight);
                    b5.setIsPLeft(isPLeft);

                    myBullets.add(b2);
                    myBullets.add(b3);
                    myBullets.add(b4);
                    myBullets.add(b5);
                }

                hero.getGun().setShootTimer(hero.getGun().getRateOfFire());

            }

            //enemy actions
            for(Person p: enemyLevel[currentLevel])
            {
                if(!p.isPlatformBelow(levels[currentLevel]))
                    p.fall(levels[currentLevel]);

                p.pace(levels[currentLevel]);

                if(p instanceof MeeleeEnemy && timeCount%20==0)
                    p.attack(hero,levels[currentLevel]);

                else if(p instanceof SuicideEnemy)
                {
                    SuicideEnemy s = new SuicideEnemy(p.getXInt(),p.getYInt());
                    if(s.willExplode(hero))
                    {
                        explosions.add(new Explosion(p.getXInt()+10,p.getYInt()+10));
                        p.attack(hero,levels[currentLevel]);
                    }

                }

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
                hero.setIsFalling(true);
                hero.fall(levels[currentLevel]);
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
            {

                b.move();

            }

            for (Bullet b : enemyBullets)

                b.move();
        }


        //repaints
        repaint();
        timeCount++;
    }

    public void keyPressed(KeyEvent e)
    {

        if((e.getKeyCode() == KeyEvent.VK_UP ) && hero.isPlatformBelow(levels[currentLevel])&&!hero.getIsCrouching())
        {
            if(!hero.isPlatformAbove(platforms))
                hero.setIsJumping(true);

        }

        //number = speed
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && !hero.isPlatformRight(levels[currentLevel]))
        {
            if(!hero.getIsCrouching())
                hero.setIsMovingRight(true);
            hero.setIsFacingRight(true);

        }

        //number = speed
        if(e.getKeyCode() == KeyEvent.VK_LEFT  && !hero.isPlatformLeft(levels[currentLevel]))
        {
            if(!hero.getIsCrouching())
                hero.setIsMovingLeft(true);
            hero.setIsFacingRight(false);

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN&& hero.getIsJumping()==false && hero.getIsFalling()==false)
        {
            hero.setIsCrouching(true);
            hero.setIsMovingRight(false);
            hero.setIsMovingLeft(false);

        }

        if(e.getKeyCode() == KeyEvent.VK_O|| e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            hero.getGun().setIsShooting(true);
        }

        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            isUp = true;

        }

        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            isDown = true;

        }

        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            isPRight = true;
            hero.setIsFacingRight(true);
        }

        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            isPLeft = true;
            hero.setIsFacingRight(false);
        }

    }

    public void keyReleased(KeyEvent e)  
    {
        if(e.getKeyCode() == KeyEvent.VK_O|| e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            hero.getGun().setIsShooting(false);
        }

        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            hero.setIsJumping(false);
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            hero.setIsMovingRight(false);
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            hero.setIsMovingLeft(false);
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            hero.setIsCrouching(false);

        }

        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            isUp = false;

        }

        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            isDown = false;

        }

        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            isPRight = false;

        }

        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            isPLeft = false;

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

