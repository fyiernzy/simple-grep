package com.fyiernzy.system.checker;

import com.fyiernzy.constant.RegexConst;

public class RegexCommandChecker {
	public static boolean checkRegexCommand(String command) {
		if (command.matches(RegexConst.REGEX_REGEX)) {
			return true;
		}
		
		System.out.printf("Invalid regex command: %s. The regex format is: fop regex <match|extract> <regex>\n", command);
		return false;
	}
}
