import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import org.restlet.*;
import org.restlet.resource.*;
import org.json.JSONObject ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;

/**
 * Write a description of class FranceMapScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)wo
 */
public class GermanyMapScreen extends MapScreen
{
    /**
     * Act - do whatever the GermanyMapScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    ArrayList <City>CityStore = new ArrayList<City>();
    ArrayList <String>cities = new ArrayList<String>();
    ArrayList <Enemy>enemies = new ArrayList<>();
    World world;
    
    EnemyTank enemyTank;
    CipherHintShow cipherShow;
    MouseInfo mouse;
    City selectedCity;
    cipher cipherObject;
    boolean gameOver = false;
    
    GermanyMapScreen(){
        world = getWorld();
        cities.add("Paris");
        cities.add("Munich");
        cities.add("Frankfurt");
        
        cipherShow = new CipherHintShow();
        int counter = 0;
        
        for(counter = 0; counter < cities.size(); counter++){   
            GreenfootImage cityImg = new GreenfootImage("./images/"+cities.get(counter) + ".png");
            City city = new City(cities.get(counter), cityImg, 100, 100);
            CityStore.add(city);
        }
    }
    
    public void checkResult(){
    
        if(greenfoot.Greenfoot.mouseClicked(null)){
            mouse = Greenfoot.getMouseInfo();
            Actor city  = mouse.getActor();
            if(city instanceof City){
                selectedCity = (City)city; 
                System.out.println("Hey you clicked");
            }
            
            if(selectedCity.cityName == this.cipherObject.decrypt("")){
                try{
                    ClientResource client = ClientRequestManager.getClient(ClientRequestManager.getRequestURL("/verifycitysaved"));   
                    System.out.println("Yes, Correct City");
                    JSONObject gameResult = new JSONObject();
                    gameResult.put("citysaved",true);
                    
                    Representation result_string = client.post(new JsonRepresentation(gameResult), MediaType.APPLICATION_JSON);
                    JSONObject json = new JSONObject( result_string.getText() ) ;
                    if((boolean)json.get("winstatus")){
                        System.out.println("You saved the city");
                    }
                }catch(Exception e){
                    System.out.println("Unexpected exception occurred" + e);
                }
                
            }
            
        }
    }
    
    public void verifyGameOver(){
            try{
            ClientResource client = ClientRequestManager.getClient(ClientRequestManager.getRequestURL("/verifygameover"));   

            Representation result_string = client.get();
            JSONObject json = new JSONObject(result_string.getText());
            if((boolean)json.get("over")){
               System.out.println("Youor game is over"); 
               gameOver = true;
            }
            else{
                System.out.println("Youor game is NOT over"); 
            }
            
        }catch(Exception e){
            System.out.println("Unexpected exception occurred" + e);
        }

    
    }
    
    public void act() 
    {
        
        checkResult();
        if(!gameOver){
            verifyGameOver();
        }
        

/*        if(greenfoot.Greenfoot.mouseClicked(null)){
            mouse = Greenfoot.getMouseInfo();
            Actor city  = mouse.getActor();
            if(city instanceof City){
                selectedCity = (City)city; 
                System.out.println("Hey you clicked");
            }
            
            if(selectedCity.cityName == this.cipherObject.decrypt("")){
                try{
                    ClientResource client = ClientRequestManager.getClient(ClientRequestManager.getRequestURL("/verifycitysaved"));   
                    System.out.println("Yes, Correct City");
                    JSONObject gameResult = new JSONObject();
                    gameResult.put("citysaved",true);
                    
                    Representation result_string = client.post(new JsonRepresentation(gameResult), MediaType.APPLICATION_JSON);
                    JSONObject json = new JSONObject( result_string.getText() ) ;
                    if((boolean)json.get("winstatus")){
                        System.out.println("You saved the city");
                    }
                }catch(Exception e){
                    System.out.println("Unexpected exception occurred" + e);
                }
                
            }
            
        }
        
        try{
            ClientResource client = ClientRequestManager.getClient(ClientRequestManager.getRequestURL("/verifygameover"));   

            Representation result_string = client.get();
            JSONObject json = new JSONObject(result_string.getText());
            if((boolean)json.get("over")){
               System.out.println("Youor game is over"); 
            }
            else{
                System.out.println("Youor game is NOT over"); 
            }
            
        }catch(Exception e){
            System.out.println("Unexpected exception occurred" + e);
        }*/

    }   
    
    public void plotCities(){
 
        int x = 0;
        int y = 0;
        world = getWorld();
        enemyTank = new EnemyTank();
        for(int i = 0; i < CityStore.size(); i++)
        {
            world.addObject(CityStore.get(i), x+100, y+100);
            x = x + 400;
            y = y + 350;
        }
        
        world.addObject(enemyTank, 800, 400);
        
        //City city1 = new City("Paris",null, 100, 100 );
        //World world1 = getWorld();
        //world1.addObject(city1,300, 300);
    }
    
    public void setCipher(cipher cipherObject, int targetCity){
        this.cipherObject = cipherObject;
        String city = cities.get(targetCity);
        System.out.println(city);
        String encryptedCity = this.cipherObject.encrypt(city);
        System.out.println(encryptedCity);
        cipherShow.showCipherText(encryptedCity, world);
    
    }
    
    public void setEnemy(int enemyId){
        int counter = 0;
        int x = 400;
        int y = 500;
        EnemySelector enemySelector = new EnemySelector();
        for(counter = 0; counter < ENEMYCOUNT; counter ++){
            Enemy enemy = enemySelector.produceEnemies(enemyId);
            enemies.add(enemy);
            world.addObject(enemy, x, y);
            x += 100;
            y += 100;
        }
    }
    
}
