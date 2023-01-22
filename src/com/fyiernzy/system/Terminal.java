package com.fyiernzy.system;

import com.fyiernzy.perform.*;
import com.fyiernzy.constant.*;


import java.util.*;

public class Terminal {
	private static final String SOURCE = Configuration.getSourceFile();
	private static final CommandCache commandCache = CommandCache.setUpCommandCache(SOURCE);
	private static final LogBook logBook = LogBook.getLogBook();
	
	private static Terminal terminal;
	
	private Terminal() {
		
	}
	
	public static Terminal getTerminal() {
		if (terminal == null)
			terminal = new Terminal();
		
		return terminal;
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.printf("%s ", Configuration.commandDecor);
			
			String inputCommand = scanner.nextLine();
			
			if (inputCommand.toLowerCase().startsWith("q"))
				break;
			
			if(commandCache.setCommand(inputCommand)) {
				
				logBook.addLog(inputCommand);
				StringBuilder command = commandCache.getCommand();
				String commandType = commandCache.getCommandType();
				
				switch(commandType) {
					case CommandConst.FOP_FIND -> commandCache.setRecord(new FindPerformer(SOURCE, command).perform());
					case CommandConst.FOP_LIST -> commandCache.setRecord(new ListPerformer(SOURCE, command).perform());
					case CommandConst.FOP_REGEX -> commandCache.setRecord(new RegexPerformer(SOURCE, command, commandCache.getRecord()).perform());
					case CommandConst.FOP_READ -> commandCache.setRecord(new ReadPerformer(SOURCE, command).perform());
					case CommandConst.FOP_LOG -> new LogPerformer(logBook, commandCache.getCommand()).perform();
					case CommandConst.FOP_SAVE -> SavePerformer.performSave(commandCache.getRecord(), commandCache.getCommand());
					case CommandConst.FOP_CONFIG -> ConfigPerformer.perform(commandCache.getCommand());
					
				}
			}
		}
		
		scanner.close();
	}
}
