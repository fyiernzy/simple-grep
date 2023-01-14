package com.fyiernzy.system.checker;

import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.*;

public class FindCommandChecker {
	public static boolean checkFindCommand(String command) {
		String[] commands = command.split(RegexConst.SPLIT_REGEX);
		
		if (commands.length < 3) {
			System.out.printf("Invalid command: %s. Correct format: %s find <argument>.\n", command, Configuration.getCommandHead());
			return false;
		}
		
		for(int i = 2; i < commands.length; i++) {
			if (!commands[i].matches(RegexConst.ARGUMENT_REGEX)) {
				System.out.println("Invalid argument: " + commands[i]);
				return false;
			}
		}
		
		return true;
	}
}
