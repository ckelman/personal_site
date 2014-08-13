
public class Sniper extends Gun
{
    Bullet b = getBullet();
    public Sniper(int x, int y, int h, int w, SniperBullet b)
    {
        super(x,y,h,w,60,b,20,3);
    }
    
        public SniperBullet shoot()
    {
        if (getAmmo()>0)
        {
            SniperBullet shot = new SniperBullet(b.getXInt(),b.getYInt()+22);
            
            setAmmo(getAmmo()-1);
            return shot;
        }
        return null;
    
   }
}