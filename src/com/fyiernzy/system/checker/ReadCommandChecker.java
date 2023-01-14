package com.fyiernzy.system.checker;

import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.Configuration;

public class ReadCommandChecker {
	public static boolean checkReadCommand(String command) {
		String[] commands = command.split(RegexConst.SPLIT_REGEX);
		
		if (commands.length < 4) {
			System.out.printf("Invalid command: %s. Correct format: %s read <numToRead> <argument> [arguments...].\n", command, Configuration.getCommandHead());
			return false;
		}
		
		if (!CommandCheckerTool.isInteger(commands[2])) {
			System.out.printf("Not integer: %s\n", commands[2]);
			return false;
		}
		
		for(int i = 3; i < commands.length; i++) {
			if (!commands[i].matches(RegexConst.ARGUMENT_REGEX)) {
				System.out.println("Invalid argument: " + commands[i]);
				return false;
			}
		}
		
		return true;
	}
}
