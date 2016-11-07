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
    World world;
    
    EnemyTank enemyTank;
    
    FranceMapScreen(){
        world = getWorld();
        cities.add("Paris");
        cities.add("Munich");
        cities.add("Frankfurt");
            
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
    
    public void plotCities(){
 
        int x = 0;
        int y = 0;
        world = getWorld();
        enemyTank = new EnemyTank();
        for(int i = 0; i < CityStore.size(); i++)
        {
            world.addObject(CityStore.get(i), x+100, y+100);
            x = x + 250;
            y = y + 150;
        }
        
        world.addObject(enemyTank, 800, 400);
       
        //City city1 = new City("Paris",null, 100, 100 );
        //World world1 = getWorld();
        //world1.addObject(city1,300, 300);
    }
    
}
