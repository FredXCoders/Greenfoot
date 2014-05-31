import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board  extends World
{
    GameBall cell_1, cell_2, cell_3, cell_4, cell_5, cell_6, cell_7, cell_8, cell_9;
    Player player;
    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(3, 3, 60); 
        setBackground("cell.jpg");
        cell_1 = new GameBall();
        addObject(cell_1, 0, 0);
        cell_2 = new GameBall();
        addObject(cell_2, 1, 0);
        cell_3 = new GameBall();
        addObject(cell_3, 2, 0);
        cell_4 = new GameBall();
        addObject(cell_4, 0, 1);
        cell_5 = new GameBall();
        addObject(cell_5, 1, 1);        
        cell_6 = new GameBall();
        addObject(cell_6, 2, 1);
        cell_7 = new GameBall();
        addObject(cell_7, 0, 2);
        cell_8 = new GameBall();                
        addObject(cell_8, 1, 2);
        cell_9 = new GameBall();
        addObject(cell_9, 2, 2);        
        
        player = new Player();
        addObject(player, 0,0);
        
    }
    
    public void act(){
        if (    //check if gold wins
            ( cell_1.isGold() && cell_2.isGold() && cell_3.isGold() ) 
        )
        {
            //Gold Wins!
            cell_1.setWinIfGold();cell_2.setWinIfGold();cell_3.setWinIfGold();
            cell_4.setWinIfGold();cell_5.setWinIfGold();cell_6.setWinIfGold();
            cell_7.setWinIfGold();cell_8.setWinIfGold();cell_9.setWinIfGold();
            player.setPlayer2();
            addObject(new ImageLabel("Gold Wins!"), 1, 1);  
            Greenfoot.stop();
        }
        else{
            if (    //check if steel wins
                ( cell_1.isSteel() && cell_2.isSteel() && cell_3.isSteel() )
            )
            {
                //Steel wins!
                cell_1.setWinIfSteel();cell_2.setWinIfSteel();cell_3.setWinIfSteel();
                cell_4.setWinIfSteel();cell_5.setWinIfSteel();cell_6.setWinIfSteel();
                cell_7.setWinIfSteel();cell_8.setWinIfSteel();cell_9.setWinIfSteel();
                player.setPlayer1();
                addObject(new ImageLabel("Steel Wins!"), 1, 1);  
                Greenfoot.stop();
            }  
        }
    }
}
