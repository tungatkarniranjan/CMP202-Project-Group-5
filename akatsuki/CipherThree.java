public class cipherThree implements cipher{

	char city[];
    String key;
    String keySet;
	
    cipherThree(String m) {
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

			index = keySet.indexOf(city[i]) + keySet.indexOf(key.charAt(i%key.length()));
			temp[i] = keySet.charAt(index>26?index-26:index);
		}
		System.out.println(temp);
		return temp;
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
		return null;
	}

	@Override
	public String decrypt(String stringTodecrypt) {
		// TODO Auto-generated method stub
		return null;
	}
}
