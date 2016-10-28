import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class FranceMapScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    FranceMapScreen(){
        cities.add("Paris");
        cities.add("Munich");
        cities.add("Frankfurt");
            
        int counter = 0;
        
           for(counter =0; counter < cities.size(); counter++){   
               GreenfootImage cityImg = new GreenfootImage("images/"+cities.get(counter) + ".png");
               City city = new City(cityImg, 100, 100);
               CityStore.add(city);
        }
    
        world = getWorld();
        world.addObject(CityStore.get(0), 100, 100);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
