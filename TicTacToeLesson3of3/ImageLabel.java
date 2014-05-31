import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ImageLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageLabel extends Actor
{
    
     /** 
        * Act - do whatever the ImageLabel wants to do. This method is called whenever 
        * the 'Act' or 'Run' button gets pressed in the environment. 
     */ 
    public ImageLabel(String message) { 
        // an image with the text of the String txt, size 20, black text color and transparent background  
        // refer to the documentation for more information about this constructor  
        GreenfootImage g = new GreenfootImage(message, 20, null, null);  
        setImage(g);   
    }
    
    /**
     * Act - do whatever the ImageLabel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
