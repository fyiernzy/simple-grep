package com.fyiernzy.system;

import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.checker.CommandCheckerFactory;

import java.io.*;
import java.time.*;
import java.util.regex.*;

public class CommandCache {
	private final String SOURCE;
	private StringBuilder command;
	private StringBuilder record;
	LocalDate rangeStart, rangeEnd;
	
	private static CommandCache commandCache;
	
	private CommandCache(String file) {
		this.SOURCE = file;
		this.setTimeRange();
	}
	
	public StringBuilder getCommand() {
		return this.command;
	}
	
	public StringBuilder getRecord() {
		return this.record;
	}
	
	public static CommandCache setUpCommandCache(String file) {
		if (!new File(file).exists()) {
			System.out.println("The file is not existed. Please check your configuration source.");
			return null;
		}
		
		if(commandCache == null)
			commandCache = new CommandCache(file);
		
		return CommandCache.commandCache;
	}
	
	public boolean setCommand(String inputCommand) {
		if (CommandCheckerFactory.checkCommand(inputCommand, this.rangeStart, this.rangeEnd)) {
			this.command = new StringBuilder(inputCommand);
			return true;
		} 
		
		return false;
	}
	
	public void setRecord(StringBuilder record) {
		this.record = record;
		System.out.println((commandCache.getRecord().length() > 0) ? commandCache.getRecord() : "No record found");
	}
	
	public String getCommandType() {
		return this.command.toString().split(" ")[1];
	}

	public void setTimeRange() {
		try (BufferedReader reader = new BufferedReader(new FileReader(this.SOURCE))) {
			Matcher matcher;
			
			String start = reader.readLine();
			String end; StringBuilder delay = new StringBuilder();
			
			while((end = reader.readLine()) != null) {
				delay = new StringBuilder(end);
			}
			
			matcher = RegexConst.DATE.matcher(start); matcher.matches();
			this.rangeStart = LocalDate.parse(matcher.group(1), RegexConst.DATE_FORMATTER_LENIENT);
			
			matcher = RegexConst.DATE.matcher(delay); matcher.matches();
			this.rangeEnd = LocalDate.parse(matcher.group(1), RegexConst.DATE_FORMATTER_LENIENT);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}
