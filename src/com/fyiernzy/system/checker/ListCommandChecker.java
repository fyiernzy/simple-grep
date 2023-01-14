package com.fyiernzy.system.checker;

import java.time.LocalDate;

import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.*;

public class ListCommandChecker {
	public static boolean checkListCommand(String command, LocalDate rangeStart, LocalDate rangeEnd) {
		String[] tmp = command.split(" ");
		
		if (tmp.length < 4) {
			System.out.printf("Invalid command: %s. Correct format: %s list <fromTime> <toTime>\n", command, Configuration.getCommandHead());
			return false;
		}

		for(int i = 2; i < 4; i++) {
			if (!CommandCheckerTool.checkTimeFormat(tmp[i])) {
				System.out.println("Invalid date: " + tmp[i]);
				return false;
			}
		}
		
		if (!checkDateRange(rangeStart, rangeEnd, tmp[2], tmp[3])) 
			return false;
		
				
		for(int i = 4; i < tmp.length; i++) {
			if(!tmp[i].matches(RegexConst.ARGUMENT_REGEX)) {
				System.out.println("Invalid argument: " + tmp[i]);
				return false;
			}
		}
		
		return true;
	
	}
	
	public static boolean checkDateRange(LocalDate rangeStart, LocalDate rangeEnd, String startDate, String endDate) {
		// Get the start and end of the given range
		LocalDate start = LocalDate.parse(startDate, RegexConst.DATE_FORMATTER_LENIENT);
		LocalDate end = LocalDate.parse(endDate, RegexConst.DATE_FORMATTER_LENIENT);
		
		// Check if the start and end date is valid
		if (start.isBefore(rangeStart) || end.isAfter(rangeEnd)) {
			System.out.println("The date given is out of the bound.");
			return false;
		}
		
		return true;
	}
}
