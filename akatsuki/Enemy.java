import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor implements enemyinterface
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     
     */
    private static final double WALKING_SPEED = 2.0;
    protected String state ="moveFree";
    protected int positionX;
    protected int positionY;
    public void act() 
    {
        moveActor();
        turnLeft();
        
    }    
    
    public void turnRight(){
        turn(3);
    };
    
    public void turnLeft(){
        turn(-3);
    };
    
    public void moveActor(){
        double angle = Math.toRadians( getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * WALKING_SPEED);
        int y = (int) Math.round(getY() + Math.sin(angle) * WALKING_SPEED);
        setLocation(x, y);
    };
    
    public void moveRandom(){
        
        if ( Greenfoot.getRandomNumber(100) < 10 )
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
    };
    
    public void attack(int X, int Y){
        positionX = X;
        positionY = Y;
        state ="attack";
        
    };

    public boolean checkActor(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
    
    
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
    
    
    
    
}
