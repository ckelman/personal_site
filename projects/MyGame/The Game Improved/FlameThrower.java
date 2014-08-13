

public class FlameThrower extends Gun
{
    Bullet b = getBullet();
    public FlameThrower(int x, int y, int w,int h,FlameThrowerBullet b)
    {
        super(x,y,w,h,2,b,200,4);
    }

        public FlameThrowerBullet shoot()
        {
        if (getAmmo()>0)
        {
            
            FlameThrowerBullet shot = new FlameThrowerBullet(b.getXInt(),b.getYInt()+22);
            setAmmo(getAmmo()-1);
            return shot;
        }
        return null;
    }

}