package com.fyiernzy.system.checker;

import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.Configuration;

public class ReadCommandChecker extends CommandChecker {
	public ReadCommandChecker(String[] commands){
		super(commands);
	}
	
	@Override
	public boolean check() {		
		if (this.COMMANDS.length < 4) {
			System.out.printf("Invalid command: %s. Correct format: %s read <numToRead> <argument> [arguments...].\n", String.join(" ", this.COMMANDS), Configuration.getCommandHead());
			return false;
		}
		
		if (!CommandCheckerTool.isInteger(this.COMMANDS[2])) {
			System.out.printf("Not integer: %s\n", this.COMMANDS[2]);
			return false;
		}
		
		for(int i = 3; i < this.COMMANDS.length; i++) {
			if (!this.COMMANDS[i].matches(RegexConst.ARGUMENT.pattern())) {
				System.out.println("Invalid argument: " + this.COMMANDS[i]);
				return false;
			}
		}
		
		return true;
	}
}
