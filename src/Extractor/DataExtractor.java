package Extractor;

import java.util.HashMap;
import java.util.regex.*;

import Data.DataTime;

import java.io.*;

public class DataExtractor {
	public static final Pattern PATTERN = Pattern.compile("\\[(.*)\\].*JobId=(.*) (done|N.*)");
	
	private final String PATH;
	private HashMap<String, DataTime> map;
	
	public DataExtractor(String path) {
		this.PATH = path;
		this.map = new HashMap<String, DataTime>();
	}
	
	public DataExtractor extractData() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			String line; Matcher matcher;
			
			while((line = reader.readLine()) != null) {
				matcher = PATTERN.matcher(line);
				
				if(matcher.matches()) {
					
					String jobID = matcher.group(2);
					
					if (!map.containsKey(jobID)) {
						map.put(jobID, new DataTime());
					}
					
					if (line.contains("Allocate")) {
						map.get(jobID).setStartTime(matcher.group(1));
						continue;
					}
					
					if (line.contains("job") && line.contains("done")) {
						map.get(jobID).setEndTime(matcher.group(1));
					}
				}
			}
			
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return this;
	}
	
	public HashMap<String, DataTime> getMap() {
		return this.map;
	}
}
