package com.fyiernzy.system.checker;

import java.time.LocalDate;
import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.*;

public class ListCommandChecker extends CommandChecker {
	private LocalDate RANGE_START;
	private LocalDate RANGE_END;
	
	public ListCommandChecker(String[] commands, LocalDate rangeStart, LocalDate rangeEnd) {
		super(commands);
		this.RANGE_START = rangeStart;
		this.RANGE_END = rangeEnd;
	}
	
	@Override
	public boolean check() {
		if (this.COMMANDS.length < 4) {
			System.out.printf("Invalid command: %s. Correct format: %s list <fromTime> <toTime>\n", String.join(" ", this.COMMANDS), Configuration.getCommandHead());
			return false;
		}

		for(int i = 2; i < 4; i++) {
			if (!CommandCheckerTool.checkTimeFormat(this.COMMANDS[i])) {
				System.out.println("Invalid date: " + this.COMMANDS[i]);
				return false;
			}
		}
		
		if (!this.checkDateRange(this.RANGE_START, this.RANGE_END, this.COMMANDS[2], this.COMMANDS[3])) 
			return false;
		
		
		for(int i = 4; i < this.COMMANDS.length; i++) {
			if(!this.COMMANDS[i].matches(RegexConst.ARGUMENT.pattern())) {
				System.out.println("Invalid argument: " + this.COMMANDS[i]);
				return false;
			}
		}
		
		return true;
	
	}
	
	public boolean checkDateRange(LocalDate rangeStart, LocalDate rangeEnd, String startDate, String endDate) {
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
