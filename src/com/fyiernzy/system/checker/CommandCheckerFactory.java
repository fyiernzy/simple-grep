package com.fyiernzy.system.checker;

import com.fyiernzy.constant.CommandConst;
import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.Configuration;
import java.time.LocalDate;

public class CommandCheckerFactory {
	public static boolean checkCommand(String command, LocalDate rangeStart, LocalDate rangeEnd) {
		String[] commands = RegexConst.SPLIT.split(command);
		
		if (!commands[0].equals(Configuration.getCommandHead())) {
			System.out.printf("Invalid command head: %s. Command head: %s\n", commands[0], Configuration.getCommandHead());
			return false;
		}
		
		if (!CommandConst.FOP_LS.contains(commands[1])) {
			System.out.println("Undefined command: " + commands[1]);
			return false;
		}
		
		return switch(commands[1]) {
			case CommandConst.FOP_FIND -> new FindCommandChecker(commands).check();
			case CommandConst.FOP_SAVE -> new SaveCommandChecker(commands).check();
			case CommandConst.FOP_LIST ->  new ListCommandChecker(commands, rangeStart, rangeEnd).check();
			case CommandConst.FOP_REGEX -> new RegexCommandChecker(commands).check();
			case CommandConst.FOP_LOG -> new LogCommandChecker(commands).check();
			case CommandConst.FOP_CONFIG -> new ConfigCommandChecker(commands).check();
			case CommandConst.FOP_READ -> new ReadCommandChecker(commands).check();
			default -> false;
		};
	}
}
