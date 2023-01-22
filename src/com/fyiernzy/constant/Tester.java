package com.fyiernzy.constant;

import java.util.regex.Matcher;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Tester {
	public static void main(String[] args) {
//		Pattern pattern = Pattern.compile("\\s+(?![0-9]{1})");
//		Matcher matcher = pattern.matcher("fuck your Hello boi 123");
//		
//		System.out.println(Arrays.toString(pattern.split(" fuck your Hello boi 123".trim())));
//		
//		System.out.println((21 - 10) / 2);
//		System.out.println("|" + prettyString("Hello world35", 21) + "|");
//		System.out.println("|" + prettyString("Hello world1", 21) + "|");
//		
//		String line = "[2022-11-14T21:02:31.423] error: This association 242(account='free', user='htt_felicia', partition='(null)') does not have access to qos normal";
//		System.out.println(Arrays.toString(line.split(" |\\(|, ")));
//		
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now().toString()));
//		System.out.println(java.time.LocalDateTime.now());
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
		Pattern pattern = Pattern.compile("\\[([0-9]{4})-([0-9]{2})-([0-9]{2})T.*\\].*user='(.*)', .* qos (.*)");
		String line = 
				"[2022-11-14T20:29:49.293] error: This association 242(account='free', user='htt_felicia', partition='(null)') does not have access to qos normal";
		
		Matcher matcher = pattern.matcher(line);
		for(String sentence : line.split("\r\n")) {
			System.out.println(sentence);
			if (matcher.matches()) {
				System.out.println("Matches");
				for(int i = 1; i <= matcher.groupCount(); i++) {
					System.out.print(matcher.group(i) + ((i == matcher.groupCount()) ? "\n" : ","));
				}
			}
		}
		System.out.println("Hello world");
		
	}
	
	public static String prettyString(String str, int width) {
		int space = (width - str.length()) / 2;
		return " ".repeat(space) + str + " ".repeat(space + (width - str.length()) % 2);
	}
}
