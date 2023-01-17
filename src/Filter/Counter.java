package Filter;

import java.util.*;
import java.util.stream.Stream;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Counter extends FileUtils {
	
	Counter(String filePath) {
		super(filePath);
	}
	
	public int countAllLines() {
		try(Stream<String> lines = Files.lines(Paths.get(this.FILE_PATH))){ 
	        return (int) lines.count(); 
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
	
	public int countIfContainsAll(String... keywords) {
	    Set<String> keywordSet = Set.of(keywords); 
	    try(Stream<String> lines = Files.lines(Paths.get(this.FILE_PATH))){ 
	        return (int) lines
	                .filter(line -> keywordSet.stream().allMatch(line::contains)) 
	                .count(); 
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
	
	public int countIfContain(String keyword) {
		return countIfContainsAll(keyword);
	}
	
//	public HashMap<String, Integer> countKeywords(String... keywords) {
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		
//		for(String sentence : this.CONTENT.toString().split("\n")) {
//			for(String keyword : keywords) {
//				if (sentence.contains(keyword)) {
//					if (!map.containsKey(keyword))
//						map.put(keyword, 0);
//					
//					map.put(keyword, map.get(keyword) + 1);
//				}
//			}
//		}
//		
//		return map;
//	}
}
