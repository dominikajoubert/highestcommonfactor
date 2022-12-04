package com.investec.highestcommonfactor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.investec.highestcommonfactor.manager.HighestCommonFactorManager;

@SpringBootTest
class HighestCommonFactorApplicationTests {

	@Autowired
	HighestCommonFactorManager printHighestCommonFactor;
	@MockBean
	private HighestCommonFactorApplication highestCommonFactorApplication;

	@Test
	public void testIfHFCCorrect() {
		String numberString = "12,24,18,6";
		int[] intArrayFromString = printHighestCommonFactor.getIntArrayFromString(numberString);
		assertEquals(6, printHighestCommonFactor.highestCommonFactor(intArrayFromString));
	}
}
