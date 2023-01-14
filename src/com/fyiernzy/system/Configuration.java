package com.fyiernzy.system;

public class Configuration {
	static String commandHead = "fop";
	static String commandDecor = ">>>";
	static String userName = "localHost";;
	static String userEmail = "localHost@root.com";
	static String sourceFile = "./io_files/extracted_log.txt";
	
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

}
