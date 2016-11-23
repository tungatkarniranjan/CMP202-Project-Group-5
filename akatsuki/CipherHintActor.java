import greenfoot.*;
import java.awt.Font;
import java.awt.Color;


/**
 * Write a description of class CipherHintActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CipherHintActor extends Actor
{
    /**
     * Act - do whatever the CipherHintActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img;
    public CipherHintActor()
    {
        GreenfootImage img = new GreenfootImage (300, 100);  
    }
    
    public void showCipherHint(GreenfootImage hint, World world){
        
        setImage(hint);
        world.addObject(this, 600, 50); 
    }
}
