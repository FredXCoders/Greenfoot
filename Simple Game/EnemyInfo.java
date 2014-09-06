import greenfoot.*;

public class EnemyInfo
{
    public boolean accel;
    public int r;
    public int g;
    public int b;
    public int dif;
    public int chance;
    
    public EnemyInfo(boolean accel, int r, int g, int b, int dif, int chance)
    {
        this.accel = accel;
        this.r = r;
        this.g = g;
        this.b = b;
        this.dif = dif;
        this.chance = chance;
    }
}
