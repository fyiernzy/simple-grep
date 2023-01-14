package com.fyiernzy.search;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fyiernzy.constant.RegexConst;

public class ListStream extends SearchStream {
	@Override
	public ListStream filterArgument(String[] keywordList) {
		return (ListStream) super.filterArgument(keywordList);
	}
	
	@Override
	public ListStream readContent() {
		return (ListStream) super.readContent();
	}
	
	public ListStream filterTime(LocalDate dateStart, LocalDate dateEnd) {
		Pattern pattern = Pattern.compile(RegexConst.DATE_REGEX);
		Matcher matcher; LocalDate date;
		StringBuilder tmp = new StringBuilder();
		
		for(String line : this.content.toString().split("\n")) {
			matcher = pattern.matcher(line);
			
			if(matcher.matches()) {
				date = LocalDate.parse(matcher.group(1), RegexConst.DATE_FORMATTER);
				if (!(date.isBefore(dateStart) || date.isAfter(dateEnd))) {
					tmp.append(line + "\n");
				}
				
				if (date.isAfter(dateEnd))
					break;
			}
		}
		
		this.content = tmp;
		
		return this;
	}
}
