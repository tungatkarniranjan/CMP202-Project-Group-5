import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HomePage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeScreen extends Screens
{
    /**
     * Act - do whatever the HomePage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    World world;
    Button newGameButton;
    
    HomeScreen(){
        newGameButton = new NewGameButton();
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void addButtons(){
        world = getWorld();
        world.addObject(newGameButton,1300 , 150);
    }
    
}
