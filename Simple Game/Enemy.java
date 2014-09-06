import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;
import java.awt.Color;
import java.lang.Math;
import java.util.List;

public class Enemy extends Actor
{
    boolean aiming = true;
    int timer = 50;
    int accel = 15 + Greenfoot.getRandomNumber(40);
    int speed = 4 + Greenfoot.getRandomNumber(3);
    boolean accelB = false;
    public boolean die = false;
    Color myColor;
    int chance = 0;
    
    public Enemy()
    {
        GreenfootImage myImage = new GreenfootImage(15, 15);
        myImage.setColor(new Color(255, 0, 0));
        myImage.fill();
        myImage.rotate(45);
        setImage(myImage);
    }
    
/* 26:   */   public Enemy(boolean accelB)
/* 27:   */   {
/* 28:23 */     GreenfootImage myImage = new GreenfootImage(15, 15);

/* 29:24 */     myImage.setColor(new Color(255, 0, 0));
/* 30:25 */     myImage.fill();
/* 31:26 */     myImage.rotate(45);
/* 32:27 */     setImage(myImage);
/* 33:28 */     this.accelB = accelB;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Enemy(boolean accelB, int r, int g, int b, int diff, int chance)
/* 37:   */   {
/* 38:33 */     GreenfootImage myImage = new GreenfootImage(15, 15);
                myColor = new Color(r, g, b);
/* 39:34 */     myImage.setColor(myColor);
/* 40:35 */     myImage.fill();
/* 41:36 */     myImage.rotate(45);
/* 42:37 */     setImage(myImage);
/* 43:38 */     this.accelB = accelB;
/* 44:39 */     this.speed += diff;
                this.chance = chance;
/* 45:   */   }
/* 46:   */   
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
/* 63:   */   
/* 64:   */   public void turnToPlayer()
/* 65:   */   {
/* 66:57 */     Actor a = (Actor)getWorld().getObjects(Player.class).get(0);
/* 67:58 */     turnTowards(a.getX(), a.getY());
/* 68:   */   }
              public void explode()
              {
                  int particles = 25 + Greenfoot.getRandomNumber(10);
                  for(int b = 0; b < particles; b++) {
                      int rot = (getRotation() + (Greenfoot.getRandomNumber(31)-15));
                      if(Greenfoot.getRandomNumber(3)==1)
                        rot = (getRotation() + (Greenfoot.getRandomNumber(91)-45));
                      getWorld().addObject(new Particle(0.8 * speed * Math.cos(Math.toRadians(rot)),
                        0.8 * speed * Math.sin(Math.toRadians(rot)),  
                        myColor, 5 + Greenfoot.getRandomNumber(31)), getX(), getY());
                  }
              }
/* 69:   */   
/* 70:   */   public void act()
/* 71:   */   {
/* 72:63 */     if (this.aiming)
/* 73:   */     {
/* 74:65 */       this.timer -= 1;
/* 75:66 */       turnToPlayer();
/* 76:67 */       if (this.timer == 0) {
/* 77:68 */         this.aiming = false;
/* 78:   */       }
/* 79:   */     }
/* 80:   */     else
/* 81:   */     {
/* 82:72 */       if (this.accelB) {
/* 83:73 */         this.accel -= 1;
/* 84:   */       }
/* 85:74 */       if (this.accel == 0)
/* 86:   */       {
/* 87:75 */         this.speed += (int)(((speed * 0.5) + 3.0)/2.0);
/* 88:76 */         if (Greenfoot.getRandomNumber(100) < chance) {
/* 89:77 */           turnToPlayer();
/* 90:   */         }
/* 91:79 */         this.accel = -1;
/* 92:   */       }
/* 93:81 */       move(this.speed);
/* 94:82 */       if (isTouching(Enemy.class))
/* 95:   */       {
                    die = true;
                    Enemy a = (Enemy)getOneIntersectingObject(Enemy.class);
                    die = true;
                    a.die = true;
                    explode();
                    a.explode();
/* :1:   */       }
               }

   if (atWorldEdge() || die) {
      getWorld().removeObject(this);
    }
/* :6:   */   }
/* :7:   */ }



/* Location:           C:\Users\jet\Downloads\greenfoot5764328479905462571.jar

 * Qualified Name:     Enemy

 * JD-Core Version:    0.7.0.1

 */