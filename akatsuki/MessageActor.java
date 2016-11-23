import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class MessageActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MessageActor extends Actor
{

    private static GreenfootImage img;
    
    public void act() 
    {
        // Add your action code here.
    }  
    
    public void initImage(String text)
    {
        GreenfootImage textImage = new GreenfootImage(text, 20, Color.black, new Color(0, 0, 0, 0));
        img = new GreenfootImage(textImage.getWidth()+20, textImage.getHeight()+10);
        img.drawRect(0, 0, img.getWidth()-1, img.getHeight()-1);
        img.drawImage(textImage, (img.getWidth()-textImage.getWidth())/2, (img.getHeight()-textImage.getHeight())/2);
    }
    
    public void showMessage(String textMsg, World world, int x, int y)
    {
        initImage(textMsg);
        setImage(img);
        world.addObject(this, x, y);
    }
    
    public void hideMessage(World world)
    {
        world.removeObjects(world.getObjects(MessageActor.class));
    }
}
