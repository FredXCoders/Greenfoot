import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.UserInfo;
import greenfoot.World;
import java.awt.Color;
import java.lang.Math;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;

public class SimpleWorld extends World
{
    Saver mySaver = new Saver();
    int score = 0;
    int newEnemy = 75;
    int maxNewEnemy = 75;
    int minNewEnemy = 45;
    boolean godmode = false; //Godmode is for TESTING PURPOSES ONLY!! Not to be tampered with.
    boolean powerful = false;
    int enemyLevel = 0;
    List<EnemyInfo> enemyInformation = new ArrayList<EnemyInfo>();
    int worldLevel = 1;
    Player player;
    
    
    public SimpleWorld()
    {
        super(650, 500, 1);
        this.player = new Player(godmode, powerful);
        
        GreenfootImage myImage = new GreenfootImage(650, 500);
        myImage.setColor(new Color(0, 0, 0));
        myImage.fill();
        myImage.setColor(new Color(255, 255, 255));
        myImage.drawString("Score: " + this.score, 10, 20);
        myImage.drawString("Level: " + this.worldLevel, 100, 20);
        setBackground(myImage);
        if(UserInfo.isStorageAvailable()) {
            UserInfo player = UserInfo.getMyInfo();
            if(player.getUserName().equals("shrucis1")) {
                powerful = true;
            }
            else {
                powerful = false;
            }
        }
        else {
            powerful = false;
        }
        addObject(this.player, 325, 250);
        makeEnemyInformation();
    }
    
    public void makeEnemyInformation()
    {
        //EnemyInfo(boolean accel, int r, int g, int b, int speed, int aiLevel)
        enemyInformation.add(new EnemyInfo(false, 255, 0, 0, 0, 0));
        enemyInformation.add(new EnemyInfo(false, 220, 50, 100, 1, 0));
        enemyInformation.add(new EnemyInfo(false, 130, 100, 30, 1, 0));
        //enemyInformation.add(new EnemyInfo(true, 0, 0, 255, 0, 30));
    }
    
    public void act()
    {
        this.score += 1;
        levelStuff();
        enemyStuff();
    }
    
    public void gameOver()
    {
        this.mySaver.saveHighscore(this.score);
        Greenfoot.setWorld(new ScoreBoardWorld(this.score, this.worldLevel));
    }
    
    public void levelStuff(){
        Color bgColor = new Color(0, 0, 0); //default level color
        Color fontColor = new Color(255, 255, 255);
        
        //check if we're increasing the level
        if(this.worldLevel == 1 && this.score > 200){
            this.worldLevel = 2;
            this.enemyLevel++;
        }
        /*
        else if(this.worldLevel == 2 && this.score > 500){
            this.worldLevel = 3;
            this.enemyLevel++;
        }
        */
        
        //set the background for the current level
        if(this.worldLevel == 2 ){
            bgColor = new Color(0, 102, 102);
        } 
        /*
        else if(this.worldLevel == 3){
            bgColor = new Color(153, 0, 0);
        }
        */
        
        GreenfootImage myImage = new GreenfootImage(650, 500);
        myImage.setColor(bgColor);
        myImage.fill();
        myImage.setColor(fontColor);
        myImage.drawString("Score: " + this.score, 10, 20);
        myImage.drawString("Level: " + this.worldLevel, 100, 20);
        setBackground(myImage);        
    }
    
    public void enemyStuff()
    {
        this.newEnemy -= 1;
        if (this.newEnemy <= 0)
        {
            if(Greenfoot.getRandomNumber(100) < 70) {
                addEnemy(enemyLevel);
            }
            else {
                addEnemy(enemyLevel - 1);
            }
            if (this.maxNewEnemy > this.minNewEnemy) {
                this.maxNewEnemy -= 1;
            }
            this.newEnemy = this.maxNewEnemy;
        }
    }

    public void addEnemy(int level)
    {
        int rand = 1 + Greenfoot.getRandomNumber(4);
        EnemyInfo eInfo = enemyInformation.get(Math.min(Math.max(level, 0), enemyInformation.size()));
        if (rand == 1)
        {
            addObject(new Enemy(eInfo.accel, eInfo.r, eInfo.g, eInfo.b, eInfo.dif, eInfo.chance), 10, 10 + Greenfoot.getRandomNumber(480));
        }
        else if (rand == 2)
        {
            addObject(new Enemy(eInfo.accel, eInfo.r, eInfo.g, eInfo.b, eInfo.dif, eInfo.chance), 10 + Greenfoot.getRandomNumber(630), 10);
        }
        else if (rand == 3)
        {
            addObject(new Enemy(eInfo.accel, eInfo.r, eInfo.g, eInfo.b, eInfo.dif, eInfo.chance), 640, 10 + Greenfoot.getRandomNumber(480));
        }
        else if (rand == 4)
        {
            addObject(new Enemy(eInfo.accel, eInfo.r, eInfo.g, eInfo.b, eInfo.dif, eInfo.chance), 10 + Greenfoot.getRandomNumber(630), 490);
        }
    }
}


