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
    CipherHintActor cipherHint;
    MouseInfo mouse;
    City selectedCity;
    cipher cipherObject;
    int xTarget;
    int yTarget;
    boolean gameOver = false;
    boolean isWin = false;
    
    GermanyMapScreen(){
        world = getWorld();
        cities.add("Munich");
        cities.add("Frankfurt");
        cities.add("Hamburg");       
        cities.add("Berlin");
        
        cipherShow = new CipherHintShow();
        cipherHint = new CipherHintActor();
        int counter = 0;
        
        for(counter = 0; counter < cities.size(); counter++){   
            GreenfootImage cityImg = new GreenfootImage("./images/"+cities.get(counter) + ".png");
            City city = new City(cities.get(counter), cityImg, 100, 100);
            CityStore.add(city);
        }
    }
    
    public void removeEnemies(){
        world.removeObjects(world.getObjects(Enemy.class));
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
                        removeEnemies();
                        isWin = true;
                        WinActor winActor = new WinActor();
                        winActor.displayMessage(world);
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
               System.out.println("Your game is over"); 
               gameOver = true;
            }
            else{
                System.out.println("Your game is NOT over"); 
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
        }else{
            if(!getWorld().getObjects(Enemy.class).isEmpty()){
                List<Enemy> allEnemyObjects = getWorld().getObjects(Enemy.class);
                int yOffset = -60;
                for(Enemy enemy :allEnemyObjects){
                        if(isWin == false){
                            enemy.attack(xTarget, yTarget + yOffset, xTarget, yTarget);
                            yOffset += 30;
                        }
                       
                }
          }
        }
    }   
    
    public void plotCities(int targetCity){
 
        int xPos = 500;
        int x = 450;
        int y = 350;
        world = getWorld();
        for(int i = 0; i < CityStore.size()/2; i++)
        { 
            world.addObject(CityStore.get(i), x, y);
            world.showText(CityStore.get(i).cityName, x, y+70);
            if(targetCity == i){
                this.xTarget = x;
                this.yTarget = y;
            }
            x = x + 450;
        }
        x = xPos;
        y = y + 350;
        for(int j = CityStore.size()/2; j < CityStore.size(); j++)
        {
            world.addObject(CityStore.get(j), x, y);
            world.showText(CityStore.get(j).cityName,x , y+70);
            if(targetCity == j)
            {
                this.xTarget = x;
                this.yTarget = y;
            }
            x = x + 450;
        }
        
    }
    
    public void setCipher(cipher cipherObject, int targetCity){
        System.out.println("Here in cipher req");
        this.cipherObject = cipherObject;
        String city = cities.get(targetCity);
        System.out.println(city);
        String encryptedCity = this.cipherObject.encrypt(city);
        System.out.println(encryptedCity);
        System.out.println("This is here in setting icpher");
        cipherShow.showCipherText(encryptedCity, world);
        cipherHint.showCipherHint((GreenfootImage)cipherObject.getHint(), world);
        //cipherShow.showCipherHint((GreenfootImage)cipherObject.getHint(), world);
    
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
