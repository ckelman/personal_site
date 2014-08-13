

public class FreezeRay extends Gun
{
    Bullet b = getBullet();
    public FreezeRay(int x, int y, int w,int h,FreezeBullet b)
    {
        super(x,y,w,h,2,b,200,5);
    }

        public FreezeBullet shoot()
        {
        if (getAmmo()>0)
        {
            
            FreezeBullet shot = new FreezeBullet(b.getXInt(),b.getYInt()+22);
            setAmmo(getAmmo()-1);
            return shot;
        }
        return null;
    }

}