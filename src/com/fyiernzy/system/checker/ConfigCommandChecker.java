package com.fyiernzy.system.checker;

import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.constant.ConfigConst;
import com.fyiernzy.system.Configuration;

public class ConfigCommandChecker {
	
	public static boolean checkConfigCommand(String command) {
		String[] commands = command.split(" ");
		
		if (commands.length == 3) {
			if (commands[2].equals("default")) {
				return true;
			} else {
				System.out.println("Invalid command: " + command);
				return false;
			}
		}
		
		if (commands.length != 4) {
			System.out.printf("Invalid command: %s. Correct format: %s config <type> <argument>.\n", command, Configuration.getCommandHead());
			return false;
		}
		
		if(!ConfigConst.CONFIG_LIST.contains(commands[2])) {
			System.out.printf("Invalid argument: %s. Valid argument lists:\n1. --user.name\n2. --user.email\n3. --system.decor\n4. --system.head\n");
			return false;
		}
		
		if (!commands[3].matches(".*")) {
			System.out.println("Invalid argument: " + commands[3]);
			return false;
		}
		
		return true;
	}
}
