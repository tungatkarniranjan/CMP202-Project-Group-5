import greenfoot.*;
import java.awt.Font;
import java.awt.Color;
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
        
        String text = "CODE : " + cipherText;
        GreenfootImage textImage = new GreenfootImage(text, 30, Color.black, new Color(0, 0, 0, 0));
        GreenfootImage image = new GreenfootImage(textImage.getWidth()+20, textImage.getHeight()+10);
        image.drawRect(0, 0, image.getWidth()-1, image.getHeight()-1);
        image.drawImage(textImage, (image.getWidth()-textImage.getWidth())/2, (image.getHeight()-textImage.getHeight())/2);
        setImage(image);
       
        
        world.addObject(this, 450, 50); 

    }
    
    //public void showCipherHint(GreenfootImage hint, World world){
    //    System.out.println("Showing hint here");
    //    world.addObject(hint, 500, 80);
    //}
    
    
  }
