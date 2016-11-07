import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.restlet.*;
import org.restlet.resource.*;
import org.json.JSONObject ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;
/**
 * Write a description of class EnterButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 *
 */
public class StartButton extends Button
{
    /**
     * Act - do whatever the EnterButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String URL = "http://10.0.0.173:8080/gumball" ;
    ClientResource client = new ClientResource( URL );    
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
       turnCrank();
       
    }
    
    public void turnCrank() {
    
    JSONObject start_game = new JSONObject();
    start_game.put("action", "start_game");
    try
    {
            Representation result_string = client.post(new JsonRepresentation(start_game), MediaType.APPLICATION_JSON);
            System.out.println(result_string.getText());    
    
    }
    catch(Exception error)
    {
            System.out.println(error);
    }
    

  }
}
