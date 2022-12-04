package com.investec.highestcommonfactor;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.investec.highestcommonfactor.manager.HighestCommonFactorManager;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j

public class HighestCommonFactorApplication implements CommandLineRunner {

	@Autowired
	private HighestCommonFactorManager highestCommonFactorManager;

	public static void main(String[] args) {
		SpringApplication.run(HighestCommonFactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the numbers seperated by you commas e.g. 6,12,4,29: ");
		String stringOfNumbers = sc.nextLine();
		sc.close();
		int[] numbers = highestCommonFactorManager.getIntArrayFromString(stringOfNumbers);
		int highestCommonFactor = highestCommonFactorManager.highestCommonFactor(numbers);
		log.info("Numbers entered: " + stringOfNumbers);
		log.info("HighestCommonFactor is :" + highestCommonFactor);
	}
}
