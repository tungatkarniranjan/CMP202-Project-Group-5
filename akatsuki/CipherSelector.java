/**
 * Write a description of class CipherSelector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class CipherSelector  
{
    private ArrayList<Integer> ciphers = new ArrayList<>();
    private int totalCiphers = 3;
    public CipherSelector()
    {
        int counter = 0;
        for(counter = 0; counter <  totalCiphers; counter++){
            ciphers.add(counter);
        }
    }
    
    public cipher produceCipher(int index)
    {
        int cipherSelector = ciphers.get(index);
        cipher cipherObject;
        if(cipherSelector == 1){
            cipherObject = new CipherActorOne();  
        }else if(cipherSelector == 2){
            cipherObject = new CipherActorTwo();
        }else{
            cipherObject = null;
        }
        return cipherObject;
    }

}
