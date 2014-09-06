/*  1:   */ import greenfoot.UserInfo;
/*  2:   */ 
/*  3:   */ public class Saver
/*  4:   */ {
/*  5:   */   private UserInfo player;
/*  6:   */   
/*  7:   */   public Saver()
/*  8:   */   {
/*  9:16 */     if ((UserInfo.isStorageAvailable()) && 
/* 10:17 */       (UserInfo.getMyInfo() != null)) {
/* 11:18 */       this.player = UserInfo.getMyInfo();
/* 12:   */     }
/* 13:   */   }
/* 14:   */   
/* 15:   */   public void saveHighscore(int score)
/* 16:   */   {
/* 17:25 */     if ((UserInfo.isStorageAvailable()) && 
/* 18:26 */       (this.player != null) && 
/* 19:27 */       ((score > this.player.getScore()) || (this.player.getInt(0) == 0)))
/* 20:   */     {
/* 21:28 */       this.player.setScore(score);
                  this.player.setInt(0, 1);
/* 22:29 */       this.player.store();
/* 23:   */     }
/* 17:25 */     if ((UserInfo.isStorageAvailable()) && 
/* 18:26 */       (this.player != null) && 
/* 19:27 */       (score > this.player.getScore()))
/* 20:   */     {
/* 21:28 */       this.player.setScore(score);
                  this.player.setInt(0, 1);
/* 22:29 */       this.player.store();
/* 23:   */     }
/* 24:   */   }
/* 25:   */ }

