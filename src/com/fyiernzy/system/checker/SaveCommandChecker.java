package com.fyiernzy.system.checker;

import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.Configuration;


public class SaveCommandChecker extends CommandChecker {
	public SaveCommandChecker(String[] commands) {
		super(commands);
	}
	
	@Override
	public boolean check() {
		if (this.COMMANDS.length != 3) {
			System.out.printf("Invalid command: %s. Correct format: %s save <filename>.\n", this.COMMANDS, Configuration.getCommandHead());
			return false;
		}
			
		boolean isValid = (this.COMMANDS[2].matches(RegexConst.FILE_TYPE.pattern()));
		
		if(!isValid)
			System.out.printf("Invalid file name: %s.\nNo space is allowed.\nThe file name can only be ended with .txt or .csv.\n", this.COMMANDS[2]);
		
		return isValid;
	}
}
