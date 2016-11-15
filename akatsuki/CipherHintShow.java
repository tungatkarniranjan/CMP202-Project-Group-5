import greenfoot.*;
import java.awt.Font;
/**
 * Write a description of class CipherHintShow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CipherHintShow  extends Actor
{
    GreenfootImage img;
    public CipherHintShow()
    {
        GreenfootImage img = new GreenfootImage (300, 100);  
    }

    // This method displays the encrypted string of city.
    public void showCipherText(String cipherText, World world){

        img.setColor(java.awt.Color.black);
        img.setFont(new Font("Times New Roman", Font.BOLD, 40));
        img.drawString(cipherText, 50, 50);
        setImage(img); 
        world.addObject(this, 1400, 50);
    }
    
  }
