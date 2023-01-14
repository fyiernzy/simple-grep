package com.fyiernzy.search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexStream extends SearchStream {
	@Override
	public RegexStream filterArgument(String[] keywordList) {
		return (RegexStream) super.filterArgument(keywordList);
	}
	
	@Override
	public RegexStream readContent() {
		return (RegexStream) super.readContent();
	}
	
	public RegexStream filterRegex(String regex) {
		StringBuilder tmp = new StringBuilder();
		for(String sentence : this.content.toString().split("\n")) {
			if (sentence.matches(regex))
				tmp.append(sentence + "\n");
		}
		
		System.out.println((tmp.length() > 0) ? tmp : "No record found");
		this.content = tmp;
		return this;
	}
	
	public RegexStream extractRegex(String regex, StringBuilder record) {
		if (record == null || record.length() == 0) {
			System.out.println("The previous record is null");
			return this;
		}
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		StringBuilder sb = new StringBuilder();
		
		for(String sentence : record.toString().split("\n")) {
			matcher = pattern.matcher(sentence);
			if (matcher.matches()) {
				for(int i = 1; i <= matcher.groupCount(); i++) {
					sb.append(matcher.group(i) + (i == matcher.groupCount() - 1 ? "\n" : ","));
				}
			}
		}
		
		System.out.println((sb.length() > 0) ? sb : "Nothing can be extracted.");
		return this;
	}
}
