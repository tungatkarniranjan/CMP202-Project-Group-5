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
    
	public cipherActorThree() {
		super();
		key = "key";
		keySet = "_abcdefghijklmnopqrstuvwxyz";
	}
	
	@Override
	public String encrypt(String stringToencrypt) {
		city = stringToencrypt.toCharArray();
		char temp[] = new char[city.length];
		int index;
		for(int i =0 ; i<city.length ; i++ ){
			index = keySet.indexOf(city[i]) + keySet.indexOf(key.charAt(i%key.length()));
			temp[i] = keySet.charAt(index>26?index-26:index);
		}
		return String.valueOf(temp);
	}
	
	@Override
	public String decrypt(String stringTodecrypt) {
		int index;
		char temp[] = new char[stringTodecrypt.length()];
		city = stringTodecrypt.toCharArray();
		for(int i =0 ; i<city.length ; i++ ){
			index = keySet.indexOf(city[i]) - keySet.indexOf(key.charAt(i%key.length()));
			temp[i] = keySet.charAt(index<0?index+26:index);
		}
		//System.out.println(temp);
		return String.valueOf(temp);
	}

	@Override
	public Object getHint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkAnswerValidity(String answer) {
		// TODO Auto-generated method stub
		return false;
	}
}
