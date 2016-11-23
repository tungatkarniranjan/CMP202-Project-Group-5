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
    World world;
    Button startButton;
    MessageActor message; 

    private static final int xPosition = 100;
    private static final int yPosition = 80; 
    
    int playersConnected = 0;
    int gameStarted = 0;
   
    NewGameScreen(){
        startButton = new StartButton();
        message = new MessageActor();
    }
    
    public void act() 
    {
        if(playersConnected == 0)
        {
            if(checkPlayersConnected())
            {
                playersConnected = 1;
            }
            World world = getWorld();
            String msg = "Waiting for another player to join!";            
            showMessage(xPosition,yPosition,msg,world);
        }
        else if(playersConnected == 1)
        {
            World world = getWorld();
            String msg = "Player Connected";
            showMessage(xPosition, yPosition, msg, world);
            if(gameStarted == 0)
            {
                if(checkIfGameStarted())
                {
                    gameStarted = 1;
                }
            }
            else if(gameStarted == 1)
            {
                gameStarted = 2;
                MyWorld myworld = (MyWorld)getWorld();
                //myworld.removeObjects(myworld.getObjects(MessageActor.class));                
                myworld.initializeMapScreen(); 
            }
        }
    }    
    
    public void addButtons(){
        world = getWorld();
        world.addObject(startButton,1300 , 650);
    }
    
    public void showMessage(int x, int y, String msg, World world)
    {
        message.showMessage(msg, world, x, y);
    }
    
    public boolean checkPlayersConnected()
    {
        Representation result_string = null;
        boolean player2connected = false;
        ClientResource client = ClientRequestManager.getClient(ClientRequestManager.getRequestURL("/verifyplayers"));
        try
        {
            result_string = client.get();
            JSONObject json = new JSONObject( result_string.getText() ) ;
            player2connected = (boolean)json.get("connected");    
        }
        catch(Exception error)
        {
            System.out.println(error);
        }
        return player2connected;
    }
    
    public boolean checkIfGameStarted()
    {
        Representation result_string = null;
        boolean gamestarted = false;
        ClientResource client = ClientRequestManager.getClient(ClientRequestManager.getRequestURL("/verifygamestarted"));
        try
        {
            result_string = client.get();
            JSONObject json = new JSONObject( result_string.getText() ) ;
            gamestarted = (boolean)json.get("started");    
        }
        catch(Exception error)
        {
            System.out.println(error);
        }
        return gamestarted;    
    }    
}
