package Assignment.PS;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.*;

import Assignment.OOP.DataExtractor;
import Assignment.OOP.DataTime;

import java.io.*;
import Assignment.OOP.*;

public class KillJobFrequency {
	public static void main(String[] args) throws Exception {
		final String DEFAULT = "../WIX1002/src/com/fyiernzy/Assignment/Extracted_File/extracted_log.txt";
        HashMap<String, DataTime> map = new DataExtractor(DEFAULT).extractData().getMap();
        System.out.println(map.size());
        HashSet<String> set = new HashSet<>();
        for(Map.Entry<String, DataTime> entry : map.entrySet()) {
        	if(entry.getValue().getDuration() > 0)
        		set.add(entry.getKey());
        }
        
        System.out.println(set.size());
        final PrintWriter writer = new PrintWriter("./endTimeFactor.csv");
        final Pattern pattern = Pattern.compile("\\[.*T(.*)\\..*\\].*");
        final ArrayList<String> LS = new ArrayList<>();
        Files.lines(Paths.get(DEFAULT))
        	 .filter(line -> set.stream().anyMatch(jobID -> line.contains(jobID) && line.contains("done")))
        	 .forEach(LS::add);
        
        Matcher matcher;
        for(String sentence : LS) {
        	matcher = pattern.matcher(sentence);
        	matcher.matches();
        	writer.println(matcher.group(1));
        }
        writer.close();
        System.out.println(LS.size());
        
	}
}

class KillJobData {
	private boolean isKill;
	
	public void setIsKill() {
		this.isKill = true;
	}
	
	public boolean getIsKill() {
		return this.isKill;
	}
}
