/*
 * Cipher interface
 * 
 * @author (Niranjan Tungatkar) 
 * @version-1 (02-10-2016)
 */
public interface cipher  
{
    //encrypt the string provided in stringToencrypt
    public String encrypt(String stringToencrypt);
    //Will return a decrypted string for an encrypted string sent in stringTodecrypt
    public String decrypt(String stringTodecrypt);
    //Will return an actor of Hint Class specific for that cipher
    public Object getHint();
    //check if the answer submitted by the player is correct
    public boolean checkAnswerValidity(String answer);
}
