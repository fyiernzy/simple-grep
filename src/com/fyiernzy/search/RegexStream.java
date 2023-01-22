package com.fyiernzy.search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexStream extends SearchStream {
	private final Pattern PATTERN;
	
	public RegexStream(String file, String regex) {
		super(file);
		this.PATTERN = Pattern.compile(regex);
	}
	
	@Override
	public RegexStream filterArgument(String... keywordList) {
		return (RegexStream) super.filterArgument(keywordList);
	}
	
	@Override
	public RegexStream readContent() {
		return (RegexStream) super.readContent();
	}
	
	public RegexStream filterRegex() {
		String[] lines = this.content.toString().split("\n");
		this.content.setLength(0);
		
		for(String line : lines) {
			if (Pattern.matches(this.PATTERN.pattern(), line))
				this.content.append(line).append("\n");
		}
		
		return this;
	}
	
	public RegexStream extractRegex(StringBuilder record) {
		if (record == null || record.length() == 0) {
			System.out.println("The previous record is null");
			return this;
		}
		
		Matcher matcher;
		
		String[] lines = record.toString().split("\n");
		this.content.setLength(0);
		
		for(String line : lines) {
			matcher = this.PATTERN.matcher(line);
			if (matcher.matches()) {
				for(int i = 1; i <= matcher.groupCount(); i++) {
					this.content.append(matcher.group(i)).append((i == matcher.groupCount() ? "\n" : ","));
				}
			}
		}
		
		System.out.println((this.content.length() > 0) ? this.content : "Nothing can be extracted.");
		
		return this;
	}
}
