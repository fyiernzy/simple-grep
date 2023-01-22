package com.fyiernzy.system.checker;

public abstract class CommandChecker {
	protected final String[] COMMANDS;
	
	CommandChecker(String[] commands) {
		this.COMMANDS = commands;
	}
	
	abstract boolean check();
}
