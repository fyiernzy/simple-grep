package com.fyiernzy.simplegrep.constant;


import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.regex.Pattern;

public class RegexConstant {
    /**
     * An argument can contain any alphanumeric character, underscore, hyphen, equal sign, or whitespace.
     */
    public static final Pattern ARGUMENT = Pattern.compile("([a-zA-Z0-9_-]|=|\\s)*");
    public static final Pattern SPLIT = Pattern.compile("\\s+");
    public static final Pattern TIME = Pattern.compile("T([0-9]{4}-[0-9]{2}-[0-9]{2})");
    public static final Pattern DATE = Pattern.compile("\\[([0-9]{4}-[0-9]{2}-[0-9]{2})T.*");
    public static final Pattern REGEX = Pattern.compile("fop regex (match|extract) (.*)");
    public static final Pattern FILE_TYPE = Pattern.compile("[a-zA-Z0-9_-]*(\\.txt|\\.csv)");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd");
    public static final DateTimeFormatter DATE_FORMATTER_STRICT = DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);
    public static final DateTimeFormatter DATE_FORMATTER_LENIENT = DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.LENIENT);
}
