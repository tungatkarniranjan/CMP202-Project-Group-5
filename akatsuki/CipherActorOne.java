import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CipherActorOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CipherActorOne extends CipherActor
{
    /**
     * Act - do whatever the CipherActorOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    String originalString;

	// encrypt the string provided in stringToencrypt
	public String encrypt(String stringToencrypt) {
		this.originalString = stringToencrypt;
		String reverse = new StringBuilder(stringToencrypt).reverse().toString();
		StringBuilder toggled = new StringBuilder(reverse.length());
		StringBuilder encrypted = new StringBuilder(reverse.length());
		boolean alternate = false;

		for (char letter : reverse.toCharArray()) {
			if (Character.isUpperCase(letter)) {
				letter = Character.toLowerCase(letter);
			} else if (Character.isLowerCase(letter)) {
				letter = Character.toUpperCase(letter);
			}
			toggled.append(letter);
		}

		for (char enLetter : toggled.toString().toCharArray()) {
			if (!alternate) {
				enLetter = ++enLetter;
				encrypted.append(enLetter);
				alternate = true;
			} else {
				enLetter = --enLetter;
				encrypted.append(enLetter);
				alternate = false;
			}
		}
		return encrypted.toString();
	}

	// Will return a decrypted string for an encrypted string sent in
	// stringTodecrypt
	public String decrypt(String stringTodecrypt) {
		return this.originalString;
	}

	// Will return an actor of Hint Class specific for that cipher
	public Object getHint() {
		GreenfootImage cityImg = new GreenfootImage("./images/hint1.png");
		return cityImg;
	}

	// check if the answer submitted by the player is correct
	public boolean checkAnswerValidity(String answer) {
		if (answer.equals(this.originalString)) {
			return true;
		}
		return false;
	}
}
