import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class FranceMapScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)wo
 */
public class FranceMapScreen extends MapScreen
{
    /**
     * Act - do whatever the FranceMapScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    ArrayList <City>CityStore = new ArrayList<City>();
    ArrayList <String>cities = new ArrayList<String>();
    ArrayList <Enemy>enemies = new ArrayList<>();
    World world;
    
    EnemyTank enemyTank;
    CipherHintShow cipherShow;

    FranceMapScreen(){
        world = getWorld();
        cities.add("Paris");
        cities.add("Munich");
        cities.add("Frankfurt");
            
        cipherShow = new CipherHintShow();
        int counter = 0;
        
        for(counter =0; counter < cities.size(); counter++){   
            GreenfootImage cityImg = new GreenfootImage("./images/"+cities.get(counter) + ".png");
            City city = new City(cities.get(counter), cityImg, 100, 100);
            CityStore.add(city);
        }
    }
    
    public void act() 
    {
        // Add your action code here.
    }   
    
    public void plotCities(int targetCity){
 
        int x = 0;
        int y = 0;
        world = getWorld();
        for(int i = 0; i < CityStore.size(); i++)
        {
            world.addObject(CityStore.get(i), x+300, y+200);
            x = x + 250;
            y = y + 150;
        }
        
    }
    
    public void setCipher(cipher cipherObject, int targetCity){
        String city = cities.get(targetCity);
        System.out.println(city);
        String encryptedCity = cipherObject.encrypt(city);
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
