import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static GreenfootImage[] images;
    
    // How many images should be used in the animation of the explostion
    private final static int IMAGE_COUNT= 6;
    
    // Current size of the explosion
    private int imageNo = 0;
    
    // How much do we increment the index in the explosion animation.
    private int increment = 1;
    
    public Explosion(){
        initialiseImages();
        setImage(images[0]);
        Greenfoot.playSound("Explosion.wav");
    }
    
    public void act() 
    {
        // Add your action code here.
        if(imageNo > 0)
        {
            setImage(images[imageNo]);
        }
 
        imageNo += increment;
        if(imageNo >= IMAGE_COUNT)
        {
            increment = -increment;
            imageNo += increment;
        }
        
        if(imageNo <= 0)
        {
            setImage(new GreenfootImage(1,1));
        }
        if(imageNo <= -30)
        {
 
        }
    }    
    
    public synchronized static void initialiseImages()
    {
        if(images == null)
        {
            GreenfootImage baseImage = new GreenfootImage("explosion.png");
            baseImage.scale(baseImage.getWidth()-300, baseImage.getHeight()-300);
            int maxSize = baseImage.getWidth()/2;
            int delta = maxSize / (IMAGE_COUNT+1);
            int size = 0;
            images = new GreenfootImage[IMAGE_COUNT];
            for(int i=0; i < IMAGE_COUNT; i++)
            {
                size = size + delta;
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }
    
    public String toString()
    {
        return "Explosion";
    }
}
