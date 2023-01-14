package com.fyiernzy.search;

import java.io.*;
import java.util.regex.*;
import java.time.LocalDate;

import com.fyiernzy.constant.RegexConst;
import com.fyiernzy.system.Configuration;

public abstract class SearchStream {
	protected StringBuilder content;
	
	SearchStream() {
		this.content = new StringBuilder();
	}
	
	public SearchStream filterArgument(String[] keywordList) {
		StringBuilder tmp;
		StringBuilder filtered = this.content;
		
		for(int i = 0; i < keywordList.length; i++) {
			tmp = new StringBuilder();
			for(String sentence : filtered.toString().split("\n")) {
				if(sentence.contains(keywordList[i]))
					tmp.append(sentence + "\n");
			}
			filtered = tmp;
		}
		
		this.content = filtered;
		return this;
	}
	
	public SearchStream readContent() {
		StringBuilder content = new StringBuilder();
		String line;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(Configuration.getSourceFile()))) {			
			while((line = reader.readLine()) != null) 
				content.append(line + "\n");
			
		} catch (Exception ex) {}
		
		this.content = content;
		return this;
	}
	
	public StringBuilder toResult() {
		return this.content;
	}
}
