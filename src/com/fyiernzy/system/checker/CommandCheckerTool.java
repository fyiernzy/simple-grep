package com.fyiernzy.system.checker;

import com.fyiernzy.constant.RegexConst;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CommandCheckerTool {	
	public static String getCommandType(StringBuilder command) {
		return command.toString().split(" ")[1];
	}
	
	public static boolean checkTimeFormat(String commandTime) {
		try {
			LocalDate.parse(commandTime, RegexConst.DATE_FORMATTER_STRICT);
			return true;
		} catch (DateTimeParseException ex) {
			return false;
		}
	}
	
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
