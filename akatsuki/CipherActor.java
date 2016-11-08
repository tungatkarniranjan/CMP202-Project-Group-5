import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CipherActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CipherActor extends Actor implements cipher
{
    /**
     * Act - do whatever the CipherActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public String encrypt(String stringToencrypt){
        return "";
    }
    //Will return a decrypted string for an encrypted string sent in stringTodecrypt
    public String decrypt(String stringTodecrypt){
        return "";
    }
    //Will return an actor of Hint Class specific for that cipher
    public Object getHint(){
        return "";
    }
    //check if the answer submitted by the player is correct
    public boolean checkAnswerValidity(String answer){
        return false;
    }
}
