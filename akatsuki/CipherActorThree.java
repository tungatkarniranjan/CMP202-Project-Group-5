/**
 * This class will implement the cipher interface: Vigenere Cipher.
 * Version - 1 - Initial Commit
 * Class structure defined
 * Author: Nachiket Joshi
 * WIKI: {{add Description of the class here}}
 */
import java.util.*;
import greenfoot.*;
import java.awt.Color;

public class CipherActorThree extends CipherActor implements cipher {

    char city[];
    String key;
    String keySet;
    
    CipherActorThree(String m) {
       key = m;
       keySet = "_abcdefghijklmnopqrstuvwxyz";
    }

    public char[] getCity() {
        return city;
    }

    public void setCity(char[] city) {
        this.city = city;
    }
    
    public char[] encryptCity() {
        char temp[] = new char[city.length];
        int index;
        for(int i =0 ; i<city.length ; i++ ){

            index = keySet.indexOf(city[i]) + keySet.indexOf(key.charAt(i%key.length    ()));
            temp[i] = keySet.charAt(index>26?index-26:index);
        }
        System.out.println(temp);
        return(temp);
    }
    
    public void decryptCity(char encryptedCity[]) {
        int index;
        char temp[] = new char[encryptedCity.length];
        for(int i =0 ; i<city.length ; i++ ){
            index = keySet.indexOf(encryptedCity[i]) - keySet.indexOf(key.charAt(i%key.length()));
            temp[i] = keySet.charAt(index<0?index+26:index);
        }
        System.out.println(temp);
    }
    
    public Object getHint(){
        return "";
    }
    
    public boolean checkAnswerValidity(String answer){
        return true;
    }

    @Override
    public String encrypt(String stringToencrypt) {
        // TODO Auto-generated method stub
        char temp[] = new char[city.length];
        int index;
        for(int i =0 ; i<city.length ; i++ ){

            index = keySet.indexOf(city[i]) + keySet.indexOf(key.charAt(i%key.length    ()));
            temp[i] = keySet.charAt(index>26?index-26:index);
        }
        System.out.println(temp);
        return new String(temp);
    }

    @Override
    public String decrypt(String stringTodecrypt) {
        // TODO Auto-generated method stub
        return null;
    }
}
