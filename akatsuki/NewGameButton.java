import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NewGameButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewGameButton extends Button
{
    /**
     * Act - do whatever the NewGameButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(greenfoot.Greenfoot.mouseClicked(this)){
        // Do t hee stuff for cfreating the new Game
            this.removeCustomObjects(HomeScreen.class);
        }
    }
    
    private void removeCustomObjects(Class cls){
            World world = getWorld();
            Actor actor = getOneObjectAtOffset(0, 0, cls);
            this.displayNewGameScreen();
            world.removeObject(actor); 
            world.removeObject(this);
            
    }
    
    public void displayNewGameScreen()
    {
       MyWorld world = (MyWorld)getWorld();
       world.initializeNewGameScreen();
    
    }
}
