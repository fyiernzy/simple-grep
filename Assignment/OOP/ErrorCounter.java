package Assignment.OOP;

import java.util.Arrays;

public class ErrorCounter extends Counter {
	ErrorCounter(String source) {
		super(source);
	}
	
	@Override
	public int countIfContainsAll(String... keywords) {
		String[] keywordList = this.getUniqueKeywords(keywords, "error");
		return this.countIfContainsAll(keywordList, line -> Arrays.stream(keywordList).allMatch(line::contains));
	}
	
	public int countIfContain(String keyword) {
		return this.countIfContainsAll(keyword);
	}
	
	public int countUser(String user) {
		String[] keywordList = this.getUniqueKeywords("error", String.format("user='%s'", user));
		return this.countIfContainsAll(keywordList);
	}
	
	public int countQOS(String qos) {
		String[] keywordList = this.getUniqueKeywords("error", String.format("qos %s", qos));
		return this.countIfContainsAll(keywordList);
	}
	
}
