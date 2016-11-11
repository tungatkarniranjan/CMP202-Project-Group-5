import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.restlet.*;
import org.restlet.resource.*;
import org.json.JSONObject ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;
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

    private String URL = "http://10.0.0.173:8080/verifyplayers" ;
    ClientResource client = new ClientResource( URL );     
    
    NewGameScreen(){
        startButton = new StartButton();
    }
    
    public void act() 
    {
        if(checkPlayersConnected())
        {
            World world = getWorld();
            world.showText("Player Connected", 400, 400);
        }
        else
        {
            World world = getWorld();
            world.showText("Waiting for another player to join!", 700, 400);            
        }
    }    
    
    public void addButtons(){
        world = getWorld();
        world.addObject(startButton,1300 , 650);
    }
    
    public boolean checkPlayersConnected()
    {
        Representation result_string = null;
        boolean player2connected = false;
        try
        {
            result_string = client.get();
            JSONObject json = new JSONObject( result_string.getText() ) ;
            player2connected = (boolean)json.get("connected");    
            System.out.println(player2connected);
        }
        catch(Exception error)
        {
            System.out.println(error);
        }
        return player2connected;
    }
    
}
