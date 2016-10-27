import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnterButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Button
{
    /**
     * Act - do whatever the EnterButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
       
    public void act() 
    {
        // Add your action code here.
        if(greenfoot.Greenfoot.mouseClicked(this)){
            this.removeCustomObjects(NewGameScreen.class);
        }
    }    
    
    private void removeCustomObjects(Class cls){
            World world = getWorld();
            Actor actor = getOneObjectAtOffset(0, 0, cls);
            this.displayMapScreen();
            world.removeObject(actor); 
            world.removeObject(this);
            
    }
    
    public void displayMapScreen()
    {
       MyWorld world = (MyWorld)getWorld();
       world.initializeMapScreen();
    
    }
    
    
}
