import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player  extends Actor
{
    enum PlayerMode {PLAYER1, PLAYER2 };
    PlayerMode mode;
    public Player(){
        mode = PlayerMode.PLAYER1;
        setImage("ant-with-food.png");
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.mouseMoved(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        if (Greenfoot.mouseClicked(null)){
            GameBall ball = (GameBall)getOneIntersectingObject(GameBall.class);
            if(ball!=null){
                if (mode == PlayerMode.PLAYER1 ){
                    ball.setSteel();
                    setPlayer2();
                }
                else if (mode == PlayerMode.PLAYER2){
                    ball.setGold();
                    setPlayer1();
                }
            }
        }
    }
    
    public void setPlayer1(){
        mode = PlayerMode.PLAYER1;
        setImage("ant-with-food.png");
    }
    public void setPlayer2(){
        mode = PlayerMode.PLAYER2;
        setImage("ant.png");
    }
}
