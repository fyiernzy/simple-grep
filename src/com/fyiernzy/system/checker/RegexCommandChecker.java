package com.fyiernzy.system.checker;

import com.fyiernzy.constant.RegexConst;

public class RegexCommandChecker extends CommandChecker {
	public RegexCommandChecker(String[] commands) {
		super(commands);
	}
	
	@Override
	public boolean check() {
		final String COMMAND = String.join(" ", this.COMMANDS);
		
		if (COMMAND.matches(RegexConst.REGEX.pattern())) {
			return true;
		}
		
		System.out.printf("Invalid regex command: %s. The regex format is: fop regex <match|extract> <regex>\n", COMMAND);
		return false;
	}
}
