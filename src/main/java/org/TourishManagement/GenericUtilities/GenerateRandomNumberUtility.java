package org.TourishManagement.GenericUtilities;

import java.util.Random;

/**
 * This Class Is Used To Generate Random Number
 * @author SWARAJ-PC
 *
 */
public class GenerateRandomNumberUtility {

	/**
	 * setRandomNumber Generates a Random Number Within the Specified Range
	 * By Taking The Following Parameter
	 * @param range
	 * @return
	 */
	public int setRandomNumber(int range)
	{
//		Random random=new Random();
//		int RandomNumber = random.nextInt(range);
//		return RandomNumber;
		//or
	return new Random().nextInt(range);
	}
}
