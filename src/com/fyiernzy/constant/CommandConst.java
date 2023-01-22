package com.fyiernzy.constant;

import java.util.*;

public class CommandConst {
	// count // within a period of time // save
	// time invalid bug
	
	public static final String FOP_FIND = "find"; // Done
	public static final String FOP_SAVE = "save"; // Done
	public static final String FOP_LIST = "list"; // Done
	public static final String FOP_REGEX = "regex"; // Done
	public static final String FOP_LOG = "log"; // Done
	public static final String FOP_CONFIG = "config"; // Done
	public static final String FOP_READ = "read"; // Done
	public static final String FOP_ANALYZE = "analyze"; // simple data analysis
	
	public static final List<String> FOP_LS = Arrays.asList(new String[] {FOP_FIND, FOP_SAVE, FOP_LIST, FOP_REGEX, FOP_LOG, FOP_CONFIG, FOP_READ, FOP_ANALYZE});
	
}
