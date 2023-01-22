package com.fyiernzy.system.checker;

import com.fyiernzy.constant.ConfigConst;
import com.fyiernzy.system.Configuration;

public class ConfigCommandChecker extends CommandChecker {
	ConfigCommandChecker(String[] commands) {
		super(commands);
	}
	
	@Override
	public boolean check() {
		if (this.COMMANDS.length == 3) {
			if (this.COMMANDS[2].equals("default")) {
				return true;
			} else {
				System.out.println("Invalid command: " + this.COMMANDS);
				return false;
			}
		}
		
		if (this.COMMANDS.length != 4) {
			System.out.printf("Invalid command: %s. Correct format: %s config <type> <argument>.\n", this.COMMANDS, Configuration.getCommandHead());
			return false;
		}
		
		if(!ConfigConst.CONFIG_LIST.contains(this.COMMANDS[2])) {
			System.out.printf("Invalid argument: %s. Valid argument lists:\n1. --user.name\n2. --user.email\n3. --system.decor\n4. --system.head\n");
			return false;
		}
		
		if (!this.COMMANDS[3].matches(".*")) {
			System.out.println("Invalid argument: " + this.COMMANDS[3]);
			return false;
		}
		
		return true;
	}
}
