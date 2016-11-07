import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyPlane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyPlane extends Enemy
{
    /**
     * Act - do whatever the EnemyPlane wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int count = 0;
    public void act() 
    {
        if(state == "moveFree")
        {
            move(-1);
            moveRandom();
            turnAtEdge();
            foundCity();
            foundTank();
        }
        else if(state == "attack")
        {
            attackOn(positionX,positionY);
        }
        
        // if(this.onGoingAttack) {
          //  attack();
        //}
    }    
    
    
     public void turnAtEdge()
    {
        if ( atWorldEdge() )
        {
            turn(17);
        }
    }
    
    public void attackOn(int X, int Y)
    {
             System.out.println(state);  
              moveActor();
              turnTowards(X,Y);
              setLocation(X-220,Y);
              setRotation(0);
              Actor ammunition;
              if(this.count%70==0){
                getWorld().addObject(new Ammunition(this,X,Y), getX(), getY());

        }
        count++;
              System.out.println(state);
    }
    
    public void foundCity()
    {
        if(checkActor(City.class))
        {
              turn(17);
        }
    }
     public void foundTank()
     {
        
         if(checkActor(EnemyPlane.class))
        {
              turn(17);
        }
        
     }
    
}
