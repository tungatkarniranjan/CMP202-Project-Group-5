import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NewGameScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewGameScreen extends Screens
{
    /**
     * Act - do whatever the NewGameScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    World world;
    Button startButton;
    
    NewGameScreen(){
        startButton = new StartButton();
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void addButtons(){
        world = getWorld();
        world.addObject(startButton,1300 , 650);
    }
}
