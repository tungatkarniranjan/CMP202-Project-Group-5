/**
 * Write a description of class AttackStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackStrategy  implements EnemyStrategy
{
    private int positionX;
    private int positionY;
    public AttackStrategy(int X, int Y)
    {
        positionX=X;
        positionY=Y;
    }
    public void move(Enemy enemy)
    {
      enemy.attackOn(positionX,positionY);
    }
}
