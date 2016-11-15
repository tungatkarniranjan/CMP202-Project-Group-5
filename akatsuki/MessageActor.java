import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;

/**
 * Write a description of class MessageActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MessageActor extends Actor
{

    //GreenfootImage waiting = new GreenfootImage();
    //GreenfootImage connected = new GreenfootImage();
    
    public void act() 
    {
        // Add your action code here.
    }  
    
    public void showMessage(int x, int y, String msg, World world)
    {
        world.showText(null,x,y);
        world.showText(msg,x,y);
    }
    
    public void hideMessage()
    {
        
    }

}
