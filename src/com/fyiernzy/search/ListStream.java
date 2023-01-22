package com.fyiernzy.search;

import java.time.LocalDate;
import java.util.regex.Matcher;

import com.fyiernzy.constant.RegexConst;

public class ListStream extends SearchStream {
	public ListStream(String file) {
		super(file);
	}
	
	@Override
	public ListStream filterArgument(String... keywordList) {
		return (ListStream) super.filterArgument(keywordList);
	}
	
	@Override
	public ListStream readContent() {
		return (ListStream) super.readContent();
	}
	
	public ListStream filterTime(LocalDate dateStart, LocalDate dateEnd) {
		Matcher matcher; LocalDate date;
		StringBuilder tmp = new StringBuilder();
		
		for(String line : this.content.toString().split("\n")) {
			matcher = RegexConst.DATE.matcher(line);
			
			if(matcher.matches()) {
				date = LocalDate.parse(matcher.group(1), RegexConst.DATE_FORMATTER);
				if (!(date.isBefore(dateStart) || date.isAfter(dateEnd))) 
					tmp.append(line + "\n");
				
				
				if (date.isAfter(dateEnd))
					break;
			}
		}
		
		this.content = tmp;
		return this;
	}
}
