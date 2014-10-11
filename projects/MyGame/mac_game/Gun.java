public class Gun
{
    private int rof;

    private int ammo;
    private int x,y,h,w, type;
    private Bullet b;
    private boolean isShooting;
    private int shootTimer;
    
    public Gun
    (int xLoc, int yLoc, int height, int width, int rateOfFire, Bullet bullet, int am, int type1) 
    {

        rof = rateOfFire;

        ammo = am;
        x = xLoc;
        y = yLoc;
        h = height;
        w = width;
        b = bullet;
        isShooting = false;
        type = type1;
        
   

    }
    public int getShootTimer()
    {
        return shootTimer;
    }
    
    public void setShootTimer(int i)
    {
        shootTimer = i;
    }
    
    public void setBullet(Bullet bul)
    {
      b  = bul;
    }
    
       public Bullet getBullet()
    {
      return b;
    }
    public boolean getIsShooting()
    {
        return isShooting;
    }
    
    public void setIsShooting(boolean b)
    {
        isShooting = b;
    }
    public Bullet shoot()
    {
        if (ammo>0)
        {
            Bullet shot = new Bullet(b.getXInt(),b.getYInt()+22,b.getWidth(),b.getHeight(),b.getDamage(),b.getDistance(),b.getSpeed(),b.getIsFriendly());
            
            ammo--;
            return shot;
        }
        return null;
    }
    
    public BossBullet shootb()
    {
        return null;
    }
    
    public int getRateOfFire()
    {
       return rof; 
    }
    
    public int getAmmo()
    {
        return ammo;   
    }
    
    public void setAmmo(int a)
    {
        ammo = a;
    }
    
    public int getType()
    {
        return type;    
    }
    
    public void changeType(int a)
    {
        type = a;
    }
    


    
    
}