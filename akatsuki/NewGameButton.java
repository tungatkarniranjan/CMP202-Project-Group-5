import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.restlet.*;
import org.restlet.resource.*;
import org.json.JSONObject ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;

/**
 * Write a description of class NewGameButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewGameButton extends Button
{
    public void act() 
    {
        if(greenfoot.Greenfoot.mouseClicked(this))
        {
            this.removeCustomObjects(HomeScreen.class);
        }
    }
    
    private void removeCustomObjects(Class cls)
    {
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
