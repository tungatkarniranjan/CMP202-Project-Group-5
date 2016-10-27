import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class RandomUtitility here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomUtitility extends Actor
{
    /**
     * Act - do whatever the RandomUtitility wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    ArrayList <MapScreen>MapScreenStore = new ArrayList<MapScreen>();
   // ArrayList <Cipher>GumballRegister = new ArrayList<Gumball>();
   RandomUtitility()
   {
       MapScreenStore.add(new FranceMapScreen());
       MapScreenStore.add(new GermanyMapScreen());
   }
   
    
    public void act() 
    {
        // Add your action code here.
    } 
    
    //will be changed for difficulty 
    /*public void initializeMapScreenStore()
    {
        for(MapScreen map : getWorld().getObjects(MapScreen.class))
        {
           MapScreenRegister.add(map);
        }
    }*/
    
    public MapScreen getMapScreen()
    {
        Random random = new Random();
        MapScreen randomMapScreen = MapScreenStore.get(random.nextInt(MapScreenStore.size()));
        return randomMapScreen;        
    }
    
    
    
}
