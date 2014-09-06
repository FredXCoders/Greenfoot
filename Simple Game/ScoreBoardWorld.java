/*  1:   */ import greenfoot.GreenfootImage;
/*  2:   */ import greenfoot.World;
/*  3:   */ import java.awt.Color;
/*  4:   */ 
/*  5:   */ public class ScoreBoardWorld
/*  6:   */   extends World
/*  7:   */ {
/*  8:   */   public ScoreBoardWorld(int score, int level)
/*  9:   */   {
/* 10: 8 */     super(650, 500, 1);
/* 11: 9 */     addObject(new ScoreBoard(), getWidth() / 2, getHeight() / 2);
/* 12:10 */     GreenfootImage myImage = new GreenfootImage(650, 500);
/* 13:11 */     myImage.setColor(new Color(0, 0, 0));
/* 14:12 */     myImage.fill();
                myImage.setColor(new Color(255, 255, 255));
                myImage.drawString("Score: " + score, 10, 20);
                myImage.drawString("Level: " + level, 100, 20);
/* 15:13 */     setBackground(myImage);
/* 16:   */   }
/* 17:   */ }

