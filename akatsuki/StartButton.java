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
       makeStartGameRequest();
       world.initializeMapScreen();
    }
    
    public void makeStartGameRequest() 
    {
        String startGameURL = "http://10.0.0.173:8080/startgame" ;
        ClientResource client = getClient(startGameURL);
        try
        {
            Representation result_string = client.get();
            System.out.println(result_string.getText());    
        }
        catch(Exception error)
        {
            System.out.println(error);
        }
    }
    
    public ClientResource getClient(String URL)
    {
        ClientResource client = new ClientResource(URL);
        return client;
    }
}
