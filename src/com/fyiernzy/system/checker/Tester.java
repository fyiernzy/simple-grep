package com.fyiernzy.system.checker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;


public class Tester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("Enter a date: ");
			String date = scanner.nextLine();
			if (isValidDate(date)) {
				System.out.println("Is valid date time format");
			}
		}
		
	}
	
	public static boolean isValidDate(String inputDateTime) {
		try {
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd").withResolverStyle(ResolverStyle.STRICT);
			LocalDateTime.parse(inputDateTime, df);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
