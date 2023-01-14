package com.fyiernzy.system.checker;

import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.Configuration;


public class SaveCommandChecker {
	public static boolean checkSaveCommand(String command) {
		
		String[] commands = command.split(" ");
		
		if (commands.length != 3) {
			System.out.printf("Invalid command: %s. Correct format: %s save <filename>.\n", command, Configuration.getCommandHead());
			return false;
		}
			
		boolean isValid = (commands[2].matches(RegexConst.FILE_TYPE_REGEX));
		
		if(!isValid)
			System.out.printf("Invalid file name: %s.\nNo space is allowed.\nThe file name can only be ended with .txt or .csv.\n", commands[2]);
		
		return isValid;
	}
}
