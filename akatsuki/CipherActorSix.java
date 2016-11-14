import java.util.Scanner;

public class CipherActorSix extends CipherActor implements cipher
{
    // instance variables - replace the example below with your own
    private int x;
    String givenString;
    int secretKey;
    /**
     * Constructor for objects of class CipherSix
     */
    int setKey = 4, g = 5, p = 23;
    String encryptedString;
    
    public CipherActorSix()
    {
        //implement logic
//        if(){
  //          
    //    }
        keyExchange();
    }
    
    public void keyExchange(){
        //accept a secret integer from user
       System.out.println("Choose a short number as your secret integer");
       Scanner scanner = new Scanner(System.in);
       int userKey = scanner.nextInt();
              
       //obtain first calculation of the method
       double [] answerArray =  new double[2];
       answerArray = executeFirst(userKey, setKey);
       System.out.println("Your answer for the first calculation is"+answerArray[0]);       
       
       //obtain second calculation of the method which means both parties have a secret key
       System.out.println("Now you share your answer with your alliance to get the final shared key");
       double firstAnswer = scanner.nextDouble();
       double [] secondAnswer = executeSecond(answerArray[0], answerArray[1], userKey);
       this.secretKey = (int)(secondAnswer[0] + 0.5d);
       System.out.println("Congrats now you have successfully shared a common secret key. Your secret key is "+this.secretKey);
    }
    
    //encrypt the string provided in stringToencrypt
    public String encrypt(String stringToencrypt) {
        this.givenString = stringToencrypt;
        String givenStringLowerCase = givenString.toLowerCase();
        for(int i=0; i<givenStringLowerCase.length(); i++) {
            char ch = givenStringLowerCase.charAt(i);
            int pos = ch - 'a' + 1;
            encryptedString += pos;
        }
        encryptedString += this.secretKey;
        return encryptedString;
    }
    //Will return a decrypted string for an encrypted string sent in stringTodecrypt
    public String decrypt(String stringTodecrypt) {
       //String toEncrypt 
       return this.givenString;
    }
    //Will return an actor of Hint Class specific for that cipher
    public Object getHint() {
        return "";
    }
    //check if the answer submitted by the player is correct
    public boolean checkAnswerValidity(String answer) {
        if(this.givenString == encryptedString)
            return false;
        return true;    
    }
    
    public double[] executeFirst(int userKey, int setKey) {
        double userAnswer = (Math.pow(g, userKey)) % 23;
        double csAnswer = (Math.pow(g, setKey)) % 23;
        double [] returnArray = new double[2];
        return returnArray;
    }
    
    public double[] executeSecond(double userAnswer, double csAnswer, int userKey) {
        double userSecondAnswer = (Math.pow(csAnswer, userKey)) % 23;
        double csSecondAnswer = (Math.pow(userAnswer, setKey)) % 23;
        double [] returnArray = {userSecondAnswer, csSecondAnswer};
        return returnArray;
    }
    
    public String giveHint(int hintNumber){
        if(hintNumber == 1){
            return "This is hint one";
        }else if(hintNumber == 2){
            return "This is hint two";
        }else if(hintNumber == 3){
            return "This is hint three";
        }
    }
}
