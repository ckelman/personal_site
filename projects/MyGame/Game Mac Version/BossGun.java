

public class BossGun extends Gun
{
    Bullet b = getBullet();
    public BossGun(int x, int y, int w,int h,BossBullet b)
    {
        super(x,y,w,h,2,b,200,4);
    }

        public BossBullet shootb()
        {
        if (getAmmo()>0)
        {
            
            BossBullet shot = new BossBullet(b.getXInt(),b.getYInt()+22);
            
            return shot;
        }
        return null;
    }

}