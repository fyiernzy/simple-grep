package com.fyiernzy.system.checker;

import com.fyiernzy.system.Configuration;

public class LogCommandChecker {
	public static boolean checkLogCommand(String command) {
		String[] tmp = command.split(" ");
		
		if (tmp.length != 3) {
			System.out.printf("Invalid command: %s. Correct format: %s log <number>.\n", command, Configuration.getCommandHead());
			return false;
		}
		
		if(tmp[2].equals("all")) 
			return true;
		
		if(!CommandCheckerTool.isInteger(tmp[2])) {
			System.out.println("Not integer: " + tmp[2]);
			return false;
		}
		
		return true;
	}
}

