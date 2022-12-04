package com.investec.highestcommonfactor.manager;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HighestCommonFactorManager {

	/**
	 * Method that runs through each element in the int array, and calls the
	 * highestCommonFactorProcessor that in turn returns the highest common factor
	 * given 2 numbers. The process to calculate the highestCommonfactor (HCF) of
	 * multiple numbers is to take the first 2 numbers, get the HCF (x1) of those,
	 * then use that HCF (x1) with the next number in the array to get their HFC
	 * (x2) and so forth. The smallest divisor that goes into all numbers is 1,
	 * which if there is no other factor found will be the HCF.
	 * 
	 * Example: 12,6,24,3. 1) First run through the loop
	 * highestCommonFactorProcessor(12,6) returns 6 2) Second run through loop
	 * highestCommonFactorProcessor(6,24) returns 6 - Using the HCF from first loop
	 * through 3) Third run through loop highestCommonFactorProcessor(6,3) returns 3
	 * - Using the HCF from second loop through
	 * 
	 * @param numbers int array of numbers
	 * @return HCF for the all the numbers
	 */

	
	public int highestCommonFactor(int[] numbers) {
		int result = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			result = highestCommonFactorProcessor(result, numbers[i]);
		}
		return result;
	}
	
	/**
	 * Method that builds the int array from the string of numbers entered by user
	 * 
	 * @param stringOfNumbers string of numbers to be used
	 * @return int[] array of all numbers
	 */

	public int[] getIntArrayFromString(String stringOfNumbers) {
		try {
			String[] stringArrayNumbers = stringOfNumbers.split(",");
			int[] intArray = new int[stringArrayNumbers.length];
			for (int i = 0; i < stringArrayNumbers.length; i++) {
				intArray[i] = Integer.parseInt(stringArrayNumbers[i]);
			}
			return intArray;
		} catch (Exception e) {
			log.error("String of numbers is empty or in wrong format. Correct format e.g.  12,24,18,6");
			throw new RuntimeException("String of numbers is empty or in wrong format. Correct format e.g.  12,24,18,6",
					e);
		}
	}



	/**
	 * Method that returns the highest common factor, that is determined when a mod
	 * of those 2 values return a 0, given 2 numbers.
	 * 
	 * @param num1 one of 2 numbers used to calculate the HCF between them
	 * @param num2 2nd numbers used to calculate the HCF, based on above info.
	 * @return HCF for the 2 numbers
	 */

	private int highestCommonFactorProcessor(int num1, int num2) {

		while (num2 > 0) {
			int tempNum = num2;
			num2 = num1 % num2;
			num1 = tempNum;
		}
		return num1;
	}

}
