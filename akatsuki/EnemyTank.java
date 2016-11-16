import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyTank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyTank extends Enemy
{
    /**
     * Act - do whatever the EnemyTank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    


    private EnemyStrategy strategy;
    public void act() 
    {
        if(state == "moveFree")
        {
            changeStrategy(new MoveFreeStrategy());
             strategy.move(this);
        }
        else if(state == "attack")
        {
            changeStrategy(new AttackStrategy(positionX,positionY));
            strategy.move(this);
        }        
    }    
        
    public void changeStrategy(EnemyStrategy s)
    {
       strategy = s;
    }
    
    
    
   
    
}
