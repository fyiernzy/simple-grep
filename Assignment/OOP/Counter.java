package Assignment.OOP;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;

public class Counter extends AbstractCounter {
	
	public Counter(String source) {
		super(source);
	}
	
	public String[] getUniqueKeywords(String... keywords) {
		return Arrays.stream(keywords).collect(Collectors.toSet()).stream().toArray(String[]::new);
	}
	
	public String[] getUniqueKeywords(String[] ls, String... keywords) {
		String[] combined = ArrayUtils.addAll(ls, keywords);
		return this.getUniqueKeywords(combined);
	}
	
	public int countIfContainsAll(String... keywords) {
		String[] keywordList = this.getUniqueKeywords(keywords);
		return this.countIfContainsAll(keywordList, line -> Arrays.stream(keywordList).allMatch(line::contains));
	}
	
	public int countIfContain(String keyword) {
		return this.countIfContainsAll(keyword);
	}
}
