package com.fyiernzy.system;

import com.fyiernzy.perform.*;
import com.fyiernzy.constant.*;


import java.util.*;

public class CommandLine {
	
	public static void main(String[] args) throws Exception {
		new CommandLine().run();	
	}
	
	public void run() {
		CommandCache commandCache = CommandCache.setUpCommandCache();
		LogBook logBook = LogBook.getLogBook();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.printf("%s ", Configuration.commandDecor);
			
			String command = scanner.nextLine();
			
			if (command.toLowerCase().startsWith("q"))
				break;
			
			if(commandCache.setCommand(command)) {
				logBook.addLog(command);
				switch(commandCache.getCommandType()) {
					case CommandConst.FOP_FIND -> commandCache.setRecord(new FindPerformer(commandCache.getCommand()).perform());
					case CommandConst.FOP_LIST -> commandCache.setRecord(new ListPerformer(commandCache.getCommand()).perform());
					case CommandConst.FOP_REGEX -> commandCache.setRecord(new RegexPerformer(commandCache.getCommand(), commandCache.getRecord()).perform());
					case CommandConst.FOP_SAVE -> SavePerformer.performSave(commandCache.getRecord(), commandCache.getCommand());
					case CommandConst.FOP_LOG -> new LogPerformer(logBook, commandCache.getCommand()).perform();
					case CommandConst.FOP_CONFIG -> ConfigPerformer.perform(commandCache.getCommand());
					case CommandConst.FOP_READ -> commandCache.setRecord(new ReadPerformer(commandCache.getCommand()).perform());
				}
			}
		}
		
		scanner.close();
	}
}
