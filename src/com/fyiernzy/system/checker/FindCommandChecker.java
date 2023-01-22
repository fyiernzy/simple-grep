package com.fyiernzy.system.checker;

import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.*;

public class FindCommandChecker extends CommandChecker {
	
	FindCommandChecker(String[] commands) {
		super(commands);
	}
	
	@Override
	public boolean check() {		
		if (this.COMMANDS.length < 3) {
			System.out.printf("Invalid command: %s. Correct format: %s find <argument>.\n", String.join(" ", this.COMMANDS), Configuration.getCommandHead());
			return false;
		}
		
		for(int i = 2; i < this.COMMANDS.length; i++) {
			if (!this.COMMANDS[i].matches(RegexConst.ARGUMENT.pattern())) {
				System.out.println("Invalid argument: " + this.COMMANDS[i]);
				return false;
			}
		}
		
		return true;
	}
}
