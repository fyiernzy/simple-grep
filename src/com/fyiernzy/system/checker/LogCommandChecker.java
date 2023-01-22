package com.fyiernzy.system.checker;

import com.fyiernzy.system.Configuration;

public class LogCommandChecker extends CommandChecker {
	
	public LogCommandChecker(String[] commands) {
		super(commands);
	}
	
	@Override
	public boolean check() {
		if (this.COMMANDS.length != 3) {
			System.out.printf("Invalid command: %s. Correct format: %s log <number>.\n", String.join(" ", this.COMMANDS), Configuration.getCommandHead());
			return false;
		}
		
		if(this.COMMANDS[2].equals("all")) 
			return true;
		
		if(!CommandCheckerTool.isInteger(this.COMMANDS[2])) {
			System.out.println("Not integer: " + this.COMMANDS[2]);
			return false;
		}
		
		return true;
	}
}

