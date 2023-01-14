package com.fyiernzy.constant;

import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class RegexConst {
	public static final String ARGUMENT_REGEX = "([a-zA-Z0-9_-]|=|\\s)*";
	public static final String SPLIT_REGEX = "\\s+";
	public static final String SPLIT_REGEX_ENABLED = "\\s+(?=[A-Za-z])]";
	public static final String TIME_REGEX = "T([0-9]{4}-[0-9]{2}-[0-9]{2})";
	public static final String DATE_REGEX = "\\[([0-9]{4}-[0-9]{2}-[0-9]{2})T.*";
	public static final String REGEX_REGEX = "fop regex (match|extract) (.*)";
	public static final String FILE_TYPE_REGEX = "[a-zA-Z0-9_-]*(\\.txt|\\.csv)";
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd");
	public static final DateTimeFormatter DATE_FORMATTER_STRICT = DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.LENIENT);
	public static final DateTimeFormatter DATE_FORMATTER_LENIENT = DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.LENIENT);
	
}
