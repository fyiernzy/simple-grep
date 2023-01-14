package com.fyiernzy.system.checker;

import com.fyiernzy.constant.CommandConst;
import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.Configuration;
import java.time.LocalDate;

public class CommandCheckerFactory {
	public static boolean checkCommand(String command, LocalDate rangeStart, LocalDate rangeEnd) {
		String[] commands = command.split(RegexConst.SPLIT_REGEX);
		boolean isValid;
		
		if (!commands[0].equals(Configuration.getCommandHead())) {
			System.out.printf("Invalid command head: %s. Command head: %s\n", commands[0], Configuration.getCommandHead());
			return false;
		}
		
		switch(commands[1]) {
			case CommandConst.FOP_FIND:
				isValid = FindCommandChecker.checkFindCommand(command);
				break;
			case CommandConst.FOP_SAVE: 
				isValid = SaveCommandChecker.checkSaveCommand(command);
				break;
			case CommandConst.FOP_LIST: 
				isValid = ListCommandChecker.checkListCommand(command, rangeStart, rangeEnd);
				break;
			case CommandConst.FOP_REGEX:
				isValid = RegexCommandChecker.checkRegexCommand(command);
				break;
			case CommandConst.FOP_LOG:
				isValid = LogCommandChecker.checkLogCommand(command);
				break;
			case CommandConst.FOP_CONFIG:
				isValid = ConfigCommandChecker.checkConfigCommand(command);
				break;
			case CommandConst.FOP_READ:
				isValid = ReadCommandChecker.checkReadCommand(command);
				break;
			default:
				isValid = false;
				System.out.println("Undefined command: " + commands[1]);
				break;
		}
		
		return isValid;
	}
}
