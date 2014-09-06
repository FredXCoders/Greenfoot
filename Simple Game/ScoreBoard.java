/*   1:    */ import greenfoot.Actor;
/*   2:    */ import greenfoot.GreenfootImage;
/*   3:    */ import greenfoot.UserInfo;
/*   4:    */ import java.awt.Color;
/*   5:    */ import java.util.List;
/*   ??:   */ import java.util.ArrayList; 
/*   6:    */ 
/*   7:    */ public class ScoreBoard
/*   8:    */   extends Actor
/*   9:    */ {
/*  10:    */   private static final int GAP = 10;
/*  11:    */   private static final int HEADER_TEXT_HEIGHT = 25;
/*  12: 27 */   private static final Color MAIN_COLOR = new Color(50, 50, 50);
/*  13: 29 */   private static final Color SCORE_COLOR = new Color(200, 100, 50);
/*  14: 31 */   private static final Color BACKGROUND_COLOR = new Color(100, 100, 100);
/*  15: 32 */   private static final Color BACKGROUND_HIGHLIGHT_COLOR = new Color(150, 150, 250);
/*  16:    */   
/*  17:    */   public ScoreBoard()
/*  18:    */   {
/*  19: 42 */     setImage(new GreenfootImage(300, 400));
/*  20:    */     
/*  21: 44 */     drawScores();
/*  22:    */   }
/*  23:    */   
/*  24:    */   private void drawString(String text, int x, int y, Color color, int height)
/*  25:    */   {
/*  26: 49 */     getImage().drawImage(new GreenfootImage(text, height, color, new Color(0, true)), x, y);
/*  27:    */   }
/*  28:    */   
/*  29:    */   private void drawScores()
/*  30:    */   {
/*  31: 55 */     int pixelsPerUser = 70;
/*  32:    */     
/*  33: 57 */     int numUsers = (getImage().getHeight() - 35) / 70;
/*  34: 58 */     int topSpace = getImage().getHeight() - numUsers * 70 - 10;
/*  35:    */     
/*  36: 60 */     getImage().setColor(BACKGROUND_COLOR);
/*  37: 61 */     getImage().fill();
/*  38:    */     
/*  39: 63 */     drawString("All Time", getImage().getWidth() / 2 - 35, topSpace - 25 - 5, MAIN_COLOR, 25);
/*  40:    */     
/*  41: 65 */     drawUserPanel(10, topSpace, getImage().getWidth() - 10, topSpace + numUsers * 70, numUsers);
/*  42:    */   }
/*  43:    */   
/*  44:    */   private void drawUserPanel(int left, int top, int right, int bottom, int numUsers)
/*  45:    */   {
                  List users = UserInfo.getTop(0);
                  List newusers = new ArrayList();
                  int t = 0;
                  for(Object obj : users) {
                      t ++;
                      if(obj instanceof UserInfo) {
                          UserInfo ui = (UserInfo)obj;
                          if((ui.getInt(0) == 1) && (t < numUsers+1)) {
                              newusers.add(ui);
                            }
                        }
                    }
/*  46: 71 */     getImage().setColor(MAIN_COLOR);
/*  47: 72 */     getImage().drawRect(left, top, right - left, bottom - top);
/*  48: 74 */     if (users == null) {
/*  49: 75 */       return;
/*  50:    */     }
/*  51: 77 */     UserInfo me = UserInfo.getMyInfo();
/*  52: 78 */     int y = top + 10;
                  int a = 1;
/*  53: 79 */     for (Object obj : newusers)
/*  54:    */     {
/*  55: 81 */       UserInfo playerData = (UserInfo)obj;
/*  56:    */       Color c;
/*  57:    */       
/*  58: 84 */       if ((me != null) && (playerData.getUserName().equals(me.getUserName()))) {
/*  59: 87 */         c = BACKGROUND_HIGHLIGHT_COLOR;
/*  60:    */       } else {
/*  61: 91 */         c = BACKGROUND_COLOR;
/*  62:    */       }
/*  63: 93 */       getImage().setColor(c);
/*  64: 94 */       getImage().fillRect(left + 5, y - 10 + 1, right - left - 10, 69);
/*  65:    */       
/*  66: 96 */       int x = left + 10;
/*  67: 97 */       //drawString("#" + Integer.toString(playerData.getRank()), x, y + 18, MAIN_COLOR, 14);
/*  67: 97 */       drawString("#" + Integer.toString(a), x, y + 18, MAIN_COLOR, 14);
/*  68: 98 */       x += 50;
/*  69: 99 */       drawString(Integer.toString(playerData.getScore()), x, y + 18, SCORE_COLOR, 14);
/*  70:100 */       x += 80;
/*  71:101 */       getImage().drawImage(playerData.getUserImage(), x, y);
/*  72:102 */       x += 55;
/*  73:103 */       drawString(playerData.getUserName(), x, y + 18, MAIN_COLOR, 14);
/*  74:104 */       y += 70; a++;
/*  75:    */     }
/*  76:    */   }
/*  77:    */ }

