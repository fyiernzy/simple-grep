package com.fyiernzy.system;

import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.checker.CommandCheckerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandCache {
	private StringBuilder command;
	private StringBuilder record;
	LocalDate rangeStart;
	LocalDate rangeEnd;
	
	private static CommandCache commandCache = new CommandCache();
	
	private CommandCache() {
		this.setTimeRange();
	}
	
	public static CommandCache setUpCommandCache() {
		return CommandCache.commandCache;
	}
	
	public boolean setCommand(String inputCommand) {
		if (CommandCheckerFactory.checkCommand(inputCommand, this.rangeStart, this.rangeEnd)) {
			this.command = new StringBuilder(inputCommand);
			return true;
		} else {
			return false;
		}
	}
	
	public void setRecord(StringBuilder record) {
		this.record = record;
		System.out.println((commandCache.getRecord().length() > 0) ? commandCache.getRecord() : "No record found");
	}
	
	public StringBuilder getCommand() {
		return this.command;
	}
	
	public StringBuilder getRecord() {
		return this.record;
	}
	
	public void setTimeRange() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Configuration.getSourceFile()));
			Pattern pattern = Pattern.compile(RegexConst.DATE_REGEX);
			Matcher matcher;
			
			String start = reader.readLine();
			String end; StringBuilder delay = new StringBuilder();
			
			while((end = reader.readLine()) != null) {
				delay = new StringBuilder(end);
			}
			
			reader.close();
			
			matcher = pattern.matcher(start); matcher.matches();
			this.rangeStart = LocalDate.parse(matcher.group(1), RegexConst.DATE_FORMATTER_LENIENT);
			
			matcher = pattern.matcher(delay); matcher.matches();
			this.rangeEnd = LocalDate.parse(matcher.group(1), RegexConst.DATE_FORMATTER_LENIENT);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String getCommandType() {
		return this.command.toString().split(" ")[1];
	}
}
