
public class Shotgun extends Gun
{
    Bullet b = getBullet();
    public Shotgun(int x, int y, int h, int w, ShotgunBullet b)
    {
        super(x,y,h,w,30,b,20,2);
    }
    
        public ShotgunBullet shoot()
    {
        if (getAmmo()>0)
        {
            ShotgunBullet shot = new ShotgunBullet(b.getXInt(),b.getYInt()+22);
            
            setAmmo(getAmmo()-1);
            return shot;
        }
        return null;
    
   }
}