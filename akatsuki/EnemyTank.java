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
    int count = 0;
    public void act() 
    {
<<<<<<< HEAD
        if(state == "moveFree")
        {
            moveActor();
            turnAtEdge();
            foundCity();
            foundTank();
        }
        else if(state == "attack")
        {
            attack(positionX,positionY);
        }
    }
=======
        super.act();
    }    
>>>>>>> my_branch
    
    public void turnRight(){
    
    //turn right     
    };
    
    public void turnLeft(){
    //turn left
    };
    
    public void move(){
        //move forward
    };
    
    public void moveRandom(){
    
    //moverandom
    };
    
    
     public void turnAtEdge()
    {
        if ( atWorldEdge() )
        {
            turn(17);
        }
    }
    
    public void attack(int X, int Y)
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
        
         if(checkActor(EnemyTank.class))
        {
              turn(17);
        }
        
     }
    
    
    
}
