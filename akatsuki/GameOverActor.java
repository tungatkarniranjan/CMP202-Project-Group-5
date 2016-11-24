import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverActor extends Actor
{
    GreenfootImage img;
    
    public GameOverActor()
    {

    }
    
    public void displayMessage(World world){
        GreenfootImage img = new GreenfootImage("./images/gameover.png");
        setImage(img);
        world.addObject(this, 800, 200);
    }
}
