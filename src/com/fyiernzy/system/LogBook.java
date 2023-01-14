package com.fyiernzy.system;

import java.text.SimpleDateFormat;
import java.util.*;

public class LogBook {
	// Record the command log
	LinkedList<String> logFile = new LinkedList<String>();
	private static LogBook LOG_BOOK = new LogBook();
	
	public static LogBook getLogBook() {
		return LOG_BOOK;
	}
	
	public void addLog(String command) {
		this.logFile.addFirst(String.format("[%s] --> [%s/%s] --> %s", 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()), Configuration.getName(), Configuration.getEmail(), command));
	}
	
	public void showLog(int index) {
		int n = (index > logFile.size()) ? logFile.size() : index;
		
		for(int i = 0; i < n; i++) {
			System.out.printf("%4d. %s\n", i + 1, logFile.get(i));
		}
	}
	
	public void showLog() {
		for(int i = 0; i < logFile.size(); i++) {
			System.out.printf("%4d. %s\n", i + 1, logFile.get(i));
		}
	}
	
}
