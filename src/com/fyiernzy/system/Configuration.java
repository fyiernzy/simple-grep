package com.fyiernzy.system;

public class Configuration {
	private static final String DEFAULT_DECOR = ">>>";
	private static final String DEFAULT_HEAD = "fop";
	private static final String DEFAULT_NAME = "localHost";;
	private static final String DEFAULT_EMAIL = "localHost@root.com";
	private static final String DEFAULT_FILE = "../WIX1002/src/com/fyiernzy/Assignment/Extracted_File/extracted_log.txt";
	
	static String commandHead = DEFAULT_HEAD;
	static String commandDecor = DEFAULT_DECOR;
	static String userName = DEFAULT_NAME;;
	static String userEmail = DEFAULT_EMAIL;
	static String sourceFile = DEFAULT_FILE;
	
	public static void setName(String name) {
		Configuration.userName = name;
	}
	
	public static void setEmail(String email) {
		Configuration.userEmail = email;
	}
	
	public static void setCommandHead(String head) {
		Configuration.commandHead = head;
	}
	
	public static void setCommandDecor(String decor) {
		Configuration.commandDecor = decor;
	}
	
	public static void setSourceFile(String path) {
		Configuration.sourceFile = path;
	}
	
	public static String getName() {
		return Configuration.userName;
	}
	
	public static String getEmail() {
		return Configuration.userEmail;
	}
	
	public static String getCommandHead() { 
		return Configuration.commandHead;
	}
	
	public static String getCommandDecor() {
		return Configuration.commandDecor;
	}
	
	public static String getSourceFile() {
		return Configuration.sourceFile;
	}
	
	public static void setDefault() {
		Configuration.userName = DEFAULT_NAME;
		Configuration.userEmail = DEFAULT_EMAIL;
		Configuration.commandHead = DEFAULT_HEAD;
		Configuration.commandDecor = DEFAULT_DECOR;
		Configuration.sourceFile = DEFAULT_FILE;
	}

}
