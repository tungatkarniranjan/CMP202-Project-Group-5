import java.util.*;
import greenfoot.*;
import java.awt.Color;
import org.restlet.*;
import org.restlet.resource.*;
import org.json.JSONObject ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;


public class MyWorld extends World
{
    //Screen Definitions
    Screens homeScreen;     
    Screens newGameScreen;
    RandomUtitility randomUtility;
    
    //Game Environment Definitions
    int map = -9999;
    int cipher = -9999;
    int city = -9999;
    int enemy = -9999;
    

    ArrayList <CipherActor>CipherStore = new ArrayList<CipherActor>();
    ArrayList <Enemy>EnemyStore = new ArrayList<Enemy>();    
    private static final int CITIES = 5;
    private static final int MAPS = 2;
    private static final int CIPHERS = 2;
    private static final int ENEMIES = 3;
    
    public MyWorld()
    {
        super(1600, 800, 1);
        
        //Add cipher to the cipher store
        CipherStore.add(new CipherActorOne());
        //CipherStore.add(new CipherTwo());
        
        EnemyStore.add(new EnemyTank());
       
        initializeHomeScreen();
        initializeRandomUitility();
        
    }
    
    public void initializeHomeScreen()
    {
        homeScreen = new HomeScreen();
        addObject(homeScreen, 800, 400);
        homeScreen.addButtons();
    }
    
    
    public void initializeNewGameScreen()
    {
        make_newgame_request();
        newGameScreen = new NewGameScreen();
        addObject(newGameScreen, 800, 400);
        newGameScreen.addButtons();

    }
    
    public void initializeRandomUitility()
    {
       randomUtility = new RandomUtitility();
      // randomUtility.initializeMapScreenRegister();
    }
    
    public void initializeMapScreen()
    {
        MapSelector mapSelector = new MapSelector();
        MapScreen randomMap = mapSelector.produceMap(this.map);
        addObject(randomMap, 800, 400);
        randomMap.plotCities();
        
        CipherSelector cipherSelector = new CipherSelector();
        cipher randomCipher = cipherSelector.produceCipher(this.cipher); 
    }
    
    public void make_newgame_request()
    {
        ClientResource client = ClientRequestManager.getClient(ClientRequestManager.getRequestURL("/newgame"));   
        try
        {
            //Create a json request object containing total maps, total cities, total ciphers, total enemies
            JSONObject newGame = new JSONObject();
            newGame.put("action", "newgame"); //some player has pressed new game button
            newGame.put("maps",MAPS); //add total number of maps available
            newGame.put("cities",CITIES); //add total number of cities available            
            newGame.put("ciphers",CIPHERS); //add total number of cipher available
            newGame.put("enemies",EnemyStore.size()); //add total number of enemy available
                                 
            Representation result_string = client.post(new JsonRepresentation(newGame), MediaType.APPLICATION_JSON);
            JSONObject json = new JSONObject( result_string.getText() ) ;
            this.map = (int) json.get("map") ;
            this.city = (int) json.get("city");
            this.cipher = (int) json.get("cipher");
            this.enemy = (int) json.get("enemy");            
        }
        catch(Exception error)
        {
            System.out.println("Something went wrong : "+error);
        }
    }
}
