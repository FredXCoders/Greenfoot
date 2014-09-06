import greenfoot.*;
import java.awt.Color;

public class Particle extends Actor
{
    double xPos;
    double yPos;
    double xVel;
    double yVel;
    int time = 1;
    boolean jc = true;
    
    public Particle(double xVel, double yVel, Color color, int time) {
        this.time = time;
        this.xVel = ((1.0 + ((Greenfoot.getRandomNumber(3)-1) * 0.05)) * xVel);
        this.yVel = ((1.0 + ((Greenfoot.getRandomNumber(3)-1) * 0.05)) * yVel);
        GreenfootImage myImage = new GreenfootImage(3 + Greenfoot.getRandomNumber(3), 3 + Greenfoot.getRandomNumber(3));
        myImage.setColor(color);
        myImage.fill();
        setImage(myImage);
        setRotation(Greenfoot.getRandomNumber(360));
    }
    public void act() 
    {
        if(jc) {
            xPos = getX();
            yPos = getY();
            jc = false;
        }
        setLocation((int)xPos, (int)yPos);
        xPos += xVel;
        yPos += yVel;
        time -= 1;
        if((time <= 0) || (atWorldEdge())) {
            getWorld().removeObject(this);
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
}
