import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBall  extends Actor
{
    enum BallState { UNCLICKED, GOLD, STEEL };
    BallState state = BallState.UNCLICKED;
    GameBall(){
        setImage("cell.jpg");
    }
    /**
     * Act - do whatever the GameBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public void setGold(){
        setImage("gold-ball.png");
        state=BallState.GOLD;       
    }
    public void setSteel(){
        setImage("steel-ball.png");
        state = BallState.STEEL;
    }
    public void reset(){
        setImage("cell.jpg");
        state = BallState.UNCLICKED;
    }
    public boolean isUnclicked(){
        return (state == BallState.UNCLICKED);
    }
    public boolean isGold(){
        return (state==BallState.GOLD);
    }
    public boolean isSteel(){
        return (state==BallState.STEEL);
    }
    
    public void setWinIfGold(){
        if (state == BallState.GOLD){
            setImage("ball.png");
        }
    }
    public void setWinIfSteel(){
        if ( state == BallState.STEEL){
            setImage("ball.png");
        }
    }
}
