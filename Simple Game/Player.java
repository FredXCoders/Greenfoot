import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;
import java.awt.Color;

public class Player extends Actor
{
    double xVel = 0.0D;
    double yVel = 0.0D;
    double accel = 0.4D;
    double xPos = 0.0D;
    double yPos = 0.0D;
    double maxVel = 6.0D;
    boolean justCreated = true;
    boolean prowess = false;
    boolean godded = false;
    int lives = 1;
    
    
    public Player(boolean godded, boolean prowess)
    {
        GreenfootImage myImage = new GreenfootImage(20, 20);
        myImage.setColor(new Color(0, 255, 0));
        myImage.fill();
        setImage(myImage);
        this.godded = godded;
        this.prowess = prowess;
    }
    
    public void act()
    {
        if (this.justCreated)
        {
            this.xPos = getX();
            this.yPos = getY();
            this.justCreated = false;
        }
        if(prowess) {
            if(Greenfoot.isKeyDown("o")) {
                if(getObjectsInRange(80, Enemy.class).size() != 0) {
                    Enemy e = (Enemy)getObjectsInRange(80, Enemy.class).get(0);
                    e.explode();
                    e.die = true;
                }
            }
        }
        if (Greenfoot.isKeyDown("right")) {
            this.xVel += this.accel;
            if(xVel < 0)
                xVel += this.accel;
        }
        if (Greenfoot.isKeyDown("left")) {
            this.xVel -= this.accel;
            if(xVel > 0)
                xVel -= this.accel;
        }
        if (Greenfoot.isKeyDown("down")) {
            this.yVel += this.accel;
            if(yVel < 0)
                yVel += this.accel;
        }
        if (Greenfoot.isKeyDown("up")) {
            this.yVel -= this.accel;
            if(yVel > 0)
                yVel -= this.accel;
        }
        if (this.xVel > this.maxVel) {
            this.xVel = this.maxVel;
        }
        if (this.xVel < -1.0D * this.maxVel) {
            this.xVel = (-1.0D * this.maxVel);
        }
        if (this.yVel > this.maxVel) {
            this.yVel = this.maxVel;
        }
        if (this.yVel < -1.0D * this.maxVel) {
            this.yVel = (-1.0D * this.maxVel);
        }
        this.xPos += this.xVel;
        this.yPos += this.yVel;
        setLocation((int)this.xPos, (int)this.yPos);
        if (((isTouching(Enemy.class)) || (atWorldEdge())) && (!godded))
        {
            World myWorld = getWorld();
            if ((myWorld instanceof SimpleWorld))
            {
                SimpleWorld nWorld = (SimpleWorld)myWorld;
                nWorld.gameOver();
                /*
                if(lives <= 0){
                    nWorld.gameOver();
                } else {
                    lives--;
                    for(Object o : getObjectsInRange(80, Enemy.class)) {
                        Enemy e = (Enemy)o;
                        e.explode();
                        e.die = true;
                    }
                }
                */
            }
        }
    }
    
    public boolean atWorldEdge()
    {
        if (getX() < 5) {
            return true;
        }
        if (getX() > 645) {
            return true;
        }
        if (getY() < 5) {
            return true;
        }
        if (getY() > 495) {
            return true;
        }
        return false;
    }
    
    public int getLives(){
        return this.lives;
    }
    
    public void setPowerful(boolean isPowerful){
        this.prowess = isPowerful;
    }
}