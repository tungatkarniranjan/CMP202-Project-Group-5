/**
 * Write a description of class MoveFreeStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoveFreeStrategy implements EnemyStrategy
{
    public void move(Enemy enemy)
    {
      enemy.moveFree();
    }
}
