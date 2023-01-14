package com.fyiernzy.perform;

import com.fyiernzy.system.LogBook;

public class LogPerformer {
	private final LogBook LOG_BOOK;
	private final StringBuilder COMMAND;
	
	public LogPerformer(LogBook logbook, StringBuilder command) {
		this.LOG_BOOK = logbook;
		this.COMMAND = command;
	}
	
	public void perform() {
		String keyword = this.COMMAND.toString().split(" ")[2];
		
		if (keyword.equals("all")) {
			LOG_BOOK.showLog();
			return ;
		}
			
		LOG_BOOK.showLog(Integer.parseInt(keyword));
	}
}
