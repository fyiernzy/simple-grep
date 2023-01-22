package com.fyiernzy.search;

import java.nio.file.*;
import java.util.Arrays;
import java.util.stream.Stream;

public abstract class SearchStream {
	protected final String SOURCE;
	protected StringBuilder content;
	
	SearchStream(String file) {
		this.SOURCE = file;
		this.content = new StringBuilder();
	}
	
	public SearchStream filterArgument(String... keywordList) {
		if (this.content.length() <= 0) {
			System.out.println("No content to be filtered");
			return this;
		}
		
		Stream<String> lines = Arrays.stream(this.content.toString().split("\n"));
		
		this.content.setLength(0);
		
		lines.filter(line -> Arrays.stream(keywordList).allMatch(line::contains))
			 .forEach(line -> this.content.append(line).append("\n"));

	
		return this;
	}
	
	public SearchStream readContent() {
		try (Stream<String> lines = Files.lines(Paths.get(this.SOURCE))) {		
			lines.forEach(line -> this.content.append(line).append("\n"));
			
		} catch (Exception ex) {}

		return this;
	}
	
	public StringBuilder toResult() {
		return this.content;
	}
}
