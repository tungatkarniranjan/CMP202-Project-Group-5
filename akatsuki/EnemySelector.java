import java.util.ArrayList;
/**
 * Write a description of class EnemySelector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemySelector  
{
    
    private ArrayList<String> enemies= new ArrayList<>();
        
    EnemySelector(){
        enemies.add("Tank");
        enemies.add("Plane");
        enemies.add("Soldier");
    }
    
    public Enemy produceEnemies(int enemyId){
        System.out.println("Producing the enemy");
        String enemyName = enemies.get(enemyId);
        Enemy enemy;
        if(enemyName == "Tank"){
            enemy = new EnemyTank();
        }else if(enemyName == "Plane"){
            enemy = new EnemyPlane();
        }else if(enemyName == "Soldier"){
            enemy = new EnemySoldier();
        }else{
            enemy = null;
        }
        return enemy;
        
    }
    
}
