package edu.sjsu.utility;

import java.util.*;

public class RandomUtility {

	public int getRandomNumber(int range) {
		Random random = new Random();
		int randomNumber = random.nextInt(range);
		
		return randomNumber;
	}
}
