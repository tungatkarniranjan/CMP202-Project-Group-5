import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
 */
public class Ammunition extends Actor
{
    private Enemy enemy;
    private int attackXpos ;
    private int attackYpos ;
    
    /**
     * Act - do whatever the Ammunition wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Ammunition(Enemy enemy ,int attackXpos,int attackYpos) {
        this.enemy = enemy;
        this.attackXpos =attackXpos;
        this.attackYpos=attackYpos;
    }
    
    public void act()
    {
        Actor city = getOneIntersectingObject(City.class);
        if(city != null) {
            getWorld().removeObject(this);
        }else{
           // Actor cityPos = (Actor)(getWorld().getObjects(City.class).get(0));  
            turnTowards(attackXpos,attackYpos);
            move(4);
        }
    }
}