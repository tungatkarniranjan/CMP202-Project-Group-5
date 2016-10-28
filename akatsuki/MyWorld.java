import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     */
    
    Screens homeScreen;     
    Screens newGameScreen;
    RandomUtitility randomUtility;
    
    public MyWorld()
    {
        super(1600, 800, 1);
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
        newGameScreen = new NewGameScreen();
        addObject(newGameScreen, 800, 400);
        newGameScreen.addButtons();
    }
    
    public void initializeRandomUitility()
    {
       randomUtility = new RandomUtitility();
      // randomUtility.initializeMapScreenRegister();
    }
    
    public void initializeMapScreen(){
        MapScreen randomMap = randomUtility.getMapScreen();
        addObject(randomMap, 800, 400);
        randomMap.plotCities();
        
    }
    
}
