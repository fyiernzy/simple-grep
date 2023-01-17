package Print;

import java.util.*;

import Data.DataTime;

public class DataTimeMapTable extends MapTable<String, DataTime> {
	public static int DEFAULT_WIDTH = 30;
	
	public DataTimeMapTable(HashMap<String,DataTime> map) {
		super(map);
	}
	
	public void printTable() {
		if(this.header != null) {
			for(String label : this.header) {
				System.out.printf("|%s", middleString(label, DEFAULT_WIDTH));
			}
			System.out.println("|");
			System.out.printf(" |%s|%s|%s|\n", "-".repeat(30), "-".repeat(30), "-".repeat(30));
		}
		
		for(DataTime data : this.getList(header)) {
			System.out.printf(" |%s|%s|%s|\n", 
					middleString(data.getStartTime(), 30), middleString(data.getEndTime(), 30), middleString(data.getDuration() + "", 30));
		}
		
		System.out.printf(" |%s|%s|%s|\n", "-".repeat(30), "-".repeat(30), "-".repeat(30));
	}
	
	public void printAnalysis() {
		int totalCount = 0;
		long totalTime = 0;
		
		for(Map.Entry<String, DataTime> entry : this.MAP.entrySet()) {
			DataTime data = entry.getValue();
			
			if (data.getDuration() > 0) {
				totalTime += entry.getValue().getDuration();
				totalCount++;
			}
		}
		
		System.out.println("The average execution time is: " + TimeUtils.convertTime(totalTime / totalCount));
	}
	
	private ArrayList<DataTime> getList(String... startMonths) {
        List<String> monthLs = Arrays.asList(startMonths);
        ArrayList<DataTime> ls = new ArrayList<>();

        for (var entry : this.MAP.entrySet()) {
            DataTime data = entry.getValue();
            if (data.getDuration() > 0 && monthLs.contains(data.getStartMonth())) {
                ls.add(data);
            }
        }

        Collections.sort(ls);

        return ls;
    }
	
	
}
