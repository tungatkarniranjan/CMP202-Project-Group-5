import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class city here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class City extends Actor
{
    /**
     * Act - do whatever the city wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String cityName;
    public void act() 
    {
        // Add your action code here.
    }    
    
    public City(String cityName, GreenfootImage img , int Xposition , int Yposition)
    {
        setLocation(Xposition ,Yposition);
        setImage(img);
        System.out.println(Xposition );
        this.cityName = cityName;
        
    
    }    
    
}
